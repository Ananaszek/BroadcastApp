package com.example.aanas.broadcastapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Context contextMain;
    private ProductReceiver broadcastReceiver;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contextMain = this;

        IntentFilter filter = new IntentFilter("pl.aanasz.PRODUCT_ADDED");
        String PERMISSION = "com.example.aanas.newapp.PRODUCT_PERMISSION";
        registerReceiver(broadcastReceiver, filter, PERMISSION,null);

        Intent intent = getIntent();

        if (intent != null) {
            String name = intent.getStringExtra("newName");
            String price = intent.getStringExtra("newPrice");
            String amount = intent.getStringExtra("newAmount");

                    Intent newIntent = new Intent();
                    newIntent.setComponent(new ComponentName("com.example.aanas.newapp", "com.example.aanas.newapp.ProductList"));
                    pendingIntent = PendingIntent.getActivity(this, 0, newIntent, 0);

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(contextMain, ProductNotificationChannel.NOTIFICATION_CHANNEL_1)
                    .setContentTitle(name)
                    .setContentText(price + ", x" + amount)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.notify(1, mBuilder.build());

        }

        finish();
    }
}
