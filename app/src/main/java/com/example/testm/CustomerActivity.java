package com.example.testm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CustomerActivity extends AppCompatActivity {

    EditText edtCustomerName, edtEmail, edtPhone;
    Button btnSave;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        edtCustomerName = findViewById(R.id.etCustomerName);
        edtEmail = findViewById(R.id.etEmail);
        edtPhone = findViewById(R.id.etPhone);
        btnSave = findViewById(R.id.btnSaveCustomer);

        databaseHelper = new DatabaseHelper(this);

        btnSave.setOnClickListener(v -> saveCustomer());
    }

    private void saveCustomer() {
        String customerName = edtCustomerName.getText().toString();
        String email = edtEmail.getText().toString();
        String phone = edtPhone.getText().toString();

        if (customerName.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("customer_name", customerName);
        values.put("email", email);
        values.put("phone", phone);

        long result = db.insert("customers", null, values);
        db.close();

        if (result != -1) {
            Toast.makeText(this, "Customer Added!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error Adding Customer!", Toast.LENGTH_SHORT).show();
        }
    }
}
