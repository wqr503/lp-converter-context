package com.cn.lp.converter.annotation;

import java.lang.annotation.*;

/**
 * 对象转换器
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface ConverterMapper {

    /** 是否忽略泛型 */
    boolean ignoreGenericType() default false;

    /** 是否实现spring接口 */
    boolean implSpringInterface() default false;

    /** 忽略空值 */
    boolean ignoreEmpty() default false;

    /**
     * 目标忽略注释，拥有该注释的字段不生效
     */
    Class<? extends Annotation>[] assignIgnoreAnnotation() default {};

    /**
     * 目标注释，拥有该注释的字段才生效
     */
    Class<? extends Annotation>[] assignAnnotation() default {};

    /**
     * 目标字段才生效
     */
    String[] assignFieldName() default {};

    /**
     * 改名字段
     */
    ReNameField[] reNameField() default {};

    /** 匹配类型 */
    boolean matchType() default false;

}
