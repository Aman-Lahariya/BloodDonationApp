package com.example.amanlahariya.blooddonation;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class BloodRequestFragment extends Fragment
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    public BloodRequestFragment() {
        // Required empty public constructor
    }


    public void onViewCreated(View view,Bundle savedInstanceState){
        BottomNavigationView navigationView = (BottomNavigationView) getView().findViewById(R.id.bottom_nav_view);
        navigationView.setOnNavigationItemSelectedListener(this);
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
        Fragment fragment;
        if (id == R.id.nav_near_by) {
            fragment = new NearByFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_blood_request, fragment);
            ft.commit();
        } else if (id == R.id.nav_my_request) {
            fragment = new MyRequestFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_blood_request, fragment);
            ft.commit();
        } else if (id == R.id.nav_create_request) {
            fragment = new CreateRequestFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_blood_request, fragment);
            ft.commit();
        }
        return true;
    }
}
