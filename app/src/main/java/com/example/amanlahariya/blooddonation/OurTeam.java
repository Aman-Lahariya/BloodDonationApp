package com.example.amanlahariya.blooddonation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class OurTeam extends Fragment {


    public OurTeam() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static OurTeam newInstance(String param1, String param2) {
        OurTeam fragment = new OurTeam();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_our_team, container, false);
    }


}
