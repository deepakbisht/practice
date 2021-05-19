package DesignPattern.Structural.Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Deepak Bisht on 17/05/21
 */
public class EmployeeClient {
    public List<Employee> getAllEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        NativeEmployee nativeEmployee = new NativeEmployee("1", "D", "B", "D.d.com");
        employees.add(nativeEmployee);
        // Adapter for adding a new Class To EmployeeList
        EmployeeLDAP employeeLDAP = new EmployeeLDAP("2","E", "E2", "ss.com");
        //  client doest know
        employees.add(new EmployeeLDAPAdapter(employeeLDAP));
        return employees;
    }
    public static void main(String[] args) {

    } 
}
