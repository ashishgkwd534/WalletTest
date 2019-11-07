package com.ags.wallettest.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ags.wallettest.R;
import com.ags.wallettest.helper.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.text.TextUtils.isEmpty;

public class RegistrationActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private EditText edtUserName,edtEmail,edtPassword,edtRePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference();
        mDatabaseReference.setValue("UserDetails");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        edtEmail=findViewById(R.id.edtRegistrationEmail);
        edtUserName=findViewById(R.id.edtRegistrationUserName);
        edtPassword=findViewById(R.id.edtRegistrationPassword);
        edtRePassword=findViewById(R.id.edtRegistrationConfirmPassword);
    }
    public void signButtonClick(View v){
        onBackPressed();
    }
    public void regButtonClick(View v){
        String sUserName=edtUserName.getText().toString();
        String sEmail=edtEmail.getText().toString();
        String sPassword=edtPassword.getText().toString();
        String sPassword2=edtRePassword.getText().toString();
        if (isEmpty(sUserName)){
            edtUserName.setError(getString(R.string.empty));
            return;
        }if (isEmpty(sEmail)){
            edtEmail.setError(getString(R.string.empty));
            return;
        }if (isEmpty(sPassword)){
            edtPassword.setError(getString(R.string.empty));
            return;
        }if (isEmpty(sPassword2)){
            edtRePassword.setError(getString(R.string.empty));
            return;
        }
        String key=mDatabaseReference.push().getKey();
        User user=new User(key,sUserName,sEmail,sPassword);
        assert key != null;
        mDatabaseReference.child(key).setValue(user);
        mDatabaseReference.child(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(RegistrationActivity.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(RegistrationActivity.this, "Something went wrong try again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
