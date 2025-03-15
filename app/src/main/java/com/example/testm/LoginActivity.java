package com.example.testm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    Button btnLogin;
    TextView txtRegister; // Add this line
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.loginEmail);
        edtPassword = findViewById(R.id.loginPassword);
        btnLogin = findViewById(R.id.loginButton);
        txtRegister = findViewById(R.id.registerLink); // Find the register link

        databaseHelper = new DatabaseHelper(this);

        btnLogin.setOnClickListener(v -> loginUser());

        // Handle "Don't have an account? Register" click
        txtRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });
    }

    private void loginUser() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM companies WHERE email=? AND password=?", new String[]{email, password});

        if (cursor.moveToFirst()) {
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, AdminDashboardActivity.class));
            finish();
        } else {
            cursor = db.rawQuery("SELECT * FROM employees WHERE email=? AND password=?", new String[]{email, password});
            if (cursor.moveToFirst()) {
                Toast.makeText(this, "Employee Login Successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, EmployeeDashboardActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
            }
        }

        cursor.close();
        db.close();
    }
}
