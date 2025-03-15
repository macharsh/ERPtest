package com.example.testm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SalesOrderActivity extends AppCompatActivity {

    Spinner spCustomer;
    EditText etQuantity, etUnitPrice;
    TextView tvTotalAmount, tvOrderDate, tvDeliveryDate;
    Button btnSaveOrder;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_order);

        spCustomer = findViewById(R.id.spCustomer);
        etQuantity = findViewById(R.id.etQuantity);
        etUnitPrice = findViewById(R.id.etUnitPrice);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        tvOrderDate = findViewById(R.id.tvOrderDate);
        tvDeliveryDate = findViewById(R.id.tvDeliveryDate);
        btnSaveOrder = findViewById(R.id.btnSaveOrder);

        databaseHelper = new DatabaseHelper(this);

        btnSaveOrder.setOnClickListener(v -> saveSalesOrder());
    }

    private void saveSalesOrder() {
        String customerName = spCustomer.getSelectedItem().toString();
        String quantityStr = etQuantity.getText().toString();
        String unitPriceStr = etUnitPrice.getText().toString();

        if (customerName.isEmpty() || quantityStr.isEmpty() || unitPriceStr.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int quantity = Integer.parseInt(quantityStr);
        double unitPrice = Double.parseDouble(unitPriceStr);
        double totalPrice = quantity * unitPrice;

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("customer_name", customerName);
        values.put("product_name", "Product Placeholder");  // Change this to actual product selection
        values.put("quantity", quantity);
        values.put("total_price", totalPrice);

        long result = db.insert("sales_orders", null, values);
        db.close();

        if (result != -1) {
            Toast.makeText(this, "Sales Order Saved!", Toast.LENGTH_SHORT).show();
            tvTotalAmount.setText("Total: " + totalPrice);
        } else {
            Toast.makeText(this, "Error Saving Order!", Toast.LENGTH_SHORT).show();
        }
    }
}
