package com.example.testm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ManufacturingDashboardActivity extends AppCompatActivity {

    Button btnProducts, btnBOM, btnRawMaterials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manufacturing_dashboard);

        btnProducts = findViewById(R.id.btnProducts);
        btnBOM = findViewById(R.id.btnBOM);
        btnRawMaterials = findViewById(R.id.btnRawMaterials);

        btnProducts.setOnClickListener(v -> startActivity(new Intent(this, ProductsActivity.class)));
        btnBOM.setOnClickListener(v -> startActivity(new Intent(this, BOMActivity.class)));
        btnRawMaterials.setOnClickListener(v -> startActivity(new Intent(this, RawMaterialsActivity.class)));
    }
}
