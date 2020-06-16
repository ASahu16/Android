package com.hackodia.com.implicitintentexp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText UrlEditText;
Button VisitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UrlEditText=findViewById(R.id.url_id);
        VisitButton=findViewById(R.id.visit_btn);

        VisitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Intent.ACTION_CALL);

                String urlString=UrlEditText.getText().toString();

               Uri uri= Uri.parse("tel:"+urlString);

                i.setData(uri);

                startActivity(i);

            }
        });

    }
}
