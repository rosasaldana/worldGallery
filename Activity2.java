package com.example.hxrlab.worldgallery;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Activity2 extends AppCompatActivity implements View.OnClickListener, LocationListener {
    // location permission
    private final int REQUEST_PERMISSION_ACCESS_FINE_LOCATION=1;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        // initialize button and imageview
        Button cameraButton = (Button) findViewById(R.id.btnCamera);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        // create location manager
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        // GPS User Permission Request
        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_FINE_LOCATION  },
                    REQUEST_PERMISSION_ACCESS_FINE_LOCATION );
        }
        // Checks for the user's location every 500 ms and updates the system if the distance is 10 m apart
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 20, this);

        // User is requesting to open camera
        cameraButton.setOnClickListener(this);
       /** cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // we intent to capture an image after taking image send the data to OnActivityResult method
                startActivityForResult(intent, 1);
            }
        }); **/

    }

    // this method is called immediately after startActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // make sure the image was taken
     //   if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK ) {
            // data of the photo
            Bundle extras = data.getExtras();
            // convert photo into a bitmap
            Bitmap photo = (Bitmap) extras.get("data");
            imageView.setImageBitmap(photo);
   //     }
      //  super.onActivityResult(requestCode, resultCode, data);
     //   Bitmap bitmap = (Bitmap)data.getExtras().get("data");
     //   imageView.setImageBitmap(bitmap);
    }


    @Override
    public void onLocationChanged(Location location) {
  //      double longitude = location.getLongitude();
  //      double latitude = location.getLatitude();
  //      String s = "This is the longitude: " + longitude + " This is latitude: " + latitude;
   //     Log.d("coordinates",s);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnCamera:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
                break;

        }
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
