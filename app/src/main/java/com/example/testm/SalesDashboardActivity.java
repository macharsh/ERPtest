package com.example.testm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SalesDashboardActivity extends AppCompatActivity {

    Button btnSalesOrder, btnCustomers, btnInvoices, btnPayments, btnReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_dashboard);

        btnSalesOrder = findViewById(R.id.btnSalesOrder);
        btnCustomers = findViewById(R.id.btnCustomer);
        btnInvoices = findViewById(R.id.btnInvoice);
        btnPayments = findViewById(R.id.btnPayment);
        btnReports = findViewById(R.id.btnReports);

        btnSalesOrder.setOnClickListener(v -> startActivity(new Intent(this, SalesOrderActivity.class)));
        btnCustomers.setOnClickListener(v -> startActivity(new Intent(this, CustomerActivity.class)));
        btnInvoices.setOnClickListener(v -> startActivity(new Intent(this, InvoiceActivity.class)));
        btnPayments.setOnClickListener(v -> startActivity(new Intent(this, PaymentActivity.class)));
        btnReports.setOnClickListener(v -> startActivity(new Intent(this, ReportsAnalyticsActivity.class)));
    }
}
