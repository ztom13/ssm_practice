package com.ztom.library.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author:ztom
 * date:2018/10/25 23:45
 */
public class Date2String implements Converter<Date,String> {
    @Override
    public String convert(Date source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(source);

        return format;
    }
}
