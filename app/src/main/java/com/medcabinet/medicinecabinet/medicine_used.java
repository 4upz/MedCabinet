package com.medcabinet.medicinecabinet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class medicine_used extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine_used);
    }

    public void goToMain3Activity(View view){
        Intent intent = new Intent(this, newmedicine.class);
        startActivity(intent);
    }
}
