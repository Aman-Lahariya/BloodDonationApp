package com.example.amanlahariya.blooddonation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class CreateRequestFragment extends Fragment {

    public CreateRequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_request, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Spinner spinnerBloogGroup = (Spinner) getView().findViewById(R.id.spinner_BloodGroup);

    }
}
