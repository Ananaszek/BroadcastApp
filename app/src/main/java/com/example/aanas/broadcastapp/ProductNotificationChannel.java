package com.example.aanas.broadcastapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class ProductNotificationChannel extends Application {

    public static final String NOTIFICATION_CHANNEL_1 = "channel1";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    NOTIFICATION_CHANNEL_1,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel1.setDescription("Product app channel");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel1);
        }
    }
}
