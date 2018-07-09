package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ThreeParts extends AppCompatActivity {

    protected static String fullSchedule = "";
    protected static ScheduleObject sched = new ScheduleObject(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_parts);
    }


    public void createSchedule(View view){
        EditText et4 = (EditText) findViewById(R.id.editText4); //Start 1
        EditText et5 = (EditText) findViewById(R.id.editText5); //End 1
        EditText et8 = (EditText) findViewById(R.id.editText8); // Start 2
        EditText et7 = (EditText) findViewById(R.id.editText7); // End 2
        EditText et10 = (EditText) findViewById(R.id.editText10); // Start 3
        EditText et11 = (EditText) findViewById(R.id.editText11); // End 3


        sched.addSection(toMinutes(et4.getText().toString()), toMinutes(et5.getText().toString()));
        sched.addSection(toMinutes(et8.getText().toString()), toMinutes(et7.getText().toString()));
        sched.addSection(toMinutes(et10.getText().toString()), toMinutes(et11.getText().toString()));
        sched.convertToStringTime(sched.getList());

        Intent intent = new Intent(this, DisplaySchedule.class);
        intent.putExtra(fullSchedule,sched.getStringSchedule());
        startActivity(intent);
    }

    public int toMinutes(String fromEditText){
        String hours = fromEditText.substring(0, fromEditText.indexOf(":"));
        String minutes = fromEditText.substring(fromEditText.indexOf(":")+1);
        int hour = Integer.parseInt(hours);
        int minute = Integer.parseInt(minutes);
        int totalMinutes = hour*60 + minute;
        return totalMinutes;
    }
}
