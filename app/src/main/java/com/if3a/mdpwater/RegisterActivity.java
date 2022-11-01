package com.if3a.mdpwater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etNama, etEmail, etPassword, etTanggal;
    Button btnSignup, btnBack;

    String nama, email, password, tanggal, choosenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNama = findViewById(R.id.et_Nama);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etTanggal = findViewById(R.id.et_date);
        btnSignup = findViewById(R.id.btn_singup1);
        btnBack = findViewById(R.id.btn_back);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = etNama.getText().toString();
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();

                if(nama.trim().equals(""))
                {
                    etNama.setError("Nama Tidak Boleh Kosong");
                }
                else if(email.trim().equals(""))
                {
                    etEmail.setError("Email Tidak Boleh Kosong");
                }
                else if(password.trim().equals(""))
                {
                    etPassword.setError("Password Tidak Boleh Kosong");
                }
                else{
                    Intent kirim = new Intent(RegisterActivity.this, ResultActivity.class);
                    kirim.putExtra("varNama", nama);
                    kirim.putExtra("varEmail", email);
                    kirim.putExtra("varPassword", password);
                    startActivity(kirim);
                }

                AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
                dialog.setTitle("Attention");
                dialog.setMessage("Are you sure?");

                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(RegisterActivity.this,"Terimakasih, Anda berhasil Terdaftar", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();

            }
        });



    }
}