package com.hackodia.com.exolicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

         tv=findViewById(R.id.display_text);

         Intent intent=getIntent();
         Bundle b=intent.getExtras();

        String Name= b.getString("N");
        String Mobile= b.getString("M");

        tv.setText("Hello "+Name+"\n"+"Your mobile number is"+Mobile);

    }
}
