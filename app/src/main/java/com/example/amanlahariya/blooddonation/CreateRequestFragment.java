package com.example.amanlahariya.blooddonation;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class CreateRequestFragment extends Fragment {

    TextView phone;
    TextInputEditText pname;
    EditText editText_Date,address,pincode,city;
    Spinner bloodGroup,bloodUnit;
    Button save;
    Calendar myCalendar = Calendar.getInstance();
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
            public void onClick(View v) {

                //database insertion logic
                String query = "insert into request values('"+pname.getText().toString()+"',"+Integer.parseInt(phone.getText().toString())+")";
                Toast toast = Toast.makeText(getActivity(),"Request Sucessfully Created!",Toast.LENGTH_LONG);
                toast.show();
            }
        });

        /*----------Expiremental Code----------*/
       /* bloodUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bloodUnit.setPrompt("Select Blood Units!");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                bloodUnit.setPrompt("Select Blood Units!");
            }
        });*/
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
        editText_Date.setText(sdf.format(myCalendar.getTime()));
    }
}
