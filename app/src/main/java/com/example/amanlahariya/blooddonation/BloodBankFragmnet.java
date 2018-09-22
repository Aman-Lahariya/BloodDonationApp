package com.example.amanlahariya.blooddonation;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import java.util.List;


public class BloodBankFragmnet extends Fragment implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;

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
        if(mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }

        Button search = (Button) mView.findViewById(R.id.button_Search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearch();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng India = new LatLng(18.509890, 73.807182);
        mGoogleMap.addMarker(new MarkerOptions().position(India).title("Marker in Pune").snippet("Finally displayed the map in fragment"));
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(India));
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(India,15.0f));

    }

    public void onSearch(){

        EditText search = (EditText) getActivity().findViewById(R.id.editText_Search);
        String location = search.getText().toString();
        List<Address> addressList = null;
        if(location!=null || !location.equals("")){
            Geocoder geocoder = new Geocoder(getActivity());
            try {
                addressList = geocoder.getFromLocationName("new york",1);
                Address address = addressList.get(0);
                LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
                mGoogleMap.addMarker(new MarkerOptions().position(latLng));
                mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15.0f));
                Toast toast2 = Toast.makeText(getActivity(),"Showing "+location+"!",Toast.LENGTH_LONG);
                toast2.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
