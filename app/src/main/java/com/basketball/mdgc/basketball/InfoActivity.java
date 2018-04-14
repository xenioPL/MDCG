package com.basketball.mdgc.basketball;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InfoActivity extends AppCompatActivity {
    Button registerButton;
    EditText nameInput;
    DatabaseReference mDatabase;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         user = FirebaseAuth.getInstance().getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_info);
         registerButton = findViewById(R.id.button);
         nameInput = findViewById(R.id.editText);
         mDatabase.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 if(dataSnapshot.hasChild(user.getUid()))
                 {
                     Intent intent = new Intent(InfoActivity.this, Main3Activity.class); //Po uzupełnieniu zalogowanie
                     startActivity(intent);
                 }
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {

             }
         });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                mDatabase.child("users").child(user.getUid()).setValue(nameInput.getText().toString());
                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                        .setDisplayName(nameInput.getText().toString())
                        .build();

                user.updateProfile(profileUpdates)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(InfoActivity.this, Main3Activity.class); //Po uzupełnieniu zalogowanie
                                    startActivity(intent);
                                }
                            }
                        });
            }
        });
    }
}
