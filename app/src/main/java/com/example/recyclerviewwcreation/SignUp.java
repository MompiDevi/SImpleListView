package com.example.recyclerviewwcreation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    EditText email, newPasword, confirmPassword;
    Button signUp;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = (EditText)findViewById(R.id.email);
        newPasword = (EditText)findViewById(R.id.newPassword);
        confirmPassword = (EditText)findViewById(R.id.confirmPassword);

        signUp = (Button)findViewById(R.id.signup);

        firebaseAuth = FirebaseAuth.getInstance();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), newPasword.getText().toString()).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(SignUp.this, "Successfully Registered", Toast.LENGTH_SHORT);
                            finish();
                        }
                    });
                }
            }
        });

    }

    Boolean validate(){
        if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
            Toast.makeText(SignUp.this, "Enter Valid email", Toast.LENGTH_SHORT);
            return false;
        }
        if(!newPasword.getText().toString().equals(confirmPassword.getText().toString())){
            Toast.makeText(SignUp.this, "Enter same password", Toast.LENGTH_SHORT);
            return false;
        }
        return true;
    }
}