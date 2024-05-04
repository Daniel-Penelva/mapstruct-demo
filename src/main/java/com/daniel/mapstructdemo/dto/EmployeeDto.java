package com.daniel.mapstructdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private int id;
    private String name;
    private int age;
    private String emailAddress;
    private int projectId;

}
