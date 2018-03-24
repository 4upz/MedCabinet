package com.medcabinet.medicinecabinet;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class medicine_used extends ListActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.medicine_used);


        String[] numbers = {"one","two","three","four"};
        // here you store the array of string you got from the database

        // Binding Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,       numbers));
        // refer the ArrayAdapter Document in developer.android.com
        //ListView lv = getListView();


    }



    public void goToMain3Activity(View view){
        Intent intent = new Intent(this, newmedicine.class);
        startActivity(intent);
    }
}
