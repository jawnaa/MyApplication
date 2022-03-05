package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
{
    private EditText etUsername, etPassword;
    private FirebaseAuth auth;
    private Utilities utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsernamemain);
        etPassword = findViewById(R.id.etPasswordmain);
        auth = FirebaseAuth.getInstance();
        utils= Utilities. getInstance();
    }

    public void login(View view)
    {
        //TODO 1- Get data from screen
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        //TODO 2- Data validation
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            Toast.makeText(this, "Username or password is missing!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!utils.validateEmail(this,username)||!utils.validatepassword(this,password)){
            Toast.makeText(this, "username or password are incorrect", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // TODO: goto all products page
                        } else {


                            Toast.makeText(MainActivity.this, "Username or password is empty!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });

    }


    public void gotoSignup(View view) {
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
    }
    public void gotoAddProduct (View view) {
        Intent i = new Intent(this, AddProduct.class);
        startActivity(i);
    }

    public void gotoAllProduct(View view) {
        Intent i = new Intent(this, AllProductActivity.class);
        startActivity(i);
    }
}


}


















