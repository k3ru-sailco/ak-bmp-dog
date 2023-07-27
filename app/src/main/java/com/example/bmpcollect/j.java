package com.example.bmpcollect;
import java.util.Arrays;

public final class j
{
    public static long a(long n) {
        if (n == 0L) {
            return 0L;
        }
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n - (n >>> 1);
    }

    public static String a(final float[] array, final float n, final float n2) {
        final int length = array.length;
        final StringBuilder sb = new StringBuilder();
        final float n3 = (n2 - n) / 60.0f;
        for (int i = 0; i < length; ++i) {
            char c = (char)((int)Math.floor((array[i] - n) / n3) + 65);
            if (array[i] == n2) {
                c = '}';
            }
            char c2;
            if (c == '\\') {
                c2 = '.';
            }
            else if ((c2 = c) == '.') {
                c2 = '\\';
            }
            sb.append(c2);
        }
        return sb.toString();
    }

    public static float b(final float[] array, float floatValue) {
        final int length = array.length;
        final Float[] a = new Float[length];
        final int n = 0;
        for (int i = 0; i < length; ++i) {
            a[i] = Math.abs(array[i]);
        }
        Arrays.sort(a);
        floatValue = a[(int)Math.floor((length - 1) * floatValue)];
        for (int j = n; j < length; ++j) {
            if (Math.abs(array[j]) < floatValue) {
                array[j] = 0.0f;
            }
        }
        return floatValue;
    }

    public static String k(final float[] array) {
        if (array == null) {
            return "(null)";
        }
        if (array.length == 0) {
            return "(empty)";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < array.length; ++i) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(String.format("%.2f", array[i]));
        }
        sb.append(")");
        return sb.toString();
    }
}
