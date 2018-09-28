package com.example.amanlahariya.blooddonation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class PatientBloodRequestAdapter extends RecyclerView.Adapter<PatientBloodRequestAdapter.PatientBloodRequestViewHolder> {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the PatientBloodRequests in a list
    private List<PatientBloodRequest> PatientBloodRequestList;

    //getting the context and PatientBloodRequest list with constructor
    public PatientBloodRequestAdapter(Context mCtx, List<PatientBloodRequest> PatientBloodRequestList) {
        this.mCtx = mCtx;
        this.PatientBloodRequestList = PatientBloodRequestList;
    }

    @Override
    public PatientBloodRequestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.custom_layout_blood_request, null);
        return new PatientBloodRequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PatientBloodRequestViewHolder holder, int position) {
        //getting the PatientBloodRequest of the specified position
        PatientBloodRequest PatientBloodRequest = PatientBloodRequestList.get(position);

        //binding the data with the viewholder views
        holder.textViewPatientName.setText(PatientBloodRequest.getTitle());
        holder.textViewBloodGroup.setText(PatientBloodRequest.getBloodGroup());
        holder.textViewBloodUnit.setText(String.valueOf(PatientBloodRequest.getBloodUnit()));
        holder.textViewAddress.setText(String.valueOf(PatientBloodRequest.getAddress()));
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(PatientBloodRequest.getImage()));
    }


    @Override
    public int getItemCount() {
        return PatientBloodRequestList.size();
    }


    class PatientBloodRequestViewHolder extends RecyclerView.ViewHolder {

        TextView textViewPatientName, textViewBloodGroup, textViewBloodUnit, textViewAddress;
        ImageView imageView;

        public PatientBloodRequestViewHolder(View itemView) {
            super(itemView);
            textViewPatientName = itemView.findViewById(R.id.textView_patientName);
            textViewBloodGroup = itemView.findViewById(R.id.textView_bloodGroup);
            textViewBloodUnit = itemView.findViewById(R.id.textView_bloodUnit);
            textViewAddress = itemView.findViewById(R.id.textView_Address);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
