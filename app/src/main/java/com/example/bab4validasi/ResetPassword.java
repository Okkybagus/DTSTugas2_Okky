package com.example.bab4validasi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPassword extends AppCompatActivity {

    // Deklarasi EditText
    EditText editTextCode, editTextNewPassword, editTextConfirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        // Binding EditText
        editTextCode = findViewById(R.id.edt_txt_code);
        editTextNewPassword = findViewById(R.id.edt_new_password);
        editTextConfirmPassword = findViewById(R.id.edt_confirm_password);

    }

    public void postChangePassword(View view) {
        // Validasi kosong
        if(TextUtils.isEmpty(editTextCode.getText().toString().trim()) &&
                TextUtils.isEmpty(editTextNewPassword.getText().toString().trim()) &&
                TextUtils.isEmpty(editTextConfirmPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Tidak boleh kosong!",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(editTextCode.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Code tidak boleh kosong!",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(editTextNewPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(),"New Password tidak boleh kosong!",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(editTextConfirmPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Confirm Password tidak boleh kosong!",Toast.LENGTH_LONG).show();
        }
        // Cek panjang karakter password
        else if(editTextNewPassword.getText().toString().length() >= 15 || editTextConfirmPassword.getText().toString().length() >= 15) {
            Toast.makeText(view.getContext(), "Password maksimal 15 karakter", Toast.LENGTH_LONG).show();
        }
        // Cek inputan new dan confirm
        else if(!editTextNewPassword.getText().toString().equals(editTextConfirmPassword.getText().toString())){
            Toast.makeText(view.getContext(),"Confirm Password tidak sama",Toast.LENGTH_LONG).show();
        }
        else{
            Intent i = new Intent(ResetPassword.this, SuccessActivity.class);
            startActivity(i);
        }
    }
}
