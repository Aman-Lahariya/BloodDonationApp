package com.example.amanlahariya.blooddonation;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class BloodRequestFragment extends Fragment
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    public BloodRequestFragment() {
        // Required empty public constructor
    }


    public void onViewCreated(View view,Bundle savedInstanceState){
        BottomNavigationView navigationView = (BottomNavigationView) getView().findViewById(R.id.bottom_nav_view);
        navigationView.setOnNavigationItemSelectedListener(this);

        Fragment fragmentShow = new NearByFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.blood_request_placeholder, fragmentShow);
        ft.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blood_request, container, false);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragmentShow;
        if (id == R.id.nav_near_by) {
            fragmentShow = new NearByFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.blood_request_placeholder, fragmentShow);
            ft.commit();
        } else if (id == R.id.nav_my_request) {
            fragmentShow = new MyRequestFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.blood_request_placeholder, fragmentShow);
            ft.commit();
        } else if (id == R.id.nav_create_request) {
            fragmentShow = new CreateRequestFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.blood_request_placeholder, fragmentShow);
            ft.commit();
        }
        return true;
    }
}
