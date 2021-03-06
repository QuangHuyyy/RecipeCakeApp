package com.example.recipecake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText txtEmail, txtPassword, txtPasswordConfirm;
    private TextView btnLogin;
    private Button btnRegister;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getViews();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLogin();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRegister();
            }
        });
    }

    private void getViews() {
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtPasswordConfirm = findViewById(R.id.txtPasswordConfirm);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void onRegister() {
        String email, password, passwordConfirm;
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String passwordPattern = ".{8,20}";

        email = txtEmail.getText().toString();
        password = txtPassword.getText().toString();
        passwordConfirm = txtPasswordConfirm.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Vui l??ng nh???p email!", Toast.LENGTH_LONG).show();
            return;
        }
        if (!email.matches(emailPattern)){
            Toast.makeText(this, "Email kh??ng ????ng ?????nh d???ng!", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Vui l??ng nh???p m???t kh???u!", Toast.LENGTH_LONG).show();
            return;
        }
        if (!password.matches(passwordPattern)){
            Toast.makeText(this, "M???t kh???u t??? 8-20 k?? t???!", Toast.LENGTH_LONG).show();
            return;
        }
        if (!TextUtils.equals(password, passwordConfirm)){
            Toast.makeText(this, "M???t kh???u nh???p l???i kh??ng ch??nh x??c!", Toast.LENGTH_LONG).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "????ng k?? th??nh c??ng.", Toast.LENGTH_LONG).show();
                    onLogin();
                }else {
                    Toast.makeText(getApplicationContext(), "Email ???? t???n t???i!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void onLogin() {
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }
}