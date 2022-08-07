package com.example.homework2_5.service;

import com.example.homework2_5.EmployeeAlreadyAddedException;
import com.example.homework2_5.exception.EmployeeNotFoundException;
import com.example.homework2_5.exception.EmployeeStorageIsFullException;
import com.example.homework2_5.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final List<Employee> employees = new ArrayList<>();


    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }


    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    /*public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }*/

}