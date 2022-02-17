package com.example.notificationdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSend;
     int counter = 0;
    public final String CHANNEL_ID = "1";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.bt_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Reminder set", Toast.LENGTH_LONG).show();

                startNotification();


            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void startNotification() {



        Intent intent = new Intent(this,AcceptActivity.class);
       PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);


      /*  Intent timeIntent = new Intent(MainActivity.this, Reciever.class);
        timeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent timePendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, timeIntent, 0);


        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        long timeAtButtonClick = System.currentTimeMillis();
        long tenSeconds = 1000 + 20;


        alarmManager.set(AlarmManager.RTC_WAKEUP, timeAtButtonClick + tenSeconds, timePendingIntent);



*/


        // for accept action button
        Intent acceptIntent = new Intent(this,AcceptReciever.class);
        acceptIntent.putExtra("Toast","this is notification");
        PendingIntent actionPendingIntent = PendingIntent.getBroadcast(this,0,acceptIntent,0);


        Notification.Action action = new Notification.Action.Builder(Icon.createWithResource
                (this,R.drawable.ic_notifications_black_24dp),"Accept",actionPendingIntent).build();


        // for reject action button
        Intent rejectIntent = new Intent(this,recieverReject.class);
        PendingIntent rejectPendingIntent = PendingIntent.getBroadcast(this,0,rejectIntent ,0);


        Notification.Action rejectAction = new Notification.Action.Builder(Icon.createWithResource
                (this,R.drawable.ic_notifications_black_24dp),"Reject",rejectPendingIntent).build();



        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"1",NotificationManager.IMPORTANCE_DEFAULT);

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.createNotificationChannel(channel);

        Notification.Builder builder = new Notification.Builder(MainActivity.this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle("Reminder")
                .setContentText("THis is reminder massage")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .addAction(action)
                .addAction(rejectAction);

        NotificationManagerCompat compat = NotificationManagerCompat.from(MainActivity.this);
        compat.notify(1,builder.build());
    }


}
