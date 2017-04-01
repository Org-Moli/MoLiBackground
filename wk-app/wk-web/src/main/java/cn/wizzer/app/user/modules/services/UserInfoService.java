package cn.wizzer.app.user.modules.services;

import cn.wizzer.app.user.modules.models.User_Info;
import cn.wizzer.framework.base.service.BaseService;

import java.util.List;
import java.util.Map;

public interface UserInfoService extends BaseService<User_Info> {

    int countUser();

    User_Info findById(Integer id);

    void deleteUserById(Integer id);

    /**
     * 根据单位ID查询空闲司机
     * @param sysUnitId 单位ID
     * @return
     */
    List<User_Info> listUserInfoBySysUnitId(String sysUnitId);


    /***
     * 根据单位ID和经纬度查询空闲司机
     * @param sysUnitId 单位ID
     * @param lon 经度
     * @param lat 维度
     * @return
     */
    List<User_Info> listUserByUnitIdAndLonAndLat(String sysUnitId, double lon, double lat);

    /***
     * 根据经纬度查询空闲司机
     * @param lon 经度
     * @param lat 维度
     * @return
     */
    List<User_Info> listUserByLonAndLat(double lon, double lat);

    /***
     * 根据单位ID，经纬度，范围半径(KM)查询空闲司机
     * @param sysUnitId
     * @param lon
     * @param lat
     * @param radius
     * @return
     */
    List<Map> listUserByUnitIdAndLonAndLatAndRadius(String sysUnitId, double lon, double lat, double radius);

    /***
     * 根据经纬度，范围半径(KM)查询空闲司机
     * @param lon
     * @param lat
     * @param radius
     * @return
     */
    List<Map> listUserByLonAndLatAndRadius(double lon, double lat, double radius);

    /**
     * 查询司机列表
     * @return
     */
    List<Map> listUserByQuery(String queryStr);
}

