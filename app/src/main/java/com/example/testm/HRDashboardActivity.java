package com.example.testm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HRDashboardActivity extends AppCompatActivity {

    Button btnAddEmployee, btnViewEmployee, btnAttendance, btnSalaryCalculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr_dashboard);

        // Initialize buttons
        btnViewEmployee = findViewById(R.id.btnViewEmployee);
        btnAddEmployee = findViewById(R.id.btnAddEmployee);
        btnAttendance = findViewById(R.id.btnAttendance);
        btnSalaryCalculation = findViewById(R.id.btnSalaryCalculation);

        // Set click listeners for navigation
        btnAddEmployee.setOnClickListener(v -> startActivity(new Intent(this, AddEmployeeActivity.class)));
        btnViewEmployee.setOnClickListener(v -> startActivity(new Intent(this, ViewEmployeeActivity.class)));
        btnAttendance.setOnClickListener(v -> startActivity(new Intent(this, AttendanceActivity.class)));
        btnSalaryCalculation.setOnClickListener(v -> startActivity(new Intent(this, SalaryCalculationActivity.class)));
    }
}
