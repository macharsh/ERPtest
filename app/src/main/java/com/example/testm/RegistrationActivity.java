package com.example.testm;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    EditText edtCompanyName, edtAdminName, edtEmail, edtPassword;
    Button btnRegister;
    TextView txtLogin; // Add this line
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        edtCompanyName = findViewById(R.id.companyName);
        edtAdminName = findViewById(R.id.adminName);
        edtEmail = findViewById(R.id.adminEmail);
        edtPassword = findViewById(R.id.adminPassword);
        btnRegister = findViewById(R.id.registerBtn);
        txtLogin = findViewById(R.id.loginLink); // Find the login link

        databaseHelper = new DatabaseHelper(this);

        btnRegister.setOnClickListener(v -> registerCompany());

        // Handle "Already have an account? Login" click
        txtLogin.setOnClickListener(v -> {
            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void registerCompany() {
        String companyName = edtCompanyName.getText().toString();
        String adminName = edtAdminName.getText().toString();
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        if (companyName.isEmpty() || adminName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("company_name", companyName);
        values.put("admin_name", adminName);
        values.put("email", email);
        values.put("password", password);

        long result = db.insert("companies", null, values);
        db.close();

        if (result != -1) {
            Toast.makeText(this, "Company Registered!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Registration Failed!", Toast.LENGTH_SHORT).show();
        }
    }
}
