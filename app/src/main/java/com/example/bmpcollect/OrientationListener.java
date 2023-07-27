package com.example.bmpcollect;

import android.content.Context;
import android.hardware.SensorEvent;
import android.os.SystemClock;
import android.os.Handler;
import android.app.Application;
import android.os.HandlerThread;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import java.util.Observable;

public class OrientationListener extends Observable implements SensorEventListener {
    public boolean a;
    private SensorManager b;
    private Sensor c;
    private Sensor d;
    private Sensor e;
    private HandlerThread f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private long l;
    private float[] m;
    private float[] n;
    public Application application;

    public OrientationListener(Application application) {
        this.application = application;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.a = false;
        this.l = 0L;

        this.m = new float[3];

        this.n = new float[3];
        try {
            System.out.println("starting orientation listener...");
            if (this.application == null) {
                throw new Exception("application is null error!");
            }
            this.b = (SensorManager)this.application.getSystemService(Context.SENSOR_SERVICE);
            System.out.println(this.b);
            if (this.b == null) {
                System.out.println("sensor service is null error!");
            }
        }
        catch (NullPointerException ex) {
            System.out.println("error initializing orientation listener: " + ex.getMessage());
            return;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public final boolean a() throws Exception {
        this.c = this.b.getDefaultSensor(1);
        this.d = this.b.getDefaultSensor(2);
        (this.f = new HandlerThread("CYFOrientationListener")).start();
        final Handler handler = new Handler(this.f.getLooper());
        this.g = this.b.registerListener((SensorEventListener)this, this.c, 3, handler);
        this.h = this.b.registerListener((SensorEventListener)this, this.d, 3, handler);
        final Sensor defaultSensor = this.b.getDefaultSensor(9);
        this.e = defaultSensor;
        final boolean registerListener = this.b.registerListener((SensorEventListener)this, defaultSensor, 3, handler);
        this.i = registerListener;
        if (registerListener) {
            this.b.unregisterListener((SensorEventListener)this, this.c);
            this.g = false;
        }

        this.l = SystemClock.uptimeMillis();
        if ((this.g || this.i) && this.h) {
            final StringBuilder sb = new StringBuilder("orientation listener started with accelerometer ");
            sb.append(this.g);
            sb.append(" Gravity sensor ");
            sb.append(this.i);
            sb.append(" Magnetometer ");
            sb.append(this.h);
            return true;
        }

//        this.b();
        return false;
    }

    public final void b() throws Exception {
        if (this.h) {
            this.b.unregisterListener((SensorEventListener)this, this.d);
            this.h = false;
        }
        if (this.i) {
            this.b.unregisterListener((SensorEventListener)this, this.e);
            this.i = false;
        }
        if (this.g) {
            this.b.unregisterListener((SensorEventListener)this, this.c);
            this.g = false;
        }
        this.a = false;
        final HandlerThread f = this.f;
        if (f != null && f.isAlive()) {
            this.f.quitSafely();
        }
    }

    public final void onAccuracyChanged(final Sensor sensor, final int n) {
    }

    public final void onSensorChanged(final SensorEvent sensorEvent) {
        try {
            final long uptimeMillis = SystemClock.uptimeMillis();

            if (!this.a && sensorEvent.accuracy == 0) {

                this.a = true;
            }

            final int type = sensorEvent.sensor.getType();
            final StringBuilder sb = new StringBuilder("Orientation sensor changed elapsed time: ");
            sb.append(uptimeMillis - this.l);
            sb.append(", Sensor Type: ");
            sb.append(type);
            if (type == 9) {
                this.m = sensorEvent.values.clone();
                this.j = true;
            }
            else if (type == 1) {
                this.m = sensorEvent.values.clone();
                this.j = true;
            }
            else if (type == 2) {
                this.n = sensorEvent.values.clone();
                this.k = true;
            }
            if (this.j && this.k) {

                if (uptimeMillis - this.l >= 100L) {

                    StringBuilder sb2 = new StringBuilder("Orientation event elapsed time: ").append(uptimeMillis - this.l);
                    System.out.println(sb2);
                    this.l = uptimeMillis;
                    this.setChanged();
                    final float[] m = this.m;
                    final float[] n = this.n;

                    System.out.println(formattedCollection(m));
                    final long l = this.l;
                    int n2;
                    n2 = 2;
                    this.notifyObservers(new l(m, n, l, n2));
                    this.j = false;
                    this.k = false;
                }
            }
        }
        catch (Exception ex) {
            throw ex;
        }
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
}
