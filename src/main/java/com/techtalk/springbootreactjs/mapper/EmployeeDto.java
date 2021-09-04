package com.techtalk.springbootreactjs.mapper;

import com.techtalk.springbootreactjs.model.Employee;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailId;
}
