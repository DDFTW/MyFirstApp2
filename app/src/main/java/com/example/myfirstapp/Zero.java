package com.example.myfirstapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class Zero extends AppCompatActivity {
    protected static ScheduleObject zeroSched = new ScheduleObject();
    protected static final String extra = "";
    static final String PREFS_NAME = "Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);
    }

    public void confirmClick(View view){
        EditText ed = (findViewById(R.id.editText12));
        String temp = ed.getText().toString();
        zeroSched.addSection( ScheduleObject.toMinutes(temp), 1000);

        SharedPreferences settings = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("startTime", temp);

// Apply the edits!
        editor.apply();






        Intent intent = new Intent(this, DisplayZero.class);
        intent.putExtra(extra, temp);

        startActivity(intent);

    }

    public ScheduleObject returnSched(){
        return zeroSched;
    }
}
//
//    SharedPreferences settings = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
//    SharedPreferences.Editor editor = settings.edit();
//editor.putInt("homeScore", YOUR_HOME_SCORE);
//
//// Apply the edits!
//        editor.apply();
//
//// Get from the SharedPreferences
//        SharedPreferences settings = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
//        int homeScore = settings.getInt("homeScore", 0);