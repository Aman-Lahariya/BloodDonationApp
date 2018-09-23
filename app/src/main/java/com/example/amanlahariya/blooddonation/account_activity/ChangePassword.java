package com.example.amanlahariya.blooddonation.account_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.amanlahariya.blooddonation.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class ChangePassword extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    private EditText oldPass,newPass,cnfrmPass,emailAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_change_password);

        emailAddr = (EditText) findViewById(R.id.editText_ChangePass_email);
        oldPass = (EditText) findViewById(R.id.editText_OldPass);
        newPass = (EditText) findViewById(R.id.editText_NewPass);
        cnfrmPass = (EditText) findViewById(R.id.editText_CnfrmPass);
        Button btnChange = (Button) findViewById(R.id.btn_ChangePassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_ChangePass);
        mAuth = FirebaseAuth.getInstance();

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String old = oldPass.getText().toString().trim();
                String email = emailAddr.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    progressBar.setVisibility(View.VISIBLE);
                    mAuth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(ChangePassword.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(ChangePassword.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                    }
                                    progressBar.setVisibility(View.GONE);
                                }
                            });
                }
            }
        });
    }

}