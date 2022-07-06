package cn.zm.common.base;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: zhihao
 * @Date: 2020/4/15 17:48
 * @Description: json响应 将日期字符串序列化为定制日期字符串响应
 * @Versions 1.0
 **/
public class MyLocalDateTimeSerializer extends SimpleDateFormatSerializer {
    private final String pattern;

    public MyLocalDateTimeSerializer(String pattern) {
        super(pattern);
        this.pattern = pattern;
    }

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null) {
            serializer.out.writeNull();
            return;
        }
        if (object instanceof LocalDateTime){
            LocalDateTime localDateTime = (LocalDateTime) object;
            String format = localDateTime.format(DateTimeFormatter.ofPattern(pattern));
            serializer.write(format);
        }
    }
}
