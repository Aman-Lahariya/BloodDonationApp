package com.example.amanlahariya.blooddonation;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateRequestFragment extends Fragment {


    TextView phone;
    TextInputEditText pname;
    EditText editText_Date;
    EditText address;
    EditText pincode;
    EditText city;
    Spinner bloodGroup,bloodUnit;
    Button save;
    Calendar myCalendar = Calendar.getInstance();
    RecyclerView ListViewPatients;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    public CreateRequestFragment() {
        // Required empty public constructor
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_request, container, false);  }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        pname = (TextInputEditText) getView().findViewById(R.id.editText_PatientName);
        phone = (TextView) getView().findViewById(R.id.textView_Phone);
        address = (EditText) getView().findViewById(R.id.editTextAddress);
        pincode = (EditText) getView().findViewById(R.id.editText_Pincode);
        city = (EditText) getView().findViewById(R.id.editText_City);
        bloodGroup = (Spinner) getView().findViewById(R.id.spinner_BloodGroup);
        bloodUnit = (Spinner) getView().findViewById(R.id.spinner_BloodUnit);
        editText_Date = (EditText) getView().findViewById(R.id.editText_Date);
        save = (Button) getView().findViewById(R.id.button_Save_CreateRequest);


        editText_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateRequest();
            }
        });
    }

    //save data to databse
    private void CreateRequest(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        String paname = pname.getText().toString().trim();
        String phoneno = phone.getText().toString().trim();
        String add = address.getText().toString().trim();
        String pin = pincode.getText().toString().trim();
        String town = city.getText().toString().trim();
        String bloodg = bloodGroup.getSelectedItem().toString();
        String bloodu = bloodUnit.getSelectedItem().toString();
        String date = editText_Date.getText().toString().trim();
        if (!TextUtils.isEmpty(paname)&&!TextUtils.isEmpty(phoneno)&&!TextUtils.isEmpty(add)&&!TextUtils.isEmpty(pin)&&!TextUtils.isEmpty(town)&&!TextUtils.isEmpty(bloodg)&&!TextUtils.isEmpty(bloodu)&&!TextUtils.isEmpty(date)){
            myRef.child(paname).child("name").setValue(paname);
            myRef.child(paname).child("no").setValue(phoneno);
            myRef.child(paname).child("address").setValue(add);
            myRef.child(paname).child("pincode").setValue(pin);
            myRef.child(paname).child("city").setValue(town);
            myRef.child(paname).child("bloodGroup").setValue(bloodg);
            myRef.child(paname).child("bloodUnit").setValue(bloodu);
            myRef.child(paname).child("date").setValue(date);
            Toast.makeText(getActivity(),"Request created succesfully", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getActivity(),"Please enter all details ", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
        editText_Date.setText(sdf.format(myCalendar.getTime()));
    }
}
