package com.example.testm;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ViewEmployeeActivity extends AppCompatActivity {
    ListView employeeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);

        // Ensure this matches the ListView ID in the XML file
        employeeListView = findViewById(R.id.employeeListView);
    }
}
