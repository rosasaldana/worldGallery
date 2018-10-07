package com.example.hxrlab.worldgallery;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MapView mapView;
    Dialog dialogBox;
    TextView titleTv, messageTv;
    ImageView initialPopupImg;
  //  Button searchLocation, detectLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, "pk.eyJ1Ijoicm9zYXNhbGRhbmEiLCJhIjoiY2ptcnhwbWhxMDExMzNwczhrMjg4eGluYSJ9.hWimVvC5OKLT5xcIk2m_tA");
        setContentView(R.layout.activity_main);

        // initialization
        mapView = (MapView) findViewById(R.id.mapView);
    //    searchLocation = (Button) findViewById(R.id.searchLocation);
    //    detectLocation = (Button) findViewById(R.id.detectLocation);
        mapView.onCreate(savedInstanceState);
        dialogBox = new Dialog(this);

        // buttons listening
    //    searchLocation.setOnClickListener(this);
    //    detectLocation.setOnClickListener(this);

        initialMessage();

    }

    public void initialMessage(){
        dialogBox.setContentView(R.layout.inital_popup);
        initialPopupImg = (ImageView) dialogBox.findViewById(R.id.closeCorrectImg);
        titleTv = (TextView) dialogBox.findViewById(R.id.titleTv);
        messageTv = (TextView) dialogBox.findViewById(R.id.messageTv);

        initialPopupImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialogBox.dismiss();
            }
        });
        /**
        detectLocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //
            }
        });
        searchLocation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //
            }
        }); **/
        dialogBox.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogBox.show();
    }

    @Override
    public void onClick(View v) {
    /**
        switch(v.getId()) {
            // clicked on Michael
            case R.id.detectLocation:
                // go into new activity
                break;
            case R.id.searchLocation:
                // this is just minimizing the current pop up message box
                break;
        } **/
    }

    /** MAPBOX API METHODS **/
    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
