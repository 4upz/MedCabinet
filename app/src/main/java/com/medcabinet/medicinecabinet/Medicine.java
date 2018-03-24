package com.medcabinet.medicinecabinet;

import com.google.gson.Gson;

/**
 * Created by demouser on 3/24/18.
 */

public class Medicine {
    private String medName;
    private String dosage;
    private String frequency;

    Medicine(String name, String dos, String freq){
        medName = name;
        dosage = dos;
        frequency = freq;
    }

    public String toJson(){
        // Serialization
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }
}
