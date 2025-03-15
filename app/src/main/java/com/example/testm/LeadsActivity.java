package com.example.testm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LeadsActivity extends AppCompatActivity {

    EditText edtLeadName, edtEmail, edtPhone, edtStatus;
    Button btnSave;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leads);

        edtLeadName = findViewById(R.id.etLeadName);
        edtEmail = findViewById(R.id.etEmail);
        edtPhone = findViewById(R.id.etPhone);
        edtStatus = findViewById(R.id.spinnerStatus);
        btnSave = findViewById(R.id.btnSaveLead);

        databaseHelper = new DatabaseHelper(this);

        btnSave.setOnClickListener(v -> saveLead());
    }

    private void saveLead() {
        String leadName = edtLeadName.getText().toString();
        String email = edtEmail.getText().toString();
        String phone = edtPhone.getText().toString();
        String status = edtStatus.getText().toString();

        if (leadName.isEmpty() || email.isEmpty() || phone.isEmpty() || status.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("lead_name", leadName);
        values.put("email", email);
        values.put("phone", phone);
        values.put("status", status);

        long result = db.insert("leads", null, values);
        db.close();

        if (result != -1) {
            Toast.makeText(this, "Lead Saved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error Saving Lead!", Toast.LENGTH_SHORT).show();
        }
    }
}
