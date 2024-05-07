package com.daniel.mapstructdemo.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.daniel.mapstructdemo.dto.EmployeeDto;
import com.daniel.mapstructdemo.entity.Employee;

public class EmployeePopulatorImpl implements EmployeePopulator {

    // Criar empregado
    @Override
    @Named("populateEmployee")
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

    // Buscar todos os empregados
    @Override
    @Named("findAllEmployeeDtos")
    public List<EmployeeDto> findAllEmployeeDtos(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return Collections.emptyList();
        }

        List<EmployeeDto> employeeDtos = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setName(employee.getName());
            employeeDto.setAge(employee.getAge());
            employeeDto.setEmailAddress(employee.getEmailAddress());
            employeeDto.setProjectId(employee.getProjectId());
            employeeDtos.add(employeeDto);
        }

        return employeeDtos;
    }

    // Buscar empregado por id
    @Override
    @Named("findByIdEmployeeDto")
    public EmployeeDto findByIdEmployeeDto(Integer idEmployee, Employee employee) {

        if (idEmployee == null || !idEmployee.equals(employee.getId())) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setAge(employee.getAge());
        employeeDto.setEmailAddress(employee.getEmailAddress());
        employeeDto.setProjectId(employee.getProjectId());

        return employeeDto;
    }

    // Atualizar empregado
    @Override
    @Named("updateEmployeeFromDto")
    public void updateEmployeeFromDto(EmployeeDto employeeDto, @MappingTarget Employee employee) {
        
        if (employeeDto == null || employee == null) {
            return;
        }

        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setEmailAddress(employeeDto.getEmailAddress());
        employee.setProjectId(employeeDto.getProjectId());
    }

}
