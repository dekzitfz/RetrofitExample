package id.dekz.code.retrofitexample;

import android.app.Application;

/**
 * Created by DEKZ on 4/2/2016.
 */
public class RetrofitExample extends Application {

    public static final String TAG = RetrofitExample.class.getSimpleName();
    private static RetrofitExample mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
