package com.techtalk.springbootreactjs.controller;

import com.techtalk.springbootreactjs.mapper.EmployeeDto;
import com.techtalk.springbootreactjs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer empId) {
        EmployeeDto existingEmployeeDto = null;
        try {
            existingEmployeeDto = employeeService.findById(empId);
        } catch (Exception e) {
            new MissingResourceException("Employee doest not exists with id - " + empId, null, empId.toString());
        }
        return ResponseEntity.ok(existingEmployeeDto);
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.addEmployee(employeeDto));
    }

    @PutMapping("/employees/{empId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Integer empId, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto existingEmployeeDto = null;
        try {
            existingEmployeeDto = employeeService.findById(empId);
        } catch (Exception e) {
            new MissingResourceException("Employee doest not exists with id - " + empId, null, empId.toString());
        }
        existingEmployeeDto.setFirstName(employeeDto.getFirstName());
        existingEmployeeDto.setLastName(employeeDto.getLastName());
        existingEmployeeDto.setEmailId(employeeDto.getEmailId());
        employeeService.updateEmployee(existingEmployeeDto);

        return ResponseEntity.ok(existingEmployeeDto);
    }

    @DeleteMapping("/employees/{empId}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer empId) {
        EmployeeDto existingEmployeeDto = null;
        try {
            existingEmployeeDto = employeeService.findById(empId);
        } catch (Exception e) {
            new MissingResourceException("Employee doest not exists with id - " + empId, null, empId.toString());
        }
        employeeService.deleteEmployee(existingEmployeeDto);
        Map<String, Boolean> responseMap = new HashMap<>();
        responseMap.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(responseMap);
    }
}
