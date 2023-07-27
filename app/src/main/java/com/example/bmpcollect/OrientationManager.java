package com.example.bmpcollect;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.Observable;
import java.util.concurrent.ExecutionException;
import android.os.SystemClock;
import android.app.Application;
import java.util.concurrent.atomic.AtomicBoolean;
import android.util.Pair;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.Observer;

public class OrientationManager extends AppCompatActivity implements Observer {
    public OrientationListener a;
    public boolean b;
    public long c;
    public ArrayList<l> d;
    private AtomicBoolean f;
    public Collection collection;

    public OrientationManager(Application application, Collection collection) {
        this.d = new ArrayList<l>();
        this.f = new AtomicBoolean(false);
        this.c = SystemClock.uptimeMillis();
        this.a = new OrientationListener(application);
        this.collection = collection;
    }

    public final void a() throws Exception {
        if (this.d.size() >= 128) {
            return;
        }
        if (this.f.get()) {
            return;
        }
        if (!this.a.a()) {
            return;
        }
        this.b = true;
        this.a.addObserver(this);
    }

    public final void b() throws Exception {
        this.a.b();
        this.a.deleteObservers();
    }

    public final void update(final Observable observable, final Object o) {
        if (o == null) {
            return;
        }
        try {
            /*
                if the
            */
            if (this.d.size() >= 128 || this.collection.motionEvents.size() >= 128) {
//                this.collection.sendCollection();
//                this.b();
                this.d.clear();

                return;

            }

            this.collection.orientationEvents.add((l)o);
            this.d.add((l)o);
        }
        catch (Exception ex) {
            System.out.println("exception getting orientation events: " + ex.getMessage());
            return;
        }
    }


}