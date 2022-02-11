package com.example.notificationdemo;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;

import static android.app.Notification.*;

public class AcceptReciever extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    public void onReceive(Context context, Intent intent) {


        String text = intent.getStringExtra("send");
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();



    }
}
