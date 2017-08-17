package cc.anel.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Image;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Intent svc;
    ImageView img_play, img_pause, img_stop;

    NotificationManager mNotificationManager;
    NotificationCompat.Builder mBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_play = (ImageView) findViewById(R.id.a_img_play);
        img_pause = (ImageView) findViewById(R.id.a_img_pause);
        img_stop = (ImageView) findViewById(R.id.a_img_stop);
    }


    public void playMusic(View view) {
        Log.d(TAG, "playMusic: ");
        svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);

        mBuilder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_play_circle)
                        .setContentTitle("It is play")
                        .setContentText("If you close. You should stopped in the app");
        mNotificationManager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);


        // mNotificationId is a unique integer your app uses to identify the
        // notification. For example, to cancel the notification, you can pass its ID
        // number to NotificationManager.cancel().
        mNotificationManager.notify(1, mBuilder.build());
        isPlay(true);
    }

    public void stopMusic(View view) {
        stopService(svc);
        mNotificationManager.cancel(1);
        isPlay(false);
    }

    public void isPlay(boolean isPlay){
        if (isPlay){
            img_play.setVisibility(View.GONE);
            img_stop.setVisibility(View.VISIBLE);

        }else {
            img_play.setVisibility(View.VISIBLE);
            img_stop.setVisibility(View.GONE);
        }


    }



}
