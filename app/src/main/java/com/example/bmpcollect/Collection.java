package com.example.bmpcollect;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class Collection {
    public ArrayList<k> motionEvents;
    public ArrayList<HashMap<String, Float>> pureMotion;
    public ArrayList<HashMap<String, Float>> pureOrientation;
    public ArrayList<l> orientationEvents;
    public Collection() {
        this.motionEvents = new ArrayList<>();
        this.orientationEvents = new ArrayList<>();
        this.pureMotion = new ArrayList<HashMap<String, Float>>();
        this.pureOrientation = new ArrayList<>();
    }
    public void sendCollection() {
        try {
            for (k event : this.motionEvents) {
                HashMap<String, Float> eventObject = new HashMap<>();
                eventObject.put("a", event.a);
                eventObject.put("b", event.b);
                eventObject.put("c", event.c);
                eventObject.put("d", event.d);
                eventObject.put("e", event.e);
                eventObject.put("f", event.f);
                eventObject.put("g", event.g);
                eventObject.put("h", event.h);
                eventObject.put("i", event.i);
                eventObject.put("j", (float) event.j);
                this.pureMotion.add(eventObject);
            }
            for (l event : this.orientationEvents) {
                HashMap<String, Float> eventObject = new HashMap<>();
                eventObject.put("a0", event.a[0]);
                eventObject.put("a1", event.a[1]);
                eventObject.put("a2", event.a[2]);
                eventObject.put("b0", event.b[0]);
                eventObject.put("b1", event.b[1]);
                eventObject.put("b2", event.b[2]);
                eventObject.put("c", (float)event.c);
                this.pureOrientation.add(eventObject);
            }
            URL url = new URL("YOUR_URL_HERE");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            HashMap<String, ArrayList<HashMap<String, Float>>> payload = new HashMap<>();
            payload.put("motionEvents", this.pureMotion);
            payload.put("orientationEvents", this.pureOrientation);

            Gson gson = new GsonBuilder().create();
            String jsonStr = gson.toJson(payload);
            connection.getOutputStream().write(jsonStr.getBytes());
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            this.motionEvents.clear();
            this.orientationEvents.clear();
            this.pureMotion.clear();
            this.pureOrientation.clear();

            return;
        } catch (Exception e) {
            System.out.println("Error sending collection: " + e.getMessage());
            return;
        }
    }
}
