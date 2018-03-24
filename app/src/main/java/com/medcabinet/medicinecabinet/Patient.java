package com.medcabinet.medicinecabinet;

import java.util.List;

/**
 * Created by demouser on 3/24/18.
 */

public class Patient {
    private String name;
    List<String> medList;
    //maybe latter instead of a list of Strings, you should have a list of Med objects.

    Patient(String n){
        name = n;
    }

    public void setMedList(List<String> medList) {
        this.medList = medList;
    }

    public List<String> getMedList() {
        return medList;
    }
}
