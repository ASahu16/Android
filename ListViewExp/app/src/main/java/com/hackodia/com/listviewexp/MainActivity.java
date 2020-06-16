package com.hackodia.com.listviewexp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
ListView lv;
String names[]={"Ram","Rajeev","Ravi","Tanpreet","Haider","Ravan"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv=findViewById(R.id.name_list);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this , android.R.layout.simple_list_item_1 , names);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


       String N= names[position];

        Toast.makeText(MainActivity.this , N , Toast.LENGTH_LONG).show();


    }
}
