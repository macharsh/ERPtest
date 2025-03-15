package com.example.testm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Employee> employeeList;

    public EmployeeAdapter(Context context, ArrayList<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.txtName.setText(employee.getName());
        holder.txtEmail.setText(employee.getEmail());
        holder.txtPhone.setText(employee.getPhone());
        holder.txtDesignation.setText(employee.getDesignation());
        holder.txtDepartment.setText(employee.getDepartment());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtEmail, txtPhone, txtDesignation, txtDepartment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtEmployeeName);
            txtEmail = itemView.findViewById(R.id.txtEmployeeEmail);
            txtPhone = itemView.findViewById(R.id.txtEmployeePhone);
            txtDesignation = itemView.findViewById(R.id.txtEmployeeDesignation);
            txtDepartment = itemView.findViewById(R.id.txtEmployeeDepartment);
        }
    }
}
