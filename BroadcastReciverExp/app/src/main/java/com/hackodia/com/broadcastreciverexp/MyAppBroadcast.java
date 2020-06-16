package com.hackodia.com.broadcastreciverexp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyAppBroadcast extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {

        Toast.makeText(context, "Working", Toast.LENGTH_SHORT).show();
    }
}
