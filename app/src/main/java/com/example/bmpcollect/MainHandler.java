package com.example.bmpcollect;

import android.hardware.SensorEventListener;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.Observer;
import android.text.TextWatcher;
import android.widget.EditText;
import android.view.View;
import android.view.ViewGroup;
import android.app.Application;
import java.util.concurrent.Future;
import java.util.TimerTask;
import java.util.Timer;
import android.util.Pair;
import java.util.Random;
import android.os.SystemClock;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.ArrayList;

public class MainHandler extends AppCompatActivity
{
    private static final ArrayList<Integer> f;
    private static boolean h;
    public MotionManager b;
    public OrientationManager c;
    private AtomicBoolean g;
    private boolean i;

    public Collection collection;
    public Application application;

    static {
        f = new ArrayList<Integer>();
    }

    public MainHandler(Application application) {
        this.application = application;
        this.collection = new Collection();
        this.b = null;
        this.c = new OrientationManager(this.application, this.collection);
        this.g = new AtomicBoolean(false);
        this.i = false;
    }

    /*
    * this starts the orientation listener
    * */
    public final void b() {
        try {
            System.out.println("Starting orientation listener.");
            this.c.a();
        } catch (Exception ex) {
            System.out.println("exception starting orientation listener!" + ex.getMessage());
            return;
        }
    }

    /* this starts the motion manager */
    public final void b(final Application application) {
        synchronized (this) {
            System.out.println("Starting motion manager.");
            if (this.b != null) {
                return;
            }
            this.b = new MotionManager(application, this.collection);
        }
    }

    /* starts the motion listener */
    public final void d() {
       try {
           System.out.println("Starting motion listener.");
           final MotionManager b = this.b;

           if (b.d.size() >= 128) {
               return;
           }
           if (b.f.get()) {
               return;
           }
           final MotionListener a = b.a;
           a.b = a.a.getDefaultSensor(1);
           a.c = a.a.getDefaultSensor(4);

           (a.d = new HandlerThread("CYFMotionListener")).start();

           final Handler handler = new Handler(a.d.getLooper());

           a.f = a.a.registerListener((SensorEventListener)a, a.b, 3, handler);
           a.g = a.a.registerListener((SensorEventListener)a, a.c, 3, handler);

           final boolean f = a.f;
           boolean b2;
           if (!f && !a.g) {
               a.a();
               b2 = false;
           } else {
               a.i = !f;
               a.h = !a.g;
               a.e = SystemClock.uptimeMillis();
               a.k = (float)System.nanoTime();
               a.l = 0;
               b2 = true ;
           }

           if (!b2) {
               System.out.println("Failed to register motion listener!");
               return;
           }

           b.b = true;
           b.a.addObserver(b);

           System.out.println("registered motion listener!");


       } catch (Exception ex) {
           System.out.println("Exception2 in registering motion listener!" + ex.getMessage());
           return;
       }
    }




}
