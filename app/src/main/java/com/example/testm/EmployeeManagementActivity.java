package com.example.testm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class EmployeeManagementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_management);

        Button btnAddEmployee = findViewById(R.id.btnAddEmployee);
        Button btnViewEmployees = findViewById(R.id.btnViewEmployees);

        btnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmployeeManagementActivity.this, AddEmployeeActivity.class));
            }
        });

        btnViewEmployees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmployeeManagementActivity.this, ViewEmployeesActivity.class));
            }
        });
    }
}

