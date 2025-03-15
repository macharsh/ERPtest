package com.example.testm;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String designation;
    private String department;

    public Employee(int id, String name, String email, String phone, String designation, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.designation = designation;
        this.department = department;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDesignation() { return designation; }
    public String getDepartment() { return department; }
}
