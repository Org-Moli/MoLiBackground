package cn.wizzer.app.user.modules.services.impl;

import cn.wizzer.app.user.modules.models.User_Info;
import cn.wizzer.app.user.modules.services.UserInfoService;
import cn.wizzer.app.utils.ResultToSetUtils;
import cn.wizzer.framework.base.service.BaseServiceImpl;
import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.distance.DistanceUtils;
import com.spatial4j.core.io.GeohashUtils;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.ioc.loader.annotation.IocBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/3/22
 */
@IocBean(args = {"refer:dao"})
public class UserInfoServiceImpl extends BaseServiceImpl<User_Info> implements UserInfoService{
    public UserInfoServiceImpl(Dao dao)
    {
        super(dao);
    }

    @Override
    public int countUser()
    {
        return this.count("user_info");
    }

    @Override
    public User_Info findById(Integer id) {
        return this.fetch(id);
    }

    @Override
    public void deleteUserById(Integer id) {
        User_Info user_info = this.fetch(id);
        dao().delete(user_info);
    }

    /**
     * 根据单位ID查询空闲司机
     * @param sysUnitId 单位ID
     * @return
     */
    @Override
    public List<User_Info> listUserInfoBySysUnitId(String sysUnitId)
    {
        return this.query(Cnd.where("sysUnitId", "=", sysUnitId).and("workStatus","=",1).and("userStatus","=",1));
    }

    /***
     * 根据单位ID和经纬度查询空闲司机
     * @param sysUnitId 单位ID
     * @param lon 经度
     * @param lat 维度
     * @return
     */
    @Override
    public List<User_Info> listUserByUnitIdAndLonAndLat(String sysUnitId, double lon, double lat)
    {
        //默认周围2.4KM
        String geocode = GeohashUtils.encodeLatLon(lat, lon, 5);
        Condition c = Cnd.where("sysUnitId", "=", sysUnitId)
                        .and("geo_code", "like", "%" + geocode + "%")
                        .and("workStatus", "=", 1).and("userStatus","=",1);
        return this.query(c);
    }

    /***
     * 根据经纬度查询空闲司机
     * @param lon 经度
     * @param lat 维度
     * @return
     */
    @Override
    public List<User_Info> listUserByLonAndLat(double lon, double lat)
    {
        //默认周围2.4KM
        String geocode = GeohashUtils.encodeLatLon(lat, lon, 5);
        Condition c = Cnd.where("geo_code","like","%" + geocode + "%")
                        .and("workStatus", "=", 1).and("userStatus", "=", 1);
        return this.query(c);
    }

    /***
     * 根据单位ID，经纬度，范围半径(KM)查询空闲司机
     * @param sysUnitId
     * @param lon
     * @param lat
     * @param radius
     * @return
     */
    @Override
    public List<Map> listUserByUnitIdAndLonAndLatAndRadius(String sysUnitId, double lon, double lat, double radius)
    {
        int p = getPrecision(radius);
        String geocode = GeohashUtils.encodeLatLon(lat, lon, p);
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append("select \n");
        sqlBuffer.append("        id, \n");
        sqlBuffer.append("        nickName, \n");
        sqlBuffer.append("        userName, \n");
        sqlBuffer.append("        sex, \n");
        sqlBuffer.append("        jobNumber, \n");
        sqlBuffer.append("        mobile, \n");
        sqlBuffer.append("        workStatus, \n");
        sqlBuffer.append("        userStatus, \n");
        sqlBuffer.append("        balance, \n");
        sqlBuffer.append("        lon, \n");
        sqlBuffer.append("        lat \n");
        sqlBuffer.append("from user_info \n");
        sqlBuffer.append("where   1 = 1 \n");
        sqlBuffer.append("        and sysUnitId = '" + sysUnitId + "' \n");
        sqlBuffer.append("        and geo_code like '%" + geocode + "%' \n");
        sqlBuffer.append("        and workStatus = 1 \n");
        sqlBuffer.append("        and userStatus = 1 \n");

        Sql sql = Sqls.create(sqlBuffer.toString());
        sql.setCallback(new SqlCallback() {
            public Object invoke(Connection conn, ResultSet rs, Sql sql) throws SQLException
            {
                List<Map> list = new LinkedList<Map>();
                while (rs.next())
                {
                    Map map = new HashMap();
                    map.put("id", rs.getInt("id"));
                    map.put("nickName", rs.getString("nickName"));
                    map.put("userName",rs.getString("userName"));
                    map.put("sex",rs.getInt("sex"));
                    map.put("jobNumber", rs.getString("jobNumber"));
                    map.put("mobile", rs.getString("mobile"));
                    map.put("workStatus", rs.getInt("workStatus"));
                    map.put("userStatus", rs.getInt("userStatus"));
                    map.put("balance", rs.getDouble("balance"));
                    map.put("lon", rs.getDouble("lon"));
                    map.put("lat", rs.getDouble("lat"));
                    list.add(map);
                }
                return list;
            }
        });
        dao().execute(sql);
        List<Map> userList = sql.getList(Map.class);
        userList.stream().forEach(u -> {
            double userLon = (Double)u.get("lon");
            double userLat = (Double)u.get("lat");
            SpatialContext geo = SpatialContext.GEO;
            double distance = geo.calcDistance(geo.makePoint(lon, lat), geo.makePoint(userLon, userLat))
                    * DistanceUtils.DEG_TO_KM;
            u.put("distance",distance);
         });
        return userList.stream().filter(m -> (Double)m.get("distance") <= radius).collect(toList());
    }

    /***
     * 根据经纬度，范围半径(KM)查询空闲司机
     * @param lon
     * @param lat
     * @param radius
     * @return
     */
    @Override
    public List<Map> listUserByLonAndLatAndRadius(double lon, double lat, double radius)
    {
        int p = getPrecision(radius);
        String geocode = GeohashUtils.encodeLatLon(lat, lon, p);
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append("select \n");
        sqlBuffer.append("        id, \n");
        sqlBuffer.append("        nickName, \n");
        sqlBuffer.append("        userName, \n");
        sqlBuffer.append("        sex, \n");
        sqlBuffer.append("        jobNumber, \n");
        sqlBuffer.append("        mobile, \n");
        sqlBuffer.append("        workStatus, \n");
        sqlBuffer.append("        userStatus, \n");
        sqlBuffer.append("        balance, \n");
        sqlBuffer.append("        lon, \n");
        sqlBuffer.append("        lat \n");
        sqlBuffer.append("from user_info \n");
        sqlBuffer.append("where   1 = 1 \n");
        sqlBuffer.append("        and geo_code like '%" + geocode + "%' \n");
        sqlBuffer.append("        and workStatus = 1 \n");
        sqlBuffer.append("        and userStatus = 1 \n");

        Sql sql = Sqls.create(sqlBuffer.toString());
        sql.setCallback(new SqlCallback() {
            public Object invoke(Connection conn, ResultSet rs, Sql sql) throws SQLException
            {
                List<Map> list = new LinkedList<Map>();
                while (rs.next())
                {
                    Map map = new HashMap();
                    map.put("id", rs.getInt("id"));
                    map.put("nickName", rs.getString("nickName"));
                    map.put("userName",rs.getString("userName"));
                    map.put("sex",rs.getInt("sex"));
                    map.put("jobNumber", rs.getString("jobNumber"));
                    map.put("mobile", rs.getString("mobile"));
                    map.put("workStatus", rs.getInt("workStatus"));
                    map.put("userStatus", rs.getInt("userStatus"));
                    map.put("balance", rs.getDouble("balance"));
                    map.put("lon", rs.getDouble("lon"));
                    map.put("lat", rs.getDouble("lat"));
                    list.add(map);
                }
                return list;
            }
        });
        dao().execute(sql);
        List<Map> userList = sql.getList(Map.class);
        userList.stream().forEach(u -> {
            double userLon = (Double)u.get("lon");
            double userLat = (Double)u.get("lat");
            SpatialContext geo = SpatialContext.GEO;
            double distance = geo.calcDistance(geo.makePoint(lon, lat), geo.makePoint(userLon, userLat))
                    * DistanceUtils.DEG_TO_KM;
            u.put("distance",distance);
        });
        return userList.stream().filter(m -> (Double)m.get("distance") <= radius).collect(toList());
    }

    private int getPrecision(double radius)
    {
        int precision = 5;
        if(radius >= 630)
        {
            precision = 1;
        }
        else if(radius >= 78 && radius < 630)
        {
            precision = 2;
        }
        else if(radius >= 20 && radius < 78)
        {
            precision = 3;
        }
        else if(radius >= 2.4 && radius < 20)
        {
            precision = 4;
        }
        else if(radius >= 0.61 && radius < 2.4)
        {
            precision = 5;
        }
        else if(radius >= 0.076 && radius < 0.61)
        {
            precision = 6;
        }
        else if(radius >= 0.019 && radius < 0.076)
        {
            precision = 7;
        }
        else if(radius < 0.019)
        {
            precision = 8;
        }
        return precision;
    }
}
