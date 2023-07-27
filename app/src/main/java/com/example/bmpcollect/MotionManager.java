package com.example.bmpcollect;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.Observable;
import java.util.concurrent.ExecutionException;

import android.hardware.SensorEvent;
import android.os.SystemClock;
import android.app.Application;
import java.util.concurrent.atomic.AtomicBoolean;
import android.util.Pair;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.Observer;

public class MotionManager implements Observer {
    public MotionListener a;
    public boolean b;
    public long c;
    public ArrayList<k> d;
    public AtomicBoolean f;
    public Collection collection;

    public MotionManager(final Application application, Collection collection) {
        this.collection = collection;
        this.f = new AtomicBoolean(false);
        this.c = SystemClock.uptimeMillis();
        this.a = new MotionListener(application);
        this.d = new ArrayList<k>();
    }
    public final void a() throws Exception {

        new StringBuilder("Stopping motion manager: ").append(Thread.currentThread());
        this.a.a();
        this.a.deleteObservers();
    }

    public final void update(final Observable observable, Object o) {
        if (o == null) {
            System.out.println("ignoring null motion event update.");
            return;
        }
        try {
            if (this.d.size() >= 128) {
                    this.collection.sendCollection();

                    this.d.clear();
            }
            this.d.add((k)o);
            this.collection.motionEvents.add((k)o);

        }
        catch (Exception ex) {
            System.out.println("exception appending updated motion event: " + ex.getMessage());
            return;
        }
    }


}
