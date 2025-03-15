package com.example.testm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class InventoryDashboardActivity extends AppCompatActivity {

    Button btnWarehouse, btnStock, btnStockTransfer, btnAlerts, btnExportData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_dashboard);

        // Use correct IDs from XML
        btnWarehouse = findViewById(R.id.btnWarehouse);
        btnStock = findViewById(R.id.btnStock);
        btnStockTransfer = findViewById(R.id.btnStockTransfer);
        btnAlerts = findViewById(R.id.btnAlerts);
        btnExportData = findViewById(R.id.btnExportData);

        // Set click listeners
        btnWarehouse.setOnClickListener(v -> startActivity(new Intent(this, WarehouseActivity.class)));
        btnStock.setOnClickListener(v -> startActivity(new Intent(this, StockManagementActivity.class)));
        btnStockTransfer.setOnClickListener(v -> startActivity(new Intent(this, StockTransferActivity.class)));
        btnAlerts.setOnClickListener(v -> startActivity(new Intent(this, RecordAlertsActivity.class)));
        btnExportData.setOnClickListener(v -> {
            // Implement export functionality
        });
    }
}
