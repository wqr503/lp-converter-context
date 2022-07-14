package com.cn.lp.converter;

/**
 * 对象转换
 */
public interface BeanConverter<S, T> extends Converter{

    /** 转换 S -> T */
    T convertTo(S source);

    /** 合并 S -> T */
    MergeResult<T> mergeTo(S source, T target);

    default T postConvertTo(S source, T target) {
        return target;
    }

    default MergeResult<T> postMergeTo(S source, T target, MergeResult<T> result) {
        return result;
    }

}
