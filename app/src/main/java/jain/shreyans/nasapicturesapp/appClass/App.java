package jain.shreyans.nasapicturesapp.appClass;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
        super.onCreate();
    }

    public static Context getAppContext() {
        return context;
    }
}
