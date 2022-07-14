package com.cn.lp.converter.utils;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 空判断
 */
public class BlankAide {

    /**
     * <p>Checks if a String is whitespace, empty ("") or null.</p>
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param str  the String to check, may be null
     * @return <code>true</code> if the String is null, empty or whitespace
     * @since 2.0
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((!Character.isWhitespace(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String setDefaultIfBlank(String str, String defaultValue) {
        return isBlank(str) ? defaultValue : str;
    }

    /**
     * 方法用途和描述: 判断字符是否为空
     * <p>方法的实现逻辑描述（如果是接口方法可以不写）：
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank(' ')        = true
     * StringUtils.isBlank('a')        = false
     */
    public static boolean isBlank(final Character cha) {
        return (cha == null) || cha.equals(' ');
    }

    public static boolean isNotBlank(final Character cha) {
        return !isBlank(cha);
    }

    public static Character setDefaultIfBlank(Character str, Character defaultValue) {
        return isBlank(str) ? defaultValue : str;
    }

    /**
     * 方法用途和描述: 判断字符是否为空
     * <p>方法的实现逻辑描述（如果是接口方法可以不写）：
     * StringUtils.isBlank(null)      = true
     */
    public static boolean isBlank(final Object obj) {
        return (obj == null);
    }

    public static boolean isNotBlank(final Object obj) {
        return !isBlank(obj);
    }

    public static <O> O setDefaultIfBlank(O str, O defaultValue) {
        return isBlank(str) ? defaultValue : str;
    }

    /**
     * 方法用途和描述: 判断数组是否为空
     * <p>方法的实现逻辑描述（如果是接口方法可以不写）：
     */
    public static <O> boolean isBlank(final O[] objs) {
        return (objs == null) || (objs.length <= 0);
    }

    public static <O> boolean isNotBlank(final O[] objs) {
        return !isBlank(objs);
    }

    public static <O> O[] setDefaultIfBlank(O[] str, O[] defaultValue) {
        return isBlank(str) ? defaultValue : str;
    }

    /**
     * 方法用途和描述: 判断数组是否为空
     * <p>方法的实现逻辑描述（如果是接口方法可以不写）：
     */
    public static boolean isBlank(final Collection<?> obj) {
        return (obj == null) || obj.isEmpty();
    }

    public static boolean isNotBlank(final Collection<?> obj) {
        return !isBlank(obj);
    }

    public static <T>  Collection<T> setDefaultIfBlank(Collection<T> str, Collection<T> defaultValue) {
        return isBlank(str) ? defaultValue : str;
    }

    /**
     * 方法用途和描述: 判断Set是否为空
     * <p>方法的实现逻辑描述（如果是接口方法可以不写）：
     */
    public static boolean isBlank(final Set<?> obj) {
        return (obj == null) || obj.isEmpty();
    }

    public static boolean isNotBlank(final Set<?> obj) {
        return !isBlank(obj);
    }

    public static <T>  Set<T> setDefaultIfBlank(Set<T> str, Set<T> defaultValue) {
        return isBlank(str) ? defaultValue : str;
    }

    /**
     * 方法用途和描述: 判断Serializable是否为空
     * <p>方法的实现逻辑描述（如果是接口方法可以不写）：
     */
    public static boolean isBlank(final Serializable obj) {
        return obj == null;
    }

    public static boolean isNotBlank(final Serializable obj) {
        return !isBlank(obj);
    }

    /**
     * 方法用途和描述: 判断Map是否为空
     * <p>方法的实现逻辑描述（如果是接口方法可以不写）：
     * @param obj
     * @return
     * @author huangtao 新增日期：2008-4-21
     * @author huangtao 修改日期：2008-4-21
     */
    public static boolean isBlank(final Map<?,?> obj) {
        return (obj == null) || obj.isEmpty();
    }

    public static boolean isNotBlank(final Map<?,?> obj) {
        return !isBlank(obj);
    }

    public static <K,V> Map<K,V> setDefaultIfBlank(Map<K,V> str, Map<K,V> defaultValue) {
        return isBlank(str) ? defaultValue : str;
    }

}
