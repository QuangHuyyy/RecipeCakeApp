package com.example.recipecake;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {
    private EditText edtNewPassword, edtConfirmNewPassword;
    private Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        getViews();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passwordPattern = ".{8,20}";
                String newPass, newConfirm;
                newPass = edtNewPassword.getText().toString().trim();
                newConfirm = edtConfirmNewPassword.getText().toString().trim();

                if(TextUtils.isEmpty(newPass)){
                    Toast.makeText(ChangePasswordActivity.this, "Vui lòng nhập mật khẩu!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!newPass.matches(passwordPattern)){
                    Toast.makeText(ChangePasswordActivity.this, "Mật khẩu từ 8-20 ký tự!", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!TextUtils.equals(newPass, newConfirm)){
                    Toast.makeText(ChangePasswordActivity.this, "Mật khẩu nhập lại không chính xác!", Toast.LENGTH_LONG).show();
                    return;
                }

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String newPassword = newPass;

                user.updatePassword(newPassword)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ChangePasswordActivity.this, "Change password success", Toast.LENGTH_SHORT).show();
                                    ChangePasswordActivity.this.finish();
                                }
                            }
                        });
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(ChangePasswordActivity.this, MainActivity.class);
//                startActivity(i);
                ChangePasswordActivity.this.finish();
            }
        });
    }

    private void getViews() {
        edtNewPassword = findViewById(R.id.txtNewPassword);
        edtConfirmNewPassword = findViewById(R.id.txtNewPasswordConfirm);

        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);
    }
}