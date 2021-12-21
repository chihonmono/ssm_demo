package games.seac.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Honmono
 * @date 2021/11/20 - 13:40
 */
public class DateConverter implements Converter<String,Date> {


    public Date convert(String dateStr) {
        //将日期字符串转换为日期对象
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
