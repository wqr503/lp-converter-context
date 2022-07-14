package com.cn.lp.converter;

import java.util.Map;

/**
 *  map转换器
 */
public interface MapConverter<S> extends Converter{

    /** 转换 map -> S */
    S convertFromMap(Map<String,Object> dataSource);

    /** 转换Map S -> map */
    Map<String,Object> convertToMap(S source);

    default Map<String,Object> postConvertToMap(S source, Map<String,Object> dataSource) {
        return dataSource;
    }

    default S preConvertFromMap(Map<String,Object> dataSource, S source) {
        return source;
    }

}
