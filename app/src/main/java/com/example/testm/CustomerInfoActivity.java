package com.example.testm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerInfoActivity extends AppCompatActivity {

    EditText etCustomerName, etEmail, etPhone, etAddress, etCompanyName, etNotes;
    Spinner spinnerCustomerType;
    Button btnSaveCustomer;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        etCustomerName = findViewById(R.id.etCustomerName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        etCompanyName = findViewById(R.id.etCompanyName);
        etNotes = findViewById(R.id.etNotes);
        spinnerCustomerType = findViewById(R.id.spinnerCustomerType);
        btnSaveCustomer = findViewById(R.id.btnSaveCustomer);

        databaseHelper = new DatabaseHelper(this);

        btnSaveCustomer.setOnClickListener(v -> saveCustomer());
    }

    private void saveCustomer() {
        String customerName = etCustomerName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String address = etAddress.getText().toString().trim();
        String companyName = etCompanyName.getText().toString().trim();
        String customerType = spinnerCustomerType.getSelectedItem().toString();
        String notes = etNotes.getText().toString().trim();

        if (customerName.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Please fill required fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("customer_name", customerName);
        values.put("email", email);
        values.put("phone", phone);
        values.put("address", address);
        values.put("company_name", companyName);
        values.put("customer_type", customerType);
        values.put("notes", notes);

        long result = db.insert("customers", null, values);
        db.close();

        if (result != -1) {
            Toast.makeText(this, "Customer saved successfully!", Toast.LENGTH_SHORT).show();
            clearFields();
        } else {
            Toast.makeText(this, "Error saving customer!", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        etCustomerName.setText("");
        etEmail.setText("");
        etPhone.setText("");
        etAddress.setText("");
        etCompanyName.setText("");
        etNotes.setText("");
        spinnerCustomerType.setSelection(0);
    }
}
