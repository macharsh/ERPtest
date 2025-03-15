package com.example.testm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class CRMDashboardActivity extends AppCompatActivity {

    Button btnCustomerInfo, btnLeads, btnFollowUps, btnSupportTickets, btnLeadConversion, btnReports, btnExportData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crm_dashboard);

        // Initializing buttons
        btnCustomerInfo = findViewById(R.id.btnCustomerInfo);
        btnLeads = findViewById(R.id.btnLeads);
        btnFollowUps = findViewById(R.id.btnFollowUps);
        btnSupportTickets = findViewById(R.id.btnSupportTickets);
        btnLeadConversion = findViewById(R.id.btnLeadConversion);
        btnReports = findViewById(R.id.btnReports);


        // Setting up button click listeners
        btnCustomerInfo.setOnClickListener(v -> startActivity(new Intent(this, CustomerInfoActivity.class)));
        btnLeads.setOnClickListener(v -> startActivity(new Intent(this, LeadsActivity.class)));
        btnFollowUps.setOnClickListener(v -> startActivity(new Intent(this, FollowUpsActivity.class)));
        btnSupportTickets.setOnClickListener(v -> startActivity(new Intent(this, SupportTicketsActivity.class)));
        btnLeadConversion.setOnClickListener(v -> startActivity(new Intent(this, LeadConversionActivity.class)));
        btnReports.setOnClickListener(v -> startActivity(new Intent(this, ReportsActivity.class)));

    }
}
