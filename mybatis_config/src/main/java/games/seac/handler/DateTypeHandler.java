package games.seac.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 自定义类型处理器，用于将java类型的数据和数据库需要的类型数据相互转换
 * @author Honmono
 * @date 2021/12/11 - 10:44
 */
public class DateTypeHandler extends BaseTypeHandler<Date> {
    //将java类型转换成数据库需要的类型
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        preparedStatement.setLong(i,time);
    }

    //将数据库中的类型转换成java类型
    //String参数 s 要转换的字段名称
    //ResultSet resultSet 查询出的结果集
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        //获得结果集中需要的数据(long) 转换成Date类型 返回
        long aLong = resultSet.getLong(s);
        Date date = new Date(aLong);
        return date;
    }
    //将数据库中的类型转换成java类型
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        //获得结果集中需要的数据(long) 转换成Date类型 返回
        long aLong = resultSet.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
    //将数据库中的类型转换成java类型
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
}
