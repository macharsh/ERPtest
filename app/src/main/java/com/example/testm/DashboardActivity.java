package com.example.testm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    Button btnSales, btnCRM, btnManufacturing, btnInventory, btnHR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnSales = findViewById(R.id.btnSales);
        btnCRM = findViewById(R.id.btnCRM);
        btnManufacturing = findViewById(R.id.btnManufacturing);
        btnInventory = findViewById(R.id.btnInventory);
        btnHR = findViewById(R.id.btnHR);

        btnSales.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, SalesDashboardActivity.class)));
        btnCRM.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, CRMDashboardActivity.class)));
        btnManufacturing.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, ManufacturingDashboardActivity.class)));
        btnInventory.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, InventoryDashboardActivity.class)));
        btnHR.setOnClickListener(v -> startActivity(new Intent(DashboardActivity.this, HRDashboardActivity.class)));
    }
}
