package com.hackodia.com.locationmanagerexp;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener{
Button GetLocationButton;
TextView DisplayLocation;

LocationManager LM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetLocationButton=findViewById(R.id.get_location_btn);
        DisplayLocation=findViewById(R.id.display_location);

        LM= (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);

        GetLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               Location l= getMyLocation();

               if (l!=null)
               {
                   double lng= l.getLongitude();
                   double lat=l.getLatitude();

                   Toast.makeText(MainActivity.this, String.valueOf(lng)+"\n"+String.valueOf(lat), Toast.LENGTH_SHORT).show();

               }
               else
               {
                   Toast.makeText(MainActivity.this, "Sorry", Toast.LENGTH_SHORT).show();
               }








            }
        });

    }

    public Location getMyLocation()
    {
        Location loc=null;

        if (LM.isProviderEnabled(LocationManager.GPS_PROVIDER))
        {
            LM.requestLocationUpdates(LocationManager.GPS_PROVIDER , 5000 , 10 , this );

           loc=  LM.getLastKnownLocation(LocationManager.GPS_PROVIDER);


        }

        return loc;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
