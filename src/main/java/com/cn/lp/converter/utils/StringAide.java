package com.cn.lp.converter.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 字符串工具类
 *
 * @author qirong
 */
public class StringAide {

    private static final char DELIM_START = '{';
    private static final char ESCAPE_CHAR = '\\';
    private static final String DELIM_STR = "{}";

    public static Object[] msg(Object... objects) {
        return objects;
    }

    /**
     * 格式化文本
     *
     * @param messagePattern
     * @param argArray
     * @return
     */
    final public static String format(final String messagePattern, final Object... argArray) {
        if (messagePattern == null || argArray == null || argArray.length == 0) {
            return messagePattern;
        }
        int i = 0;

        int delimIndex;
        StringBuffer sbuf = new StringBuffer(messagePattern.length() + 50);

        int index;
        for (index = 0; index < argArray.length; index++) {

            delimIndex = messagePattern.indexOf(DELIM_STR, i);

            if (delimIndex == -1) {
                // no more variables
                // this is a simple string
                if (i == 0) {
                    deeplyAppendParameter(sbuf, argArray[index], new HashMap<Object, Object>());
                    return sbuf.toString();
                } else {
                    // add the tail string which contains no variables and return
                    // the result.
                    sbuf.append(messagePattern.substring(i, messagePattern.length()));
                    return sbuf.toString();
                }
            } else {
                if (isEscapedDelimeter(messagePattern, delimIndex)) {
                    if (!isDoubleEscaped(messagePattern, delimIndex)) {
                        index--; // DELIM_START was escaped, thus should not be incremented
                        sbuf.append(messagePattern.substring(i, delimIndex - 1));
                        sbuf.append(DELIM_START);
                        i = delimIndex + 1;
                    } else {
                        // The escape character preceding the delimiter start is
                        // itself escaped: "abc x:\\{}"
                        // we have to consume one backward slash
                        sbuf.append(messagePattern.substring(i, delimIndex - 1));
                        deeplyAppendParameter(sbuf, argArray[index], new HashMap<Object, Object>());
                        i = delimIndex + 2;
                    }
                } else {
                    // normal case
                    sbuf.append(messagePattern.substring(i, delimIndex));
                    deeplyAppendParameter(sbuf, argArray[index], new HashMap<Object, Object>());
                    i = delimIndex + 2;
                }
            }
        }
        // append the characters following the last {} pair.
        sbuf.append(messagePattern.substring(i, messagePattern.length()));
        if (index < argArray.length - 1) {
            return sbuf.toString();
        } else {
            return sbuf.toString();
        }
    }

    final static boolean isEscapedDelimeter(String messagePattern, int delimeterStartIndex) {
        if (delimeterStartIndex == 0) {
            return false;
        }
        char potentialEscape = messagePattern.charAt(delimeterStartIndex - 1);
        if (potentialEscape == ESCAPE_CHAR) {
            return true;
        } else {
            return false;
        }
    }

    final static boolean isDoubleEscaped(String messagePattern, int delimeterStartIndex) {
        if (delimeterStartIndex >= 2 && messagePattern.charAt(delimeterStartIndex - 2) == ESCAPE_CHAR) {
            return true;
        } else {
            return false;
        }
    }

    // special treatment of array values was suggested by 'lizongbo'
    private static void deeplyAppendParameter(StringBuffer sbuf, Object o, Map<Object, Object> seenMap) {
        if (o == null) {
            sbuf.append("null");
            return;
        }
        if (o instanceof Throwable) {
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                try (PrintStream printStream = new PrintStream(new BufferedOutputStream(outputStream), true)) {
                    ((Throwable) o).printStackTrace(printStream);
                    safeObjectAppend(sbuf, outputStream.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (!o.getClass().isArray()) {
            safeObjectAppend(sbuf, o);
        } else {
            // check for primitive array types because they
            // unfortunately cannot be cast to Object[]
            if (o instanceof boolean[]) {
                booleanArrayAppend(sbuf, (boolean[]) o);
            } else if (o instanceof byte[]) {
                byteArrayAppend(sbuf, (byte[]) o);
            } else if (o instanceof char[]) {
                charArrayAppend(sbuf, (char[]) o);
            } else if (o instanceof short[]) {
                shortArrayAppend(sbuf, (short[]) o);
            } else if (o instanceof int[]) {
                intArrayAppend(sbuf, (int[]) o);
            } else if (o instanceof long[]) {
                longArrayAppend(sbuf, (long[]) o);
            } else if (o instanceof float[]) {
                floatArrayAppend(sbuf, (float[]) o);
            } else if (o instanceof double[]) {
                doubleArrayAppend(sbuf, (double[]) o);
            } else {
                objectArrayAppend(sbuf, (Object[]) o, seenMap);
            }
        }
    }

    private static void safeObjectAppend(StringBuffer sbuf, Object o) {
        try {
            String oAsString = o.toString();
            sbuf.append(oAsString);
        } catch (Throwable t) {
            System.err
                .println("SLF4J: Failed toString() invocation on an object of type ["
                    + o.getClass().getName() + "]");
            t.printStackTrace();
            sbuf.append("[FAILED toString()]");
        }

    }

    private static void objectArrayAppend(StringBuffer sbuf, Object[] a, Map<Object, Object> seenMap) {
        sbuf.append('[');
        if (!seenMap.containsKey(a)) {
            seenMap.put(a, null);
            final int len = a.length;
            for (int i = 0; i < len; i++) {
                deeplyAppendParameter(sbuf, a[i], seenMap);
                if (i != len - 1) {
                    sbuf.append(", ");
                }
            }
            // allow repeats in siblings
            seenMap.remove(a);
        } else {
            sbuf.append("...");
        }
        sbuf.append(']');
    }

    private static void booleanArrayAppend(StringBuffer sbuf, boolean[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void byteArrayAppend(StringBuffer sbuf, byte[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void charArrayAppend(StringBuffer sbuf, char[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void shortArrayAppend(StringBuffer sbuf, short[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void intArrayAppend(StringBuffer sbuf, int[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void longArrayAppend(StringBuffer sbuf, long[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void floatArrayAppend(StringBuffer sbuf, float[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    private static void doubleArrayAppend(StringBuffer sbuf, double[] a) {
        sbuf.append('[');
        final int len = a.length;
        for (int i = 0; i < len; i++) {
            sbuf.append(a[i]);
            if (i != len - 1) {
                sbuf.append(", ");
            }
        }
        sbuf.append(']');
    }

    public static String parseString(Object o) {
        return parseString(o, null);
    }

    public static String parseString(Object o, String defaultValue) {
        if(BlankAide.isBlank(o)) {
            return defaultValue;
        }
        return o.toString();
    }

}
