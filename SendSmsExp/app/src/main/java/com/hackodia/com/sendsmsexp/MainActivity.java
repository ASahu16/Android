package com.hackodia.com.sendsmsexp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button SendButton;
EditText MobileEditText , MessageEditTExt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SendButton=findViewById(R.id.send_btn);

        MobileEditText=findViewById(R.id.mobile_number_et);
        MessageEditTExt=findViewById(R.id.message_id);
        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                
                String Mobile=MobileEditText.getText().toString();
                String Message=MessageEditTExt.getText().toString();

                SmsManager smsManager=SmsManager.getDefault();

                smsManager.sendTextMessage(Mobile , null , Message , null , null);

            }
        });


    }
}
