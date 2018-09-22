package com.example.amanlahariya.blooddonation.AccountActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amanlahariya.blooddonation.MainActivity;
import com.example.amanlahariya.blooddonation.R;


public class Login_Activity extends AppCompatActivity {

    private EditText etMobileView;
    private EditText etPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etMobileView = (EditText) findViewById(R.id.editText_Mobile);
        etPasswordView = (EditText) findViewById(R.id.editText_Password);
        Button login = (Button) findViewById(R.id.bt_Sing_In);
        Button forgot = (Button) findViewById(R.id.bt_Forgot_Password);
        Button register = (Button) findViewById(R.id.bt_Register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(etMobileView.getText().toString(), etPasswordView.getText().toString());
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_sign = new Intent(Login_Activity.this, SignupActivity.class);
                startActivity(intent_sign);
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_forgot = new Intent(Login_Activity.this, forgot_password .class);
                startActivity(intent_forgot);
            }
        });
    }

    protected void validate(String user, String pass)
    {
        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(user)) {
            etMobileView.setError(getString(R.string.error_field_required));
            focusView = etMobileView;
            cancel = true;
        }

        if (TextUtils.isEmpty(pass)) {
            etPasswordView.setError(getString(R.string.error_field_required));
            focusView = etPasswordView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        }

        else {
            // perform the user login attempt.
           /* if(user.equals("12345") && pass.equals("12345")) {*/
                Intent intent_dash = new Intent(Login_Activity.this,MainActivity.class);
                startActivity(intent_dash);
            /*}
            else
            {
                Toast toast = Toast.makeText(getApplicationContext(),"Incorrect username or password!",Toast.LENGTH_LONG);
                toast.show();
            /*}
        }
    }*/

    mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithEmail:success");
                FirebaseUser user = mAuth.getCurrentUser();
                updateUI(user);
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.getException());
                Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show();
                updateUI(null);
            }

            // ...
        }
    });
}
