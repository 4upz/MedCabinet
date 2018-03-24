package com.medcabinet.medicinecabinet;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

/**
 * Created by demouser on 3/24/18.
 */

public class Medicine {
    private static final String TAG = "Med";
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
    public void saveToFireBase(){
        String jsonData = toJson();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference medsList = database.getReference("/"+user.getUid() +"/meds");
        DatabaseReference newMedicationEntry = medsList.push();
        newMedicationEntry.setValue(jsonData);
        Log.d(TAG, "Saved to Firebase the data: "+ jsonData);
        //Task<Void> task = myRef.setValue(user.getEmail());
    }
}
