package com.example.amanlahariya.blooddonation;

public class Request {
    String p_id;
    String p_name;

    public Request(String id, String p_name, String phoneno){

    }

    public Request(String p_id, String p_name) {
        this.p_id = p_id;
        this.p_name = p_name;
    }

    public String getP_id() {
        return p_id;
    }

    public String getP_name() {
        return p_name;
    }
}
