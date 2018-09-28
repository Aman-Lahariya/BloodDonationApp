package com.example.amanlahariya.blooddonation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BloodBankFragmnet extends Fragment implements OnMapReadyCallback{

    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;
    EditText search_field;
    Button search;
    private static final int PERMISSION_REQUEST_CODE = 1;

    public BloodBankFragmnet() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_blood_bank_fragmnet, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapView = (MapView) mView.findViewById(R.id.mapView_BloodBank);
        search_field = (EditText) getActivity().findViewById(R.id.editText_Search);
        search = (Button) mView.findViewById(R.id.button_Search);

//      TextView msg = (TextView) mView.findViewById(R.id.textView_BloodBank);
//      Button allow = (Button) mView.findViewById(R.id.button_Allow_BloodBank);

        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }



        /*if (i == true && j == true) {
            search.setVisibility(View.VISIBLE);
            search_field.setVisibility(View.VISIBLE);
            mMapView.setVisibility(View.VISIBLE);
            allow.setVisibility(View.INVISIBLE);
            msg.setVisibility(View.INVISIBLE);
        }*/
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(Objects.requireNonNull(getContext()));
        mGoogleMap = googleMap;
        //mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermission();
            return;
        }
        mGoogleMap.setMyLocationEnabled(true);
        LatLng myCurrentLocation = new LatLng(18.5170, 73.8151);
        mGoogleMap.addMarker(new MarkerOptions().position(myCurrentLocation).title("My Location").snippet("MIT College Of Management"));
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(myCurrentLocation));
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myCurrentLocation,15.0f));

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearch();
            }
        });
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
            Toast.makeText(getActivity(),"GPS permission allows us to access location data. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
        }
    }

    public void onSearch(){

        String location = search_field.getText().toString();
        List<Address> addressList = new ArrayList<>();
        if(location!=null || !location.equals("")){
            Geocoder geocoder = new Geocoder(getActivity());
            try {
                addressList = geocoder.getFromLocationName(location,1);
                if (addressList.size() > 0) {
                    Address address = addressList.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                    mGoogleMap.addMarker(new MarkerOptions().position(latLng));
                    mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5.0f));
                    Toast toast2 = Toast.makeText(getActivity(), "Showing " + location + "!", Toast.LENGTH_LONG);
                    toast2.show();
                }
                Log.d("address", addressList.toString());

            }catch(IOException e){
                    e.printStackTrace();

            }
        }
    }
}
