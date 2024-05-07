package com.daniel.mapstructdemo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    // Criar empregado
    public Employee saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeePopulator.INSTANCE.populateEmployee(employeeDto);
        employee.setCreationDate(new Date());
        return employeeRepository.save(employee);
    }

    // Buscar todos os empregados
    public List<EmployeeDto> findAllEmployee() {
        return EmployeePopulator.INSTANCE.findAllEmployeeDtos(employeeRepository.findAll());
    }

    // Buscar empregado por id
    public EmployeeDto findByIdEmployee(Integer idEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(idEmployee);
        if (optionalEmployee.isPresent()) {
            return EmployeePopulator.INSTANCE.findByIdEmployeeDto(idEmployee, optionalEmployee.get());
        } else {
            throw new RuntimeException("Employee not found.");
        }
    }

    // Atualizar empregado por id
    public EmployeeDto updateEmployeeById(Integer idEmployee, EmployeeDto employeeDto){
        Optional<Employee> optionalEmployee = employeeRepository.findById(idEmployee);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            EmployeePopulator.INSTANCE.updateEmployeeFromDto(employeeDto, employee);
            employee.setCreationDate(new Date());                                        // Atualizar a data de criação, se necessário
            employeeRepository.save(employee);
            return EmployeePopulator.INSTANCE.findByIdEmployeeDto(idEmployee, employee); // Retorna o objeto atualizado
        }else{
            throw new RuntimeException("Employee not found.");
        }
    }

    // Deletar empregado
    public void deleteEmployeeById(Integer idEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(idEmployee);
        optionalEmployee.ifPresent(employeeRepository::delete);
    }
    
}
