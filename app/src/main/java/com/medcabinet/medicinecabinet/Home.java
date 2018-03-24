package com.medcabinet.medicinecabinet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain2Activity();
            }
        });
    }

    private void goToMain2Activity(){
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }


}