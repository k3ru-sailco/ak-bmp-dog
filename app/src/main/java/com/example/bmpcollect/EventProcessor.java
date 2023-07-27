package com.example.bmpcollect;

import android.util.Pair;

import java.util.Locale;

public class EventProcessor {
    public static Pair<String, Long> a(float[] array, float f) {
        Object o = "";
        final String s = "Incorrect sensor data";
        long k = 0L;
        String string = null;
        Label_0780: {
            Label_0724: {
                try {
                    int length = array.length;
                    final float[] obj = new float[length];
                    System.arraycopy(array, 0, obj, 0, array.length);
                    new StringBuilder("Input for Simple Quantization encoding: ").append(j.k(array));
                    final Pair<Float, Float> jPair= j(array);
                    final float floatValue = (float)jPair.first;
                    final float floatValue2 = (float)jPair.second;
                    new StringBuilder("min and max of SimpQuant data: min(").append(floatValue).append("), max(").append(floatValue2).append(")");
                    final String a = i.a(j.a(array, floatValue, floatValue2));
                    final int length2 = a.length();
                    final long bh = com.example.bmpcollect.f.bH(a);
                    final float al = al(floatValue);
                    final float al2 = al(floatValue2);
                    final Locale us = Locale.US;
                    try {
                        o = new ltwo(String.format(us, "2;%.2f;%.2f;%d;%s", al, al2, bh, a), length2, Math.round(al * 100.0f + al2 * 100.0f) + bh);
                        final int intValue = (int)((ltwo)o).b;
                        new StringBuilder("Input for DCT encoding: ").append(j.k(obj));
//                        if (Build$VERSION.SDK_INT >= 19) {
//                            Objects.requireNonNull(obj);
//                        }
                        if (Integer.bitCount(length) == 1) {
                            h.a(obj, 0, length, new float[length]);
                            new StringBuilder("Fast DCT Encoded: ").append(j.k(obj));
                            new StringBuilder("Shrinked DCT (").append(f).append(")<").append(j.b(obj, f)).append(">: ").append(j.k(obj));
                            final float f2 = obj[0];
                            array = new float[--length];
                            System.arraycopy(obj, 1, array, 0, length);
                            final Pair<Float, Float> iPair = j(array);
                            f = (float)iPair.first;
                            final float floatValue3 = (float)iPair.second;
                            new StringBuilder("Coef, min and max of DCT data: Coef(").append(f2).append("), min(").append(f).append("), max(").append(floatValue3).append(")");
                            final String a2 = i.a(j.a(array, f, floatValue3));
                            final int length3 = a2.length();
                            final long bh2 = com.example.bmpcollect.f.bH(a2);
                            f = al(f);
                            final float al3 = al(floatValue3);
                            final float al4 = al(f2);
                            array = (float[])(Object)String.format(Locale.US, "1;%.2f;%.2f;%.2f;%d;%s", f, al3, al4, bh2, a2);
                            final ltwo l = new ltwo(array, length3, Math.round(f * 100.0f + al3 * 100.0f + al4 * 100.0f) + bh2);
                            Label_0660:
                            {
//                                if (intValue - (int)l.b >= 20) {
//                                    break Label_0660;
//                                }
//                                final Object o2 = array = (float[])(Object)((l)o).a;
//                                try {
//                                    k = (long)((l)o).c;
//                                    array = (float[])o2;
//                                    string = s;
//                                    break Label_0780;
////                                    final Object o3 = array = (float[])(Object)l.a;
//                                    k = (long)l.c;
////                                    array = (float[])o3;
//                                    string = s;
//                                    break Label_0780;
//                                }
//                                catch (Exception ex) {
//                                    break Label_0724;
//                                }
//                            }
                            }
                        }
                        throw new IllegalArgumentException("Length must be power of 2");
                    }
                    catch (Exception ex) {
                        array = (float[])(Object)"";
                    }
                }
                catch (Exception ex) {
                    array = (float[])o;
                }
            }
            final Exception ex;
//            final String message = ex.getMessage();
//            System.out.println("DctEncoding" +  "Failed in DCT processing: " + message);
//            string = "Incorrect sensor data" + ": " + message;
            k = 0L;
        }
        if (((String)(Object)array).isEmpty()) {
            System.out.println("DctEncoding"+ new Throwable[0]);
            array = (float[])(Object)"0;".concat(String.valueOf(string));
            k = 0L;
        }
        return (Pair<String, Long>)new Pair((Object)array, (Object)k);
    }

    private static float al(final float n) {
        return Math.round(n * 100.0f) / 100.0f;
    }

    private static Pair<Float, Float> j(final float[] array) {
        int i = 0;
        float f = array[0];
        float f2 = array[0];
        while (i < array.length) {
            final float n = array[i];
            float n2;
            float n3;
            if (n < f) {
                n2 = n;
                n3 = f2;
            }
            else {
                n2 = f;
                n3 = f2;
                if (n > f2) {
                    n3 = n;
                    n2 = f;
                }
            }
            ++i;
            f = n2;
            f2 = n3;
        }
        return (Pair<Float, Float>)new Pair((Object)f, (Object)f2);
    }
}
