package in.prax.tamalproject;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();
    /**
     * The {@link ViewPager} that will host the section contents.
     */

    private static AppController mInstance;
    private static AppCompatActivity activity;
//    private static GoogleAnalytics sAnalytics;
//    private static Tracker sTracker;

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public static void setActivity(AppCompatActivity activity) {
        AppController.activity = activity;
    }

    /**
     * Get the context from AppController throughout the App
     *
     * @return Context
     */
    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

/*

    */
/**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     *//*

    synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
    }
    // Gloabl declaration of variable to use in whole app
*/

    private static boolean activityVisible; // Variable that will check the
    // current activity state

    public static boolean isActivityVisible() {
        return activityVisible; // return true or false
    }

    public static void activityResumed() {
        activityVisible = true;// this will set true when activity resumed

    }

    public static void activityPaused() {
        activityVisible = false;// this will set false when activity paused

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
//        sAnalytics = GoogleAnalytics.getInstance(this);

    }
}