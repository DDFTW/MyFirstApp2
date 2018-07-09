package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CreateSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_schedule);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.schedName);
        int numberOfSections = Integer.parseInt(intent.getStringExtra(MainActivity.numberOfSections));

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText("" + numberOfSections);
    }
}
