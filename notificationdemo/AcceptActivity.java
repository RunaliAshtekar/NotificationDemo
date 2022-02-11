package com.example.notificationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class AcceptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept);

        TextView result = findViewById(R.id.result);
/*
        NotificationManager notificationManager = (NotificationManager)getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancelAll();


        //check condition

        if (getIntent().hasExtra("Accept")){
            result.setText("accepted");
            result.setTextColor(Color.GREEN);
        }else if (getIntent().hasExtra("Reject")){
            result.setText("Rejected");
            result.setTextColor(Color.RED);
        }
    }*/
    }
}
