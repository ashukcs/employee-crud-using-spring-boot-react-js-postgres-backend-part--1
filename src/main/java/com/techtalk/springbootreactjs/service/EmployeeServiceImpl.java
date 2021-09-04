package com.techtalk.springbootreactjs.service;

import com.techtalk.springbootreactjs.mapper.EmployeeDto;
import com.techtalk.springbootreactjs.model.Employee;
import com.techtalk.springbootreactjs.repository.EmployeeRepository;
import com.techtalk.springbootreactjs.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeUtil employeeUtil;

    @Override
    public List<EmployeeDto> getAllEmployees(){
        return employeeUtil.mapToEmployeeDtoList(employeeRepository.findAll());
    }

    @Override
    public EmployeeDto findById(Integer empId) {
        EmployeeDto employeeDto=null;
        Optional<Employee> existingEmployee = employeeRepository.findById(empId);
        if (existingEmployee.isPresent()){
            employeeDto = employeeUtil.mapToEmployeeDto(existingEmployee.get());
        }
         return employeeDto;
    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto emp){
        return employeeUtil.mapToEmployeeDto(employeeRepository.save(employeeUtil.mapToEmployee(emp)));
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto emp){
        return employeeUtil.mapToEmployeeDto(employeeRepository.save(employeeUtil.mapToEmployee(emp)));
    }

    @Override
    public void deleteEmployee(EmployeeDto emp){
        employeeRepository.delete(employeeUtil.mapToEmployee(emp));
    }
}
