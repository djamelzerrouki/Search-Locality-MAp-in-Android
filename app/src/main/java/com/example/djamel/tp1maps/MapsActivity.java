package com.example.djamel.tp1maps;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
  //  private static final String EXTRA_LOCALITATION="com.example.djamel.tp1maps";

    private static  String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        place = intent.getStringExtra(MainActivity.EXTRA_LOCALITATION);

        // Capture the layout's TextView and set the string as its text

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // Add a marker in Sydney and move the camera
        Geocoder coder = new Geocoder(this);
        List<Address> address;
        try {
          //  String locationName = "Nhà hàng Blanchy Street, VietNam";
            String locationName = place;

            //   Geocoder gc = new Geocoder(this);
            List<Address> addressList = coder.getFromLocationName(locationName, 5);
            Address location = addressList.get(0);

            double latitude = location.getLatitude();
            double longitude = location.getLongitude();

          LatLng sydney = new LatLng(latitude, longitude);

  // LatLng sydney = new LatLng(2.5, 55.2);

            mMap.addMarker(new MarkerOptions().position(sydney).title(locationName));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,8));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }}
