package com.example.notificationdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Reciever extends BroadcastReceiver {

    public final String CHANNEL_ID = "1";


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {

        String text = intent.getStringExtra("send");
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();


        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"1", NotificationManager.IMPORTANCE_DEFAULT);

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);

        Notification.Builder builder = new Notification.Builder(context,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle("Reminder")
                .setContentText("THis is reminder massage");

        NotificationManagerCompat compat = NotificationManagerCompat.from(context);
        compat.notify(1,builder.build());

    }
}
