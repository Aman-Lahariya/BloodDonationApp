package com.example.amanlahariya.blooddonation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyRequestFragment extends Fragment {

    //a list to store all the products
    List<PatientBloodRequest> productList;

    public Map<String, Boolean> stars = new HashMap<>();

    //the recyclerview
    RecyclerView recyclerView;

    public MyRequestFragment() {
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
        return inflater.inflate(R.layout.fragment_my_request, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView_myRequest);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //initializing the productlist
        productList = new ArrayList<>();

        //adding some items to our list
        productList.add(
                new PatientBloodRequest(
                        1,
                        "Aman Lahariya",
                        "O+ve",
                        "2 Units",
                        "Kothrud,Pune",
                        R.drawable.ic_person_black_24dp));

        productList.add(
                new PatientBloodRequest(
                        1,
                        "Aman Lahariya",
                        "O+ve",
                        "1 Unit",
                        "Kothrud,Pune",
                        R.drawable.ic_person_black_24dp));



        //creating recyclerview adapter
        PatientBloodRequestAdapter adapter = new PatientBloodRequestAdapter(getActivity(), productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }
}
