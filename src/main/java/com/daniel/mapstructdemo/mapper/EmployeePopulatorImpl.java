package com.daniel.mapstructdemo.mapper;

import com.daniel.mapstructdemo.dto.EmployeeDto;
import com.daniel.mapstructdemo.entity.Employee;

public class EmployeePopulatorImpl implements EmployeePopulator {

    @Override
    public Employee populateEmployee(EmployeeDto employeeDto) {

        if (employeeDto == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setEmailAddress(employeeDto.getEmailAddress());
        employee.setProjectId(employeeDto.getProjectId());

        return employee;
    }

}
