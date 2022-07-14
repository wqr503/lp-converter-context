package com.cn.lp.converter.annotation;

import java.lang.annotation.*;

/**
 * 类型转换方法注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface TypeChangeMethod {

    /**
     * 目标忽略注释，拥有该注释的字段不生效
     */
    Class<? extends Annotation>[] assignIgnoreAnnotation() default {};

    /**
     * 目标注释，拥有该注释的字段才生效
     */
    Class<? extends Annotation>[] assignAnnotation() default {};

    /**
     * 是否主要的，优先级提高
     */
    boolean primary() default false;

    /**
     * 目标字段才生效
     */
    String[] assignFieldName() default {};

}
