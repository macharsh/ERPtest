package com.example.testm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "erp_system.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // ✅ Create Companies Table
        db.execSQL("CREATE TABLE companies (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "company_name TEXT, " +
                "admin_name TEXT, " +
                "email TEXT UNIQUE, " +
                "password TEXT)");

        // ✅ Create Employees Table (Merged basic & extended info)
        db.execSQL("CREATE TABLE employees (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "email TEXT UNIQUE, " +
                "password TEXT, " +
                "phone TEXT, " +
                "address TEXT, " +
                "designation TEXT, " +
                "department TEXT, " +
                "role TEXT, " +
                "company_id INTEGER, " +
                "FOREIGN KEY(company_id) REFERENCES companies(id) ON DELETE CASCADE)");

        // ✅ Create Products Table
        db.execSQL("CREATE TABLE products (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "description TEXT, " +
                "code TEXT, " +
                "category TEXT, " +
                "unit TEXT, " +
                "company_id INTEGER, " +
                "FOREIGN KEY(company_id) REFERENCES companies(id) ON DELETE CASCADE)");

        // ✅ Create Sales Orders Table
        db.execSQL("CREATE TABLE sales_orders (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "customer_name TEXT, " +
                "product_name TEXT, " +
                "quantity INTEGER, " +
                "total_price REAL, " +
                "company_id INTEGER, " +
                "FOREIGN KEY(company_id) REFERENCES companies(id) ON DELETE CASCADE)");

        // ✅ Create Customers Table
        db.execSQL("CREATE TABLE customers (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "customer_name TEXT, " +
                "email TEXT, " +
                "phone TEXT, " +
                "address TEXT, " +
                "company_name TEXT, " +
                "customer_type TEXT, " +
                "notes TEXT, " +
                "company_id INTEGER, " +
                "FOREIGN KEY(company_id) REFERENCES companies(id) ON DELETE CASCADE)");

        // ✅ Create CRM Leads Table
        db.execSQL("CREATE TABLE leads (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "lead_name TEXT, " +
                "email TEXT, " +
                "phone TEXT, " +
                "status TEXT, " +
                "company_id INTEGER, " +
                "FOREIGN KEY(company_id) REFERENCES companies(id) ON DELETE CASCADE)");

        // ✅ Create Follow-ups Table
        db.execSQL("CREATE TABLE follow_ups (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "lead_id INTEGER, " +
                "follow_up_date TEXT, " +
                "notes TEXT, " +
                "FOREIGN KEY(lead_id) REFERENCES leads(id) ON DELETE CASCADE)");

        // ✅ Create Support Tickets Table
        db.execSQL("CREATE TABLE support_tickets (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "customer_id INTEGER, " +
                "issue_description TEXT, " +
                "status TEXT, " +
                "company_id INTEGER, " +
                "FOREIGN KEY(customer_id) REFERENCES customers(id) ON DELETE CASCADE, " +
                "FOREIGN KEY(company_id) REFERENCES companies(id) ON DELETE CASCADE)");

        // ✅ Create Warehouses Table
        db.execSQL("CREATE TABLE warehouses (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "warehouse_name TEXT, " +
                "location TEXT, " +
                "capacity INTEGER, " +
                "company_id INTEGER, " +
                "FOREIGN KEY(company_id) REFERENCES companies(id) ON DELETE CASCADE)");

        // ✅ Create Stock Management Table
        db.execSQL("CREATE TABLE stock_management (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "item_name TEXT, " +
                "warehouse_id INTEGER, " +
                "current_stock INTEGER, " +
                "company_id INTEGER, " +
                "FOREIGN KEY(warehouse_id) REFERENCES warehouses(id) ON DELETE CASCADE, " +
                "FOREIGN KEY(company_id) REFERENCES companies(id) ON DELETE CASCADE)");

        // ✅ Create Stock Transfers Table (Fixed Foreign Keys)
        db.execSQL("CREATE TABLE stock_transfers (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "item_name TEXT, " +
                "from_warehouse_id INTEGER, " +
                "to_warehouse_id INTEGER, " +
                "quantity INTEGER, " +
                "company_id INTEGER, " +
                "FOREIGN KEY(from_warehouse_id) REFERENCES warehouses(id) ON DELETE CASCADE, " +
                "FOREIGN KEY(to_warehouse_id) REFERENCES warehouses(id) ON DELETE CASCADE, " +
                "FOREIGN KEY(company_id) REFERENCES companies(id) ON DELETE CASCADE)");

        // ✅ Create Attendance Table
        db.execSQL("CREATE TABLE attendance (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "employee_id INTEGER, " +
                "date TEXT, " +
                "status TEXT, " +
                "company_id INTEGER, " +
                "FOREIGN KEY(employee_id) REFERENCES employees(id) ON DELETE CASCADE, " +
                "FOREIGN KEY(company_id) REFERENCES companies(id) ON DELETE CASCADE)");

        // ✅ Create Salary Table
        db.execSQL("CREATE TABLE salary (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "employee_id INTEGER, " +
                "month TEXT, " +
                "salary_amount REAL, " +
                "company_id INTEGER, " +
                "FOREIGN KEY(employee_id) REFERENCES employees(id) ON DELETE CASCADE, " +
                "FOREIGN KEY(company_id) REFERENCES companies(id) ON DELETE CASCADE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS companies");
        db.execSQL("DROP TABLE IF EXISTS employees");
        db.execSQL("DROP TABLE IF EXISTS products");
        db.execSQL("DROP TABLE IF EXISTS sales_orders");
        db.execSQL("DROP TABLE IF EXISTS customers");
        db.execSQL("DROP TABLE IF EXISTS leads");
        db.execSQL("DROP TABLE IF EXISTS follow_ups");
        db.execSQL("DROP TABLE IF EXISTS support_tickets");
        db.execSQL("DROP TABLE IF EXISTS warehouses");
        db.execSQL("DROP TABLE IF EXISTS stock_management");
        db.execSQL("DROP TABLE IF EXISTS stock_transfers");
        db.execSQL("DROP TABLE IF EXISTS attendance");
        db.execSQL("DROP TABLE IF EXISTS salary");
        onCreate(db);
    }
}
