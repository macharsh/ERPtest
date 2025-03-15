package com.example.testm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddEmployeeActivity extends AppCompatActivity {

    EditText etEmployeeName, etEmail, etPhoneNumber, etAddress;
    Spinner spinnerDesignation, spinnerDepartment;
    Button btnSaveEmployee;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        // Use correct IDs from XML
        etEmployeeName = findViewById(R.id.etEmployeeName);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etAddress = findViewById(R.id.etAddress);
        spinnerDesignation = findViewById(R.id.spinnerDesignation);
        spinnerDepartment = findViewById(R.id.spinnerDepartment);
        btnSaveEmployee = findViewById(R.id.btnSaveEmployee);

        databaseHelper = new DatabaseHelper(this);

        btnSaveEmployee.setOnClickListener(v -> saveEmployee());
    }

    private void saveEmployee() {
        String name = etEmployeeName.getText().toString();
        String email = etEmail.getText().toString();
        String phone = etPhoneNumber.getText().toString();
        String address = etAddress.getText().toString();
        String designation = spinnerDesignation.getSelectedItem().toString();
        String department = spinnerDepartment.getSelectedItem().toString();

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("phone", phone);
        values.put("address", address);
        values.put("designation", designation);
        values.put("department", department);

        long result = db.insert("employees", null, values);
        db.close();

        if (result != -1) {
            Toast.makeText(this, "Employee Added!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error Adding Employee!", Toast.LENGTH_SHORT).show();
        }
    }
}
