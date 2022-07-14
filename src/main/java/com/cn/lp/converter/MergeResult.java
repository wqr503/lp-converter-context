package com.cn.lp.converter;

import com.cn.lp.converter.utils.BlankAide;

import java.util.HashSet;
import java.util.Set;

/**
 * 合并结果
 */
public class MergeResult<T> {

    private T entity;

    private boolean change = false;

    private Set<String> changeFieldNames = new HashSet<>();

    public static <T> MergeResult<T> build(T entity, Set<String> changeFieldNames) {
        MergeResult<T> result = new MergeResult<T>();
        result.entity = entity;
        if(BlankAide.isNotBlank(changeFieldNames)) {
            result.changeFieldNames = changeFieldNames;
            result.change = true;
        }
        return result;
    }

    public Set<String> getChangeFieldNames() {
        return changeFieldNames;
    }

    public T getEntity() {
        return entity;
    }

    public boolean isChange() {
        return change;
    }
}
