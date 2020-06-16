package com.hackodia.com.demoproject;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button PlayButton, PauseButton , StopButton , FFButton , BBButton;
    MediaPlayer MP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlayButton=findViewById(R.id.play_btn);
        PauseButton=findViewById(R.id.pause_btn);
        StopButton=findViewById(R.id.stop_btn);
        FFButton=findViewById(R.id.ff_btn);
        BBButton=findViewById(R.id.bb_btn);

       MP=MediaPlayer.create(MainActivity.this , R.raw.samsung_tune);

        MP=new MediaPlayer();

        PlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /*String PATH =Environment.getExternalStorageDirectory().getAbsoluteFile();


               File file=new File(PATH);

              File files[]= file.listFiles();

              for (int i=0 ;i<files.length ;i++)
              {
                 File TempFile= files[i];

                 String filepath=TempFile.getAbsolutePath();
                 if (filepath.endsWith(".mp3"));

                  MP.setDataSource(filepath);

              }*/




                int Duration= MP.getDuration();



                Toast.makeText(MainActivity.this, String.valueOf(Duration), Toast.LENGTH_SHORT).show();

                MP.start();

            }
        });

        PauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MP.pause();
            }
        });

        StopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MP.stop();
            }
        });

        FFButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int CP=  MP.getCurrentPosition();

                MP.seekTo(CP+5000);

            }
        });

        BBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int CP=  MP.getCurrentPosition();

                MP.seekTo(CP-5000);
            }
        });


    }
}
