package com.example.testm;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LeadConversionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_conversion); // Must match XML filename

        Button btnConvertLead = findViewById(R.id.btnConvertLead);
        btnConvertLead.setOnClickListener(view -> {
            // Perform lead conversion action
        });
    }
}


