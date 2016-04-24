package com.ranunagar.mappractice;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    DatabaseHelper helper = new DatabaseHelper(this);
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }

    public void onSearch(View view) {
        if (view.getId() == R.id.button2) {

                    String search = helper.searchAdd();
                    Intent in = new Intent(MapsActivity.this, Display.class);
                    in.putExtra("Address", search);
                    startActivity(in);


        }
        if (view.getId() == R.id.button) {
            Intent in = new Intent(MapsActivity.this, AddActivity.class);
            startActivity(in);
        }
    }
}


        /*
        Intent intent = new Intent(this, AddActivity.class);
        EditText searchText = (EditText)findViewById(R.id.editText);
        //converting text from edittext to string
        String location = searchText.getText().toString();
        List<Address> addressList = null;
        if(location != null || !location.equals(""))
        {
            //object of geocoder class
            Geocoder geocoder = new Geocoder(this);
            try {
                //getfromlocationname takes location from edittext and converts it into lati and longi
                //@parm location and maximum addresses
                //this method generates list of addresses
               addressList  = geocoder.getFromLocationName(location,1 );
            } catch (IOException e) {
                e.printStackTrace();
            }
//fetch first value from addresslist
            Address address = addressList.get(0);

            LatLng letLng = new LatLng(address.getLatitude(), address.getLongitude());
            //added marker
            mMap.addMarker(new MarkerOptions().position(letLng).title("Marker"));
            //zoom or focus camera on marker location
            mMap.animateCamera(CameraUpdateFactory.newLatLng(letLng));
        }
        */





/*package com.ranunagar.mappractice;

 import android.location.Address;
 import android.location.Geocoder;
 import android.support.v4.app.FragmentActivity;
 import andro0id.os.Bundle;
 import android.view.View;
 import android.widget.EditText;

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

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_maps);
 // Obtain the SupportMapFragment and get notified when the map is ready to be used.
 SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
 .findFragmentById(R.id.map);
 mapFragment.getMapAsync(this);
 }



@Override
public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;

    // Add a marker in Sydney and move the camera
    LatLng sydney = new LatLng(-34, 151);
    mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

}

    public void onSearch(View view)
    {
        EditText searchText = (EditText)findViewById(R.id.editText);
        //converting text from edittext to string
        String location = searchText.getText().toString();
        List<Address> addressList = null;
        if(location != null || !location.equals(""))
        {
            //object of geocoder class
            Geocoder geocoder = new Geocoder(this);
            try {
                //getfromlocationname takes location from edittext and converts it into lati and longi
                //@parm location and maximum addresses
                //this method generates list of addresses
                addressList  = geocoder.getFromLocationName(location,1 );
            } catch (IOException e) {
                e.printStackTrace();
            }
//fetch first value from addresslist
            Address address = addressList.get(0);

            LatLng letLng = new LatLng(address.getLatitude(), address.getLongitude());
            //added marker
            mMap.addMarker(new MarkerOptions().position(letLng).title("Marker"));
            //zoom or focus camera on marker location
            mMap.animateCamera(CameraUpdateFactory.newLatLng(letLng));
        }
    }
}
*/
