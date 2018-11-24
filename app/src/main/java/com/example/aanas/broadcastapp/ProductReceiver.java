package com.example.aanas.broadcastapp;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class ProductReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(("pl.aanasz.PRODUCT_ADDED").equals(intent.getAction())){
            String name = intent.getStringExtra("name");
            String price = intent.getStringExtra("price");
            String amount = intent.getStringExtra("amount");
            context.startService(intent);

            //send data to activity
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction("receiver.to.activity.action");
            broadcastIntent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            broadcastIntent.putExtra("newName",name);
            broadcastIntent.putExtra("newPrice",price);
            broadcastIntent.putExtra("newAmount",amount);
            broadcastIntent.setComponent(new ComponentName("com.example.aanas.broadcastapp", "com.example.aanas.broadcastapp.MainActivity"));

            broadcastIntent.setClassName("com.example.aanas.broadcastapp", "com.example.aanas.broadcastapp.MainActivity");
            broadcastIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.sendBroadcast(broadcastIntent);
            context.startActivity(broadcastIntent);
        }
        else{
            System.out.print("elo");
        }
    }
}
