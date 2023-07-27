package com.example.bmpcollect;

public final class i
{
    public static String a(final String s) {
        final int length = s.length();
        final StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < length) {
            final int n = i + 1;
            final char char1 = s.charAt(i);
            int j = 1;
            for (i = n; i < length && char1 == s.charAt(i); ++i) {
                ++j;
            }
            if (j > 1) {
                sb.append(String.valueOf(j));
            }
            sb.append(char1);
        }
        return sb.toString();
    }
}