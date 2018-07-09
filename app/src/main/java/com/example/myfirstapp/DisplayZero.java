package com.example.myfirstapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

import static com.example.myfirstapp.Zero.extra;

public class DisplayZero extends AppCompatActivity {
    NotificationCompat.Builder mBuilder;
    NotificationManagerCompat notificationManager;
    Calendar cal= Calendar.getInstance();
    int timeLeftInMinutes = 0;
    public static final int NOTIFICATION_ID = 578;
    private final Handler handler = new Handler();
    private Runnable sendUpdatesToUI = new Runnable() {
        @Override
        public void run() {
            updateNotification();
            handler.postDelayed(this, 5000);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_zero);

        Intent intent = getIntent();

        timeLeftInMinutes = (Zero.zeroSched.getElement(0) - (cal.get(Calendar.HOUR_OF_DAY)*60 + cal.get(Calendar.MINUTE)));
        mBuilder = new NotificationCompat.Builder(this, "Channel_ID")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("My notification")
                .setContentText("Time until next change: " + timeLeftInMinutes)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Time until next change: " + timeLeftInMinutes))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
              //  .setOnlyAlertOnce(true)
                ;



        notificationManager = NotificationManagerCompat.from(this);


        notificationManager.notify(NOTIFICATION_ID, mBuilder.build());


        TextView tv = findViewById(R.id.textView7);
        tv.setText( intent.getStringExtra(extra));

        handler.removeCallbacks(sendUpdatesToUI);
        handler.postDelayed(sendUpdatesToUI, 1000);

    }

    public void updateNotification(){
        timeLeftInMinutes = (Zero.zeroSched.getElement(0) - (cal.get(Calendar.HOUR_OF_DAY)*60 + cal.get(Calendar.MINUTE)));
        mBuilder.setContentText("Time until next change: " + timeLeftInMinutes)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Time until next change: " + timeLeftInMinutes));
        notificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}
