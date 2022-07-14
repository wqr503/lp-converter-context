package com.cn.lp.converter;

import com.cn.lp.converter.annotation.TypeChangeMethod;
import com.cn.lp.converter.utils.BlankAide;

/**
 * 通用类型转换
 */
public interface CommonTypeChange {

    @TypeChangeMethod
    default String defaultToString(Object obj) {
        if(BlankAide.isNotBlank(obj)) {
            return obj.toString();
        }
        return null;
    }

    @TypeChangeMethod
    default int number2Int(Number number) {
        if(BlankAide.isNotBlank(number)) {
            return number.intValue();
        }
        return 0;
    }

    @TypeChangeMethod
    default boolean boxBoolean2UnBox(Boolean flag) {
        if(BlankAide.isNotBlank(flag)) {
            return flag;
        }
        return false;
    }

    @TypeChangeMethod
    default char boxChar2UnBox(Character data) {
        if(BlankAide.isNotBlank(data)) {
            return data;
        }
        return '\u0000';
    }

    @TypeChangeMethod
    default byte number2Byte(Number number) {
        if(BlankAide.isNotBlank(number)) {
            return number.byteValue();
        }
        return 0;
    }

    @TypeChangeMethod
    default double number2Double(Number number) {
        if(BlankAide.isNotBlank(number)) {
            return number.doubleValue();
        }
        return 0;
    }

    @TypeChangeMethod
    default long number2Long(Number number) {
        if(BlankAide.isNotBlank(number)) {
            return number.longValue();
        }
        return 0;
    }

    @TypeChangeMethod
    default float number2Float(Number number) {
        if(BlankAide.isNotBlank(number)) {
            return number.floatValue();
        }
        return 0;
    }

    @TypeChangeMethod
    default short number2Short(Number number) {
        if(BlankAide.isNotBlank(number)) {
            return number.shortValue();
        }
        return 0;
    }

    @TypeChangeMethod
    default Integer string2Integer(String string) {
        if(BlankAide.isNotBlank(string)) {
            return Integer.valueOf(string);
        }
        return null;
    }

    @TypeChangeMethod
    default Byte String2Byte(String string) {
        if(BlankAide.isNotBlank(string)) {
            return Byte.valueOf(string);
        }
        return null;
    }

    @TypeChangeMethod
    default Double String2Double(String string) {
        if(BlankAide.isNotBlank(string)) {
            return Double.valueOf(string);
        }
        return null;
    }

    @TypeChangeMethod
    default Long String2Long(String string) {
        if(BlankAide.isNotBlank(string)) {
            return Long.valueOf(string);
        }
        return null;
    }

    @TypeChangeMethod
    default Float String2Float(String string) {
        if(BlankAide.isNotBlank(string)) {
            return Float.valueOf(string);
        }
        return null;
    }

    @TypeChangeMethod
    default Short String2Short(String string) {
        if(BlankAide.isNotBlank(string)) {
            return Short.valueOf(string);
        }
        return null;
    }

    @TypeChangeMethod
    default int string2UnBoxInteger(String string) {
        if(BlankAide.isNotBlank(string)) {
            return Integer.parseInt(string);
        }
        return 0;
    }

    @TypeChangeMethod
    default byte String2UnBoxByte(String string) {
        if(BlankAide.isNotBlank(string)) {
            return Byte.parseByte(string);
        }
        return 0;
    }

    @TypeChangeMethod
    default double String2UnBoxDouble(String string) {
        if(BlankAide.isNotBlank(string)) {
            return Double.parseDouble(string);
        }
        return 0;
    }

    @TypeChangeMethod
    default long String2UnBoxLong(String string) {
        if(BlankAide.isNotBlank(string)) {
            return Long.parseLong(string);
        }
        return 0;
    }

    @TypeChangeMethod
    default float String2UnBoxFloat(String string) {
        if(BlankAide.isNotBlank(string)) {
            return Float.parseFloat(string);
        }
        return 0;
    }

    @TypeChangeMethod
    default short String2UnBoxShort(String string) {
        if(BlankAide.isNotBlank(string)) {
            return Short.parseShort(string);
        }
        return 0;
    }

    @TypeChangeMethod
    default String int2String(int num) {
        return String.valueOf(num);
    }

    @TypeChangeMethod
    default String byte2String(byte num) {
        return String.valueOf(num);
    }

    @TypeChangeMethod
    default String double2String(double num) {
        return String.valueOf(num);
    }

    @TypeChangeMethod
    default String long2String(long num) {
        return String.valueOf(num);
    }

    @TypeChangeMethod
    default String float2String(float num) {
        return String.valueOf(num);
    }

    @TypeChangeMethod
    default String short2String(short num) {
        return String.valueOf(num);
    }

}
