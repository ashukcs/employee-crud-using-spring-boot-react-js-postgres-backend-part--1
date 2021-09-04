package com.techtalk.springbootreactjs.util;

import com.techtalk.springbootreactjs.mapper.EmployeeDto;
import com.techtalk.springbootreactjs.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeUtil {
    public Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmailId());
    }

    public EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId());
    }

    public List<EmployeeDto> mapToEmployeeDtoList(List<Employee> employeeList) {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeList.stream().forEach((employee) ->
                employeeDtoList.add(new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId()))
        );
        return employeeDtoList;
    }
}
