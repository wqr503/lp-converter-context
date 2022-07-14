package com.cn.lp.converter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对象转换映射
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface ConverterMapping {

    /** 是否忽略泛型 */
    boolean ignoreGenericType() default false;

    /** 忽略空值 */
    boolean ignoreEmpty() default false;

    /** 匹配类型 */
    boolean matchType() default false;

}
