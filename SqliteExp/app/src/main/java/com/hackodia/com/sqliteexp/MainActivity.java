package com.hackodia.com.sqliteexp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText NameEditText , MobileEditText , PasswordEditText;
Button SaveButton , ShowButton , DeleteButton , UpdateButton;
TextView DisplayDataTv;

MyDbAdaptor dbAdaptor=new MyDbAdaptor(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NameEditText=findViewById(R.id.name_id);
        MobileEditText=findViewById(R.id.mobile_id);
        PasswordEditText=findViewById(R.id.password_id);

        SaveButton=findViewById(R.id.save_btn);
        ShowButton=findViewById(R.id.show_btn);
        DeleteButton=findViewById(R.id.delete_btn);
        UpdateButton=findViewById(R.id.update_btn);

        DisplayDataTv=findViewById(R.id.display_data);


        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               String NAME= NameEditText.getText().toString() ;
               String MOBILE= MobileEditText.getText().toString();
               String PASSWORD= PasswordEditText.getText().toString();

               dbAdaptor.saveData(NAME , MOBILE , PASSWORD);

            }
        });

        ShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Cursor cursor= dbAdaptor.showData();
              String DATA="";

              do {

                  String N=cursor.getString(cursor.getColumnIndex("name"));
                  String M=cursor.getString(cursor.getColumnIndex("mobile"));
                  String P=cursor.getString(cursor.getColumnIndex("password"));

                  DATA=DATA+N+" "+M+" "+P+"\n";



              }while (cursor.moveToNext());

              DisplayDataTv.setText(DATA);

            }
        });

        DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String MOBILE=MobileEditText.getText().toString();

                dbAdaptor.deleteData(MOBILE);

            }
        });
        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String MOBILE=MobileEditText.getText().toString();
                String PASSWORD=PasswordEditText.getText().toString();

                dbAdaptor.updateData(MOBILE , PASSWORD);

            }
        });

    }
}
