package com.example.testm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class WarehouseActivity extends AppCompatActivity {

    EditText edtWarehouseName, edtLocation, edtCapacity;
    Button btnSave;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse);

        edtWarehouseName = findViewById(R.id.etWarehouseName);
        edtLocation = findViewById(R.id.etWarehouseLocation);
        edtCapacity = findViewById(R.id.etWarehouseCapacity);
        btnSave = findViewById(R.id.btnSaveWarehouse);

        databaseHelper = new DatabaseHelper(this);

        btnSave.setOnClickListener(v -> saveWarehouse());
    }

    private void saveWarehouse() {
        String warehouseName = edtWarehouseName.getText().toString();
        String location = edtLocation.getText().toString();
        String capacity = edtCapacity.getText().toString();

        if (warehouseName.isEmpty() || location.isEmpty() || capacity.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("warehouse_name", warehouseName);
        values.put("location", location);
        values.put("capacity", capacity);

        long result = db.insert("warehouses", null, values);
        db.close();

        if (result != -1) {
            Toast.makeText(this, "Warehouse Saved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error Saving Warehouse!", Toast.LENGTH_SHORT).show();
        }
    }
}

