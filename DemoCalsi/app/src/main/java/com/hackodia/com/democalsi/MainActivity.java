package com.hackodia.com.democalsi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button addButton , subButton;
    EditText et1 , et2;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.input_one);
        et2=findViewById(R.id.input_two);
        addButton=findViewById(R.id.add_btn);
        subButton=findViewById(R.id.sub_btn);
        tv=findViewById(R.id.display_result);

        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
       int id= v.getId();

       if (id==R.id.add_btn)
       {
           String str1=et1.getText().toString();
           String str2=et2.getText().toString();

          int a,b,c;
          a=Integer.parseInt(str1);
          b=Integer.parseInt(str2);
          c=a+b;

          String R=String.valueOf(c);

          tv.setText(R);

       }

        if (id==R.id.sub_btn)
        {
            String str1=et1.getText().toString();
            String str2=et2.getText().toString();

            int a,b,c;
            a=Integer.parseInt(str1);
            b=Integer.parseInt(str2);
            c=a-b;

            String R=String.valueOf(c);

            tv.setText(R);

        }


    }
}
