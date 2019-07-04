package com.myapplicationdev.android.p08ps_map;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    Button btnNorth, btnCentral, btnEast;
    Spinner spinner;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);

        btnNorth = findViewById(R.id.btnNorth);
        btnCentral = findViewById(R.id.btnCentral);
        btnEast = findViewById(R.id.btnEast);

        spinner = findViewById(R.id.spinnerArea);


        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                UiSettings ui = map.getUiSettings();

                ui.setZoomControlsEnabled(true);


                LatLng poi_singapore = new LatLng(1.352083, 103.819839);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_singapore,
                        15));

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        String selectedItem = parent.getSelectedItem().toString();

                        if (selectedItem.equalsIgnoreCase("North")) {

                            LatLng poi_north = new LatLng(1.463660, 103.815811);
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_north,
                                    15));

                            Marker north = map.addMarker(new
                                    MarkerOptions()
                                    .position(poi_north)
                                    .title("HQ - North")
                                    .snippet("Block 333, Admiralty Ave 3, 765654 \n Operating hours: 10am-5pm \n" +
                                            "Tel:65433456")
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                        } else if (selectedItem.equalsIgnoreCase("Central")) {

                            LatLng poi_central = new LatLng(1.301600, 103.839912);
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_central,
                                    15));

                            Marker central = map.addMarker(new
                                    MarkerOptions()
                                    .position(poi_central)
                                    .title("Central")
                                    .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                            "Operating hours: 11am-8pm \n" +
                                            "Tel:67788652 \n")
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                        } else {

                            LatLng poi_east = new LatLng(1.349860, 103.934190);
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_east,
                                    15));

                            Marker east = map.addMarker(new
                                    MarkerOptions()
                                    .position(poi_east)
                                    .title("East")
                                    .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                            "Operating hours: 9am-5pm \n" +
                                            "Tel:66776677 \n")
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                        }

                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }

                });

                btnNorth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        LatLng poi_north = new LatLng(1.463660, 103.815811);
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_north,
                                15));

                        Marker north = map.addMarker(new
                                MarkerOptions()
                                .position(poi_north)
                                .title("HQ - North")
                                .snippet("Block 333, Admiralty Ave 3, 765654 \n Operating hours: 10am-5pm \n" +
                                        "Tel:65433456")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

                    }

                });


                btnCentral.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        LatLng poi_central = new LatLng(1.301600, 103.839912);
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_central,
                                15));

                        Marker central = map.addMarker(new
                                MarkerOptions()
                                .position(poi_central)
                                .title("Central")
                                .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                        "Operating hours: 11am-8pm \n" +
                                        "Tel:67788652 \n")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    }
                });


                btnEast.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        LatLng poi_east = new LatLng(1.349860, 103.934190);
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_east,
                                15));

                        Marker east = map.addMarker(new
                                MarkerOptions()
                                .position(poi_east)
                                .title("East")
                                .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                        "Operating hours: 9am-5pm \n" +
                                        "Tel:66776677 \n")
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                    }
                });


                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                }


                map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {

                        Toast.makeText(MainActivity.this, marker.getTitle(), Toast.LENGTH_LONG).show();
                        return false;
                    }
                });

            }
        });

    }
}
