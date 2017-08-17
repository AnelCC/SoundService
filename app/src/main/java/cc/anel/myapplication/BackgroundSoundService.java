package cc.anel.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by anelelizabethcervantes on 8/16/17.
 */

public class BackgroundSoundService extends Service {

    private static final String TAG = "BackgroundSound";
    MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.rx_java);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);
        Log.d(TAG, "onCreate: ");

    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        Log.d(TAG, "onStartCommand: ");
        return 1;
    }

    public void onStart(Intent intent, int startId) {
        // TO DO
        Log.d(TAG, "onStart: ");
    }
    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        Log.d(TAG, "onUnBind: ");
        return null;
    }

    public void onStop() {
        Log.d(TAG, "onStop: ");
        player.stop();

    }
    public void onPause() {
        Log.d(TAG, "onPause: ");
        player.pause();

    }
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onLowMemory() {
        Log.d(TAG, "onLowMemory: ");

    }

}
