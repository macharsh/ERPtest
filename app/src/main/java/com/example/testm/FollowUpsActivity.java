package com.example.testm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FollowUpsActivity extends AppCompatActivity {

    Spinner spinnerCustomerLead, spinnerFollowupType;
    TextView tvSelectedDate, tvSelectedTime;
    EditText etFollowupNotes;
    Button btnSelectDate, btnSelectTime, btnSaveFollowup;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followups);

        // Initialize UI elements
        spinnerCustomerLead = findViewById(R.id.spinnerCustomerLead);
        spinnerFollowupType = findViewById(R.id.spinnerFollowupType);
        tvSelectedDate = findViewById(R.id.tvSelectedDate);
        tvSelectedTime = findViewById(R.id.tvSelectedTime);
        etFollowupNotes = findViewById(R.id.etFollowupNotes);
        btnSelectDate = findViewById(R.id.btnSelectDate);
        btnSelectTime = findViewById(R.id.btnSelectTime);
        btnSaveFollowup = findViewById(R.id.btnSaveFollowup);

        databaseHelper = new DatabaseHelper(this);

        btnSaveFollowup.setOnClickListener(v -> saveFollowUp());
    }

    private void saveFollowUp() {
        String leadName = spinnerCustomerLead.getSelectedItem().toString();
        String followUpDate = tvSelectedDate.getText().toString();
        String followUpTime = tvSelectedTime.getText().toString();
        String followUpType = spinnerFollowupType.getSelectedItem().toString();
        String notes = etFollowupNotes.getText().toString();

        if (leadName.isEmpty() || followUpDate.equals("Selected Date: None") ||
                followUpTime.equals("Selected Time: None") || notes.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("lead_name", leadName);
        values.put("follow_up_date", followUpDate);
        values.put("follow_up_time", followUpTime);
        values.put("follow_up_type", followUpType);
        values.put("notes", notes);

        long result = db.insert("follow_ups", null, values);
        db.close();

        if (result != -1) {
            Toast.makeText(this, "Follow-up Scheduled!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error Scheduling Follow-up!", Toast.LENGTH_SHORT).show();
        }
    }
}
