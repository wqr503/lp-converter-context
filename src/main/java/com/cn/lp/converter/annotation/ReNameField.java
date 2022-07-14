package com.cn.lp.converter.annotation;

/** 改名字段 */
public @interface ReNameField {

    /** 源字段名 */
    String sourceName();
    /** 目标字段名 */
    String targetName();

}
