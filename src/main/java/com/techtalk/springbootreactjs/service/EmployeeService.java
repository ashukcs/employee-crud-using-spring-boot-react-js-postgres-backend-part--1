package com.techtalk.springbootreactjs.service;

import com.techtalk.springbootreactjs.mapper.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<EmployeeDto> getAllEmployees();
    public EmployeeDto findById(Integer empId);
    public EmployeeDto addEmployee(EmployeeDto emp);
    public EmployeeDto updateEmployee(EmployeeDto emp);
    public void deleteEmployee(EmployeeDto emp);
}
