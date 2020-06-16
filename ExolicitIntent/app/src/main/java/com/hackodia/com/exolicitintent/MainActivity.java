package com.hackodia.com.exolicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button GoButton;
EditText NameEditText , MobileEditTExt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoButton=findViewById(R.id.go_btn);
        NameEditText=findViewById(R.id.name_id);
        MobileEditTExt=findViewById(R.id.mobile_id);

        GoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String NAME=NameEditText.getText().toString();
                String MOBILE=MobileEditTExt.getText().toString();

                Intent i=new Intent(MainActivity.this , SecondActivity.class);

                i.putExtra("N" , NAME);
                i.putExtra("M" , MOBILE);

                startActivity(i);
            }
        });

    }
}
