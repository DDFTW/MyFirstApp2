package com.example.myfirstapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


public class MainActivity extends AppCompatActivity {
    public static final String schedName = "orig";
    public static String numberOfSections = "0";
    NotificationCompat.Builder mBuilder;
    NotificationManagerCompat notificationManager;
    Calendar cal = Calendar.getInstance();
    static final String PREFS_NAME = "Name";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       createNotificationChannel();
       // what is the purpose of anotification channel


        // Get from the SharedPreferences
        SharedPreferences settings = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        String startTime = settings.getString("startTime", "0");

        TextView tv8 = findViewById(R.id.textView8);

      //  if(settings.contains("startTime")){

//            tv8.setText("Current times: " + startTime);

     //   }else{
       //     tv8.setText("No current times");
      //  }

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Channel_ID", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
//    public void updateNotif(){
//        notificationManager.notify(1, mBuilder.build());
//    }

    public void confirmSetup(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        numberOfSections = editText2.getText().toString();
        int numbers = Integer.parseInt(numberOfSections);
        Intent intent;
        if(numbers == 2) {
            intent = new Intent(this, TwoParts.class);
        }else if(numbers == 0){
            intent = new Intent(this, Zero.class);
        }else if(numbers == 3){
            intent = new Intent(this, ThreeParts.class);
        }else{
            intent = new Intent(this, CreateSchedule.class);
        }

//        mBuilder = new NotificationCompat.Builder(this, "Channel_ID")
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setContentTitle("My notification")
//                .setContentText("Time until next change: " + (ThreeParts.sched.getElement(0) - (cal.get(Calendar.HOUR_OF_DAY)*60 + cal.get(Calendar.MINUTE))))
//                .setStyle(new NotificationCompat.BigTextStyle()
//                        .bigText("Much longer text that cannot fit one line..."))
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//
//
//        notificationManager = NotificationManagerCompat.from(this);
//
//
//        notificationManager.notify(1, mBuilder.build());


        String message = editText.getText().toString();;
        String number = (editText2.getText().toString());
        intent.putExtra(schedName, message);
        intent.putExtra(numberOfSections, number);
        startActivity(intent);

//        final Handler handler = new Handler();
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//
//                /* do what you need to do */
//                notificationManager.notify(1, mBuilder.build());
//                /* and here comes the "trick" */
//                handler.postDelayed(this, 100);
//            }
//        };
//        handler.postDelayed(runnable, 100);

    }
}
