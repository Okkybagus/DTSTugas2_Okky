package com.example.bab4validasi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class WelcomeBack extends AppCompatActivity {

    // Deklarasi variabel editTextEmail dengan tipe EditText
    EditText editTextEmail;
    // Deklarasi variabel editTextPassword dengan tipe EditText
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back);

        // Binding edt_txt_email ke variabel editTextEmail
        editTextEmail = findViewById(R.id.edt_txt_email);
        // Binding edt_txt_password ke variabel editTextPassword
        editTextPassword = findViewById(R.id.edt_txt_password);
    }

    public void clickForgot(View view) {
        Intent i = new Intent(WelcomeBack.this, ForgotPassword.class);
        startActivity(i);
    }

    public void postLogin(View view) {
        // Validasi input email dan password kosong
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim()) &&
                TextUtils.isEmpty(editTextPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Email dan Password tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
        // Validasi input email kosong
        else if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email tidak boleh kosong!",Toast.LENGTH_LONG).show();
        }
        // Validasi inputan tipe email
        else if(!isValidEmail(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email tidak valid!",Toast.LENGTH_LONG).show();
        }
        // Validasi password kosong
        else if(TextUtils.isEmpty(editTextPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Password tidak boleh kosong!",Toast.LENGTH_LONG).show();
        }
        // Cek panjang karakter password
        else if(editTextPassword.getText().toString().length() >= 15) {
            Toast.makeText(view.getContext(), "Password maksimal 15 karakter", Toast.LENGTH_LONG).show();
        }
        // Cek inputan new dan confirm
        else{
            Intent i = new Intent(WelcomeBack.this, SuccessActivity.class);
            startActivity(i);
        }
    }

    public static boolean isValidEmail(CharSequence email){
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    public void clickSignUp(View view) {
        // Panggil intent sign up
    }
}
