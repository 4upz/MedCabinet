package com.medcabinet.medicinecabinet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void goToMain3Activity(View view){
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
}
