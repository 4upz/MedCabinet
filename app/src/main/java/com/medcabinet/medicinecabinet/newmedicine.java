package com.medcabinet.medicinecabinet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.net.Uri;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class newmedicine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_medicine);

    }
    public void goToMain4Activity(View view){
        Intent intent = new Intent(this, medicine_used.class);
        startActivity(intent);
    }

    public void submitOrder(View view){
        EditText medName = (EditText) findViewById(R.id.editText2);
        EditText quant = (EditText) findViewById(R.id.editText3);
        EditText dos = (EditText) findViewById(R.id.editText4);
        //TODO add error handling later


        Editable haveMed = (medName.getText());
        Editable haveQ = (quant.getText());
        Editable haveDos = (dos.getText());
        Medicine med = new Medicine(haveMed.toString(),haveDos.toString(),haveQ.toString());
        med.saveToFireBase();

//        String summary = createOrderSummary(haveMed,haveQ,haveDos);
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Medication Order");
//        intent.putExtra(Intent.EXTRA_TEXT, summary);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }

    }
    private String createOrderSummary(Editable med, Editable quant, Editable dos){



        //String name = "The Homie";
        String summary = "Customer";
        summary += " your order of " + quant;
        summary += " has been recorded for " + med;
        summary += " with a dosage frequency of : " + dos;
        summary += "\nThank you!";
        return summary;

    }
}
