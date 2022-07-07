package cn.zm.common.base;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: zhihao
 * @Date: 2020/4/15 17:08
 * @Description: json请求 将日期字符串反序列化为绑定到@requestBody对象上
 * @Versions 1.0
 **/
public class MyLocalDateTimeDeserializer extends AbstractDateDeserializer {

    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    @Override
    protected <T> T cast(DefaultJSONParser parser, Type clazz, Object fieldName, Object value) {
        String dateStr = null;
        if (value instanceof  String){
            dateStr =  ((String) value);
        }else if (StringUtils.isBlank(dateStr)){
            return null;
        }
        //去前后空格
        dateStr = dateStr.trim();
        //判断是否yyyy-MM-dd格式
        if (dateStr.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
            //yyyy-MM-dd 会构建成yyyy-MM-dd 00:00:00
            return (T) LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(YYYY_MM_DD)).atStartOfDay();
            //判断是否yyyy-MM-dd HH:mm:ss格式
        } else if (dateStr.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return (T) LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS));
        } else {
            //都不匹配说明请求格式不正确
            throw new DateTimeException("Date Format IsWrong :" + dateStr);
        }
    }

    @Override
    public int getFastMatchToken() {
        return JSONToken.LITERAL_STRING;
    }
}
