package com.example.bmpcollect;

import android.content.Context;
import android.os.SystemClock;
import android.hardware.SensorEvent;
import android.app.Application;
import android.os.HandlerThread;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.util.Pair;

import java.util.Observable;

public class MotionListener extends Observable implements SensorEventListener {
    public SensorManager a;
    public Sensor b;
    public Sensor c;
    public HandlerThread d;
    public long e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public float k;
    public int l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private final float[] v;

    public MotionListener(final Application application) {
        this.e = 0L;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.m = -1.0f;
        this.n = -1.0f;
        this.o = -1.0f;
        this.p = -1.0f;
        this.q = -1.0f;
        this.r = -1.0f;
        this.s = -1.0f;
        this.t = -1.0f;
        this.u = -1.0f;
        this.k = 0.0f;
        this.v = new float[] { 0.0f, 0.0f, 0.0f };
        this.l = 0;
        try {
            this.a = (SensorManager)application.getSystemService(Context.SENSOR_SERVICE);
        }
        catch (Exception ex) {
            return;
        }
    }

    public static String aha(final String s) {
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

    private static Pair<Float, Float> minmax(final float[] array) {
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

    public static String aia(final float[] array, final float n, final float n2) {
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

    public static String formattedCollection(final float[] array) {
        if (array == null) {
            return "(null)";
        }
        if (array.length == 0) {
            return "(empty)";
        }
        final StringBuilder outline103 = new StringBuilder("(");
        for (int i = 0; i < array.length; ++i) {
            if (i > 0) {
                outline103.append(',');
            }
            outline103.append(String.format("%.2f", array[i]));
        }
        outline103.append(")");
        return outline103.toString();
    }

    public final void a() throws Exception {
        final StringBuilder sb = new StringBuilder("Unregister Gyroscope ");
        sb.append(this.g);
        sb.append(" and Accelerometer ");
        sb.append(this.f);
        if (this.g) {
            this.a.unregisterListener((SensorEventListener)this, this.c);
            this.g = false;
        }
        if (this.f) {
            this.a.unregisterListener((SensorEventListener)this, this.b);
            this.f = false;
        }
        this.j = false;
        final HandlerThread d = this.d;
        if (d != null && d.isAlive()) {
            this.d.quitSafely();
        }
    }

    public final void onAccuracyChanged(final Sensor sensor, final int n) {}

    public final void onSensorChanged(SensorEvent values) {
        Label_0931: {
            try {
                final long uptimeMillis = SystemClock.uptimeMillis();
                if (!this.j && ((SensorEvent)values).accuracy == 0) {
                    this.j = true;
                }

                final int type = ((SensorEvent)values).sensor.getType();

                final StringBuilder sb = new StringBuilder("Motion sensor changed elapsed time: ");
                sb.append(uptimeMillis - this.e);
                sb.append(", Sensor Type: ");
                sb.append(type);


                if (type == 4) {
                    if (this.g) {
                        float[] valuesCopy = values.values;
                        this.s = valuesCopy[0];
                        this.t = valuesCopy[1];
                        this.u = valuesCopy[2];
                        this.h = true;
                    }
                }
                else if (type == 1 && this.f) {
                    final float[] values2 = ((SensorEvent)values).values;
                    this.m = values2[0];
                    this.n = values2[1];
                    this.o = values2[2];


                    Pair<Float, Float> minmax = minmax(values2);
                    System.out.println(minmax);
                    System.out.println(formattedCollection(values2));

                    final float n = (float)System.nanoTime();
                    final int l = this.l + 1;
                    this.l = l;
                    final float n2 = 1.0f / (l / ((n - this.k) / 1.0E9f));
                    float n3 = 0.0f;
                    Label_0234: {
                        if (!Float.isNaN(n2)) {
                            n3 = n2;
                            if (!Float.isInfinite(n2)) {
                                break Label_0234;
                            }
                        }
                        n3 = 0.0f;
                    }
                    final float n4 = 0.18f / (n3 + 0.18f);
                    final float[] v = this.v;
                    final float n5 = v[0];
                    final float n6 = 1.0f - n4;
                    v[0] = values2[0] * n6 + n5 * n4;
                    v[1] = values2[1] * n6 + v[1] * n4;
                    v[2] = n6 * values2[2] + n4 * v[2];


                    float[] trifloatSlice = new float[]{0.0f, 0.0f, 0.0f};

                    trifloatSlice[0] = values2[0] - v[0];
                    trifloatSlice[1] = values2[1] - v[1];
                    trifloatSlice[2] = values2[2] - v[2];
                    if (Float.isNaN(trifloatSlice[0]) || Float.isInfinite(trifloatSlice[0])) {
                        trifloatSlice[0] = 0.0f;
                    }
                    if (Float.isNaN(trifloatSlice[1]) || Float.isInfinite(trifloatSlice[1])) {
                        trifloatSlice[1] = 0.0f;
                    }
                    if (Float.isNaN(trifloatSlice[2]) || Float.isInfinite(trifloatSlice[2])) {
                        trifloatSlice[2] = 0.0f;
                    }
                    final float p = trifloatSlice[0];
                    this.p = p;
                    final float q = trifloatSlice[1];
                    this.q = q;
                    final float r = trifloatSlice[2];
                    this.r = r;
                    this.m *= -1.0f;
                    this.n *= -1.0f;
                    this.o *= -1.0f;
                    this.p = p * -1.0f;
                    this.q = q * -1.0f;
                    this.r = r * -1.0f;
                    this.i = true;

                }
                if (this.h && this.i && (uptimeMillis - this.e >= 100L)) {

                    this.e = uptimeMillis;

                    System.out.println(new StringBuilder("Motion event elapsed time: ").append(uptimeMillis - this.e).toString());
                    this.e = uptimeMillis;


                    final boolean b = 1 != 0;

                    this.setChanged();

                    final float m = this.m;
                    final float n7 = this.n;
                    final float o = this.o;
                    final float p2 = this.p;
                    final float q2 = this.q;
                    final float r2 = this.r;
                    final float s = this.s;
                    final float t = this.t;
                    final float u = this.u;
                    try {
                        final long e = this.e;
                        int n8;
                        if (b) {
                            n8 = 2;
                        }
                        else {
                            n8 = 1;
                        }
                        new k(m, n7, o, p2, q2, r2, s, t, u, e, n8);
                        this.notifyObservers(new k(m, n7, o, p2, q2, r2, s, t, u, e, n8));
                        this.h = !this.g;
                        this.i = !this.f;
                    }
                    catch (Exception ex) {
                        System.out.println("error notifying motion manager with new event data: " + ex.getMessage());
                        break Label_0931;
                    }
                }
                return;
            }
            catch (Exception ex) {}
        }
    }
}
