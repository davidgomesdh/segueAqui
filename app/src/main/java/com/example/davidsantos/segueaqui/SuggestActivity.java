package com.example.davidsantos.segueaqui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SuggestActivity extends AppCompatActivity {

    private EditText editSuggest;
    private FirebaseDatabase database;

    private String uid;
    private String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);

        uid = getIntent().getStringExtra("uid");

        database = FirebaseDatabase.getInstance();

        DatabaseReference userRef = database.getReference("users/"+uid);

        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usuario = dataSnapshot.child("usuario").getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        editSuggest = findViewById(R.id.editSuggest);


    }

    public void enviarSuggest(View view){

        Suggest suggest = new Suggest(editSuggest.getText().toString() ,uid,usuario);

        DatabaseReference suggestRef = database.getReference("suggests");

        suggestRef.push().setValue(suggest);


        finish();




    }
}
