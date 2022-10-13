package com.example.mvcandroidstadio;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtPasswords;
    private Button btnLogin;
    private TextView messages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.editTextTextPersonName);
        edtPasswords = findViewById(R.id.editTextTextPersonName2);
        btnLogin = findViewById(R.id.btnLoginId);
        messages = findViewById(R.id.textView2);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLogin();
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    private void clickLogin() {
        String email = edtEmail.getText().toString().trim();
        String passwords = edtPasswords.getText().toString().trim();
        User user = new User(email,passwords);
        messages.setVisibility(View.VISIBLE);
        if (user.isValidEmail()&&user.isValidPasswords()){
            messages.setText("login succsess");
            messages.setTextColor(com.google.android.material.R.color.design_default_color_on_primary);
        }else{
            messages.setText("email or passwords invalid");
            messages.setTextColor(R.color.red);
        }

    }
}