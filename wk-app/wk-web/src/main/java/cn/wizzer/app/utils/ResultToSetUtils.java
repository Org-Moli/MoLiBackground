package cn.wizzer.app.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/3/2
 */
public class ResultToSetUtils {

    /**
     * 循环获取属性
     * @param metaData
     * @param rs
     * @return
     */
    public static List<Map> listMap(ResultSetMetaData metaData, ResultSet rs)
    {
        List<Map> list = new LinkedList<Map>();
        try
        {
            while (rs.next())
            {
                Map map = new HashMap<>();
                for(int i = 1; i <= metaData.getColumnCount(); i++)
                {
                    String columnLabel = metaData.getColumnLabel(i);
                    //String mysqlType = metaData.getColumnTypeName(i);
                    map.put(columnLabel,rs.getObject(columnLabel));
                    //System.out.println("columnLabel:" + columnLabel + "|mysqlType:" + mysqlType);
                    /*if(mysqlType.equalsIgnoreCase("INT"))
                    {
                        map.put(columnLabel,(rs.getObject(columnLabel) == null ? null : rs.getInt(columnLabel)));
                    }else  if(mysqlType.equalsIgnoreCase("BIGINT"))
                    {
                        map.put(columnLabel,(rs.getObject(columnLabel) == null ? null : rs.getInt(columnLabel)));
                    }
                    else if(mysqlType.equalsIgnoreCase("LONG"))
                    {
                        map.put(columnLabel,(rs.getObject(columnLabel) == null ? null : rs.getLong(columnLabel)));
                    }else if(mysqlType.equalsIgnoreCase("DOUBLE"))
                    {
                        map.put(columnLabel,(rs.getObject(columnLabel) == null ? null : rs.getDouble(columnLabel)));
                    }else if(mysqlType.equalsIgnoreCase("DECIMAL"))
                    {
                        map.put(columnLabel,(rs.getObject(columnLabel) == null ? null : rs.getBigDecimal(columnLabel)));
                    }else if(mysqlType.equalsIgnoreCase("VARCHAR"))
                    {
                        map.put(columnLabel,(rs.getObject(columnLabel) == null ? null : rs.getString(columnLabel)));
                    }else if(mysqlType.contains("DATE"))
                    {
                        map.put(columnLabel,(rs.getObject(columnLabel) == null ? null : rs.getDate(columnLabel)));
                    }else if(mysqlType.equalsIgnoreCase("TINYINT"))
                    {
                        map.put(columnLabel,(rs.getObject(columnLabel) == null ? null : rs.getBoolean(columnLabel)));
                    }*/
                }
                list.add(map);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
