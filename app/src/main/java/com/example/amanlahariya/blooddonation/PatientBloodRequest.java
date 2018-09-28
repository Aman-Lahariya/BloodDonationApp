package com.example.amanlahariya.blooddonation;

public class PatientBloodRequest {

    private int id;
    private String title;
    private String bloodGroup;
    private String bloodUnit;
    private String address;
    private int image;

    public PatientBloodRequest(int id, String title, String bloodGroup, String bloodUnit, String address, int image) {
        this.id = id;
        this.title = title;
        this.bloodGroup = bloodGroup;
        this.bloodUnit = bloodUnit;
        this.address = address;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getBloodUnit() {
        return bloodUnit;
    }

    public String getAddress() {
        return address;
    }

    public int getImage() {
        return image;
    }


}