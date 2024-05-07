package com.daniel.mapstructdemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.mapstructdemo.dto.EmployeeDto;
import com.daniel.mapstructdemo.entity.Employee;
import com.daniel.mapstructdemo.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    // http://localhost:8081/employee/add
    @PostMapping("/add")
    public ResponseEntity<Employee> create(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    // http://localhost:8081/employee/all
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> findAllEmployee() {
        return new ResponseEntity<>(employeeService.findAllEmployee(), HttpStatus.OK);
    }

    // http://localhost:8081/employee/by/{id}
    @GetMapping("/by/{id}")
    public ResponseEntity<EmployeeDto> findByIdEmployee(@PathVariable("id") Integer idEmployee) {
        return new ResponseEntity<>(employeeService.findByIdEmployee(idEmployee), HttpStatus.OK);
    }


    // http://localhost:8081/employee/replace/{id}
    @PutMapping("/replace/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable("id") Integer idEmployee, @RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployee = employeeService.updateEmployeeById(idEmployee, employeeDto);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee); // Retorna o funcionário atualizado se a atualização for bem-sucedida
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se o funcionário não for encontrado
        }
    }


    // http://localhost:8081/employee/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Integer idEmployee) {
        employeeService.deleteEmployeeById(idEmployee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
