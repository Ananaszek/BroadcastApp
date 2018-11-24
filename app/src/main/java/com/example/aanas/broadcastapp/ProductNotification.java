package com.example.aanas.broadcastapp;

import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ProductNotification extends AppCompatActivity {
    public void sendOnChannel(View v){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this,ProductNotificationChannel.NOTIFICATION_CHANNEL_1)
                .setContentTitle("nazwa")
                .setContentText("cena" + ", x" + "ilość")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }
}
