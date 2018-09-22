package com.example.amanlahariya.blooddonation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends Fragment {
    /*private TextView changePass;*/

    public Settings() {
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
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView changePass = (TextView) getView().findViewById(R.id.textView_ChangePassword);
        TextView forgotPass = (TextView) getView().findViewById(R.id.textView_Phone);
        TextView logout = (TextView) getView().findViewById(R.id.textView_Logout);
        TextView feedback = (TextView) getView().findViewById(R.id.textView_Feedback);
        TextView ourTeam = (TextView) getView().findViewById(R.id.textView_OurTeam);

        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new ChangePassword();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.content_main_placeholder,fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_forgot = new Intent(getActivity(),ForgotPassword.class);
                startActivity(intent_forgot);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(getActivity());
                a_builder.setMessage("Are you sure you want to logout ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast toast = Toast.makeText(getContext(),"Successfully Logged Out!",Toast.LENGTH_LONG);
                                toast.show();

                                Intent intent_login = new Intent(getActivity(),Login_Activity.class);
                                startActivity(intent_login);
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }) ;
                AlertDialog alert = a_builder.create();
                alert.setTitle("Alert !!!");
                alert.show();
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Feedback();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.content_main_placeholder,fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        ourTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new OurTeam();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.content_main_placeholder,fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }
}
