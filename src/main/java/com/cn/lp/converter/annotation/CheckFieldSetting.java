package com.cn.lp.converter.annotation;

import java.lang.annotation.*;

/**
 * 检查字段是否有配置
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface CheckFieldSetting {

    /**
     * 目标注释，拥有该注释的字段不检查
     */
    Class<? extends Annotation>[] checkFieldIgnoreAnnotation() default {};

    /**
     * 目标注释，拥有该注释的字段才检查
     */
    Class<? extends Annotation>[] checkFieldAnnotation() default {};

    /**
     * 目标字段才检查
     */
    String[] checkFieldName() default {};

}
