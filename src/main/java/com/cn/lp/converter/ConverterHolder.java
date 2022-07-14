package com.cn.lp.converter;

import java.util.*;

/**
 * Converter持有者，Converter都会注册到这里
 */
public class ConverterHolder {

    public static final String BEAN_SUFFIX = "_ConverterImpl";

    private static Map<Class<?>, Converter> converterMap = new HashMap<>();

    public static void registerConverter(Class<?> clazz, Converter converter, boolean replace) {
        if(converter != null) {
            Converter oldConverter = converterMap.get(clazz);
            if(oldConverter == null || replace) {
                converterMap.put(clazz, converter);
            }
        }
    }

    public static void registerConverter(Class<?> clazz, Converter converter) {
        registerConverter(clazz, converter, false);
    }

    public static <B extends Converter> B getConverter(Class<B> clazz) {
        try {
            Class.forName(clazz.getName() + BEAN_SUFFIX);
        } catch (ClassNotFoundException e) {

        }
        return  (B)converterMap.get(clazz);
    }

}
