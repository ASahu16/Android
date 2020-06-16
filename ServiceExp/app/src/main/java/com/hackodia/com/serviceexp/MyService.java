package com.hackodia.com.serviceexp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    MediaPlayer MP;

    @Override
    public void onCreate() {
        super.onCreate();

        MP=MediaPlayer.create(MyService.this , R.raw.samsung_tune);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(MyService.this , "Started" , Toast.LENGTH_LONG).show();

        MP.start();

        return super.onStartCommand(intent, flags, startId);



    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(MyService.this , "Stoped" , Toast.LENGTH_LONG).show();
        MP.stop();

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
