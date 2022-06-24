package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;



public class SignupActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private FirebaseServices fbs;
    private Utilities utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        connectComponents();

    }
    private void connectComponents() {
        etUsername = findViewById(R.id.etUsernameSignup);
        etPassword = findViewById(R.id.etPasswordSignup);
        utils = Utilities.getInstance();
        fbs = FirebaseServices.getInstance();
    }

    public void Signup(View view) {
        // TODO: 1- Get data from screen
        String username = etUsername.getText().toString();
        String password =  etPassword.getText().toString();


        // TODO: 2- Data validation
        if (username.trim().isEmpty() || password.trim().isEmpty())
        {
            Toast.makeText(this, "Username or password is missing!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!utils.validateEmail(this,username)||!utils.validatepassword(this,password))
        {
            Toast.makeText(this, "username or password are incorrect", Toast.LENGTH_SHORT).show();
            return;
        }



        // TODO: 3- Check username and password with Firebase Authentication
        fbs.getAuth().createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(SignupActivity.this, AllProductActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(SignupActivity.this, R.string.err_firebase_general, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void gotoAllProduct(View view) {
        Intent i = new Intent(this, AllProductActivity.class);
        startActivity(i);
    }
}
