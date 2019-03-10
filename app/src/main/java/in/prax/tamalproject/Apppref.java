package in.prax.tamalproject;

import android.content.Context;
import android.content.SharedPreferences;

public class Apppref {
    static Apppref instance;
    static Context appcontext;

    private final SharedPreferences.Editor editor;
    private final SharedPreferences preferences;

    boolean video = false;
    boolean case1 = false;
    boolean case2 = false;
    boolean way1 = false;

    public boolean isCase1() {
        return preferences.getBoolean("case1", false);
    }

    public void setCase1(boolean case1) {
        this.case1 = case1;
        editor.putBoolean("case1", case1).commit();
    }

    public boolean isCase2() {
        return preferences.getBoolean("case2", false);
    }

    public void setCase2(boolean case2) {
        this.case2 = case2;
        editor.putBoolean("case2", case2).commit();
    }

    public boolean isWay1() {
        return preferences.getBoolean("way1", false);
    }

    public void setWay1(boolean way1) {
        this.way1 = way1;
        editor.putBoolean("way1", way1).commit();
    }

    public boolean isWay2() {
         return preferences.getBoolean("way2", false);
    }

    public void setWay2(boolean way2) {
        this.way2 = way2;
        editor.putBoolean("way2", way2).commit();
    }

    boolean way2 = false;

    public Apppref() {
        preferences = appcontext.getSharedPreferences("tamalapp", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public boolean isVideo() {
        return preferences.getBoolean("video", false);
    }

    public void setVideo(boolean video) {
        this.video = video;
        editor.putBoolean("video", video).commit();
    }

    public static Apppref getInstance(Context context) {
        appcontext = context;
        if (instance != null) {
            return instance;
        }
        return new Apppref();
    }


}
