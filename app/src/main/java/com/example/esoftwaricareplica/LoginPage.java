package com.example.esoftwaricareplica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnlogin) {
            login();
        }
    }

    private void login() {
        String usernametxt = username.getText().toString();
        String passwordtxt = password.getText().toString();

        if (validate(usernametxt, passwordtxt)) {

            if (usernametxt.equals("softwarica") && passwordtxt.equals("coventry")) {
                startActivity(new Intent(LoginPage.this, Home.class));
            } else {
                username.setError("Username or Password Incorrect");
                username.requestFocus();
            }
        }

    }

    private boolean validate(String usernametxt, String passwordtxt) {
        if (TextUtils.isEmpty(usernametxt)) {
            username.setError("Username cannot be empty!");
            username.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(passwordtxt)) {
            password.setError("Password cannot be empty!");
            password.requestFocus();
            return false;
        }

        return true;
    }
}
