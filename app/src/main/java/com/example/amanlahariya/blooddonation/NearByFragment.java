package com.example.amanlahariya.blooddonation;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NearByFragment extends Fragment {

    Button allow;

    public NearByFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_near_by, container, false);
    }

    /*@Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        allow = (Button) getView().findViewById(R.id.button_Allow_NearBy);
        allow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),MapsActivity.class);
                startActivity(i);
            }
        });
    }*/
}
