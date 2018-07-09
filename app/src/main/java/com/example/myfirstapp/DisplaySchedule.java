package com.example.myfirstapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class DisplaySchedule extends AppCompatActivity {
    NotificationCompat.Builder mBuilder;
    NotificationManagerCompat notificationManager;
    Calendar cal= Calendar.getInstance();
    int timeLeftInMinutes = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_schedule);

        Intent intent = getIntent();

        TextView textView = findViewById(R.id.textView6);
        String schedule = intent.getStringExtra(ThreeParts.fullSchedule);
        textView.setText(schedule);

        timeLeftInMinutes = (ThreeParts.sched.getElement(0) - (cal.get(Calendar.HOUR_OF_DAY)*60 + cal.get(Calendar.MINUTE)));
        mBuilder = new NotificationCompat.Builder(this, "Channel_ID")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("My notification")
                .setContentText("Time until next change: " + timeLeftInMinutes)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Time until next change: " + timeLeftInMinutes))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setOnlyAlertOnce(true);



        notificationManager = NotificationManagerCompat.from(this);


        notificationManager.notify(1, mBuilder.build());

        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
               timeLeftInMinutes = (ThreeParts.sched.getElement(0) - (cal.get(Calendar.HOUR_OF_DAY)*60 + cal.get(Calendar.MINUTE)));
               updateNotif();
                /* and here comes the "trick" */
                handler.postDelayed(this, 5000);
            }
        };
        handler.postDelayed(runnable, 5000);
    }

    public void updateNotif(){
        notificationManager.notify(1, mBuilder.build());
    }
}
