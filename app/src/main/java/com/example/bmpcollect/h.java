package com.example.bmpcollect;


public final class h
{
    static void a(final float[] array, int n, final int n2, final float[] array2) {
        if (n2 == 1) {
            return;
        }
        final int n3 = n2 / 2;
        final int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            final int n5 = n + i;
            final float n6 = array[n5];
            final float n7 = array[n + n2 - 1 - i];
            array2[n5] = n6 + n7;
            array2[n5 + n3] = (n6 - n7) / ((float)Math.cos((i + 0.5) * 3.141592653589793 / n2) * 2.0f);
        }
        a(array2, n, n3, array);
        final int n8 = n + n3;
        a(array2, n8, n3, array);
        for (int j = n4; j < n3 - 1; ++j) {
            final int n9 = j * 2 + n;
            final int n10 = n + j;
            array[n9 + 0] = array2[n10];
            final int n11 = n10 + n3;
            array[n9 + 1] = array2[n11] + array2[n11 + 1];
        }
        n += n2;
        array[n - 2] = array2[n8 - 1];
        --n;
        array[n] = array2[n];
    }
}
