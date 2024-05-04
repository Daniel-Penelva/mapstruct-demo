package com.daniel.mapstructdemo.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.daniel.mapstructdemo.dto.EmployeeDto;
import com.daniel.mapstructdemo.entity.Employee;
import com.daniel.mapstructdemo.mapper.EmployeePopulator;
import com.daniel.mapstructdemo.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeePopulator.INSTANCE.populateEmployee(employeeDto);
        employee.setCreationDate(new Date());
        return employeeRepository.save(employee);
    }

}
