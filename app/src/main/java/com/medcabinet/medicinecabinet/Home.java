package com.medcabinet.medicinecabinet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;

public class Home extends AppCompatActivity {
    private static final int RC_SIGN_IN = 123;
    private static final String TAG = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();


        //DatabaseReference myRef = database.getReference("helloworld");
        DatabaseReference myRef = database.getReference("/gus");
        Task<Void> task = myRef.setValue("i am awesome");
        task = myRef.setValue("another entry");
        Log.d(TAG, "trying to save data:" + myRef + " task" + task);
        setContentView(R.layout.home);


        Button button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain2Activity();
            }
        });
<<<<<<< HEAD

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUsedMedicine();
            }
        });

=======
>>>>>>> 0ac965cc27de28b989dfa402d8bba54296c9d37f
// ...

// Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build());

// Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {

                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("/"+user.getDisplayName());
                //Task<Void> task = myRef.setValue(user.getEmail());

                Log.d(TAG, "Yay, we got a user " + user);
//                Log.d(TAG, "Display Name:  " + user.getDisplayName());

                // ...
            } else {
                // Sign in failed, check response for error code
                // ...
            }
        }
    }

    private void goToMain2Activity(){
        Intent intent = new Intent(this, newmedicine.class);
        startActivity(intent);
    }

    private void goToUsedMedicine() {
        Intent intent = new Intent(this, medicine_used.class);
        startActivity(intent);
    }

}
