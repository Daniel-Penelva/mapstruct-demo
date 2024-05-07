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
    /*OBS. A anotação @MappingTarget é usada em conjunto com o MapStruct para indicar que o parâmetro anotado será usado como destino do 
     * mapeamento. Em outras palavras, ele informa ao MapStruct qual objeto deve ser atualizado com os valores resultantes do mapeamento.
     * Por exemplo, considere um método de mapeamento em que você tem um objeto de origem e um objeto de destino. Você quer mapear os valores do
     *  objeto de origem para o objeto de destino. A anotação @MappingTarget é usada para indicar qual objeto de destino será atualizado com os 
     * valores do objeto de origem.
     * No meu exemplo, employeeDto é o objeto de origem e employee é o objeto de destino que será atualizado com os valores do objeto de origem. 
     * A anotação @MappingTarget é usada para indicar que o objeto employee será atualizado com os valores do mapeamento.*/
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

    // Deletar empregado
    @Override
    @Named("deleteEmployee")
    public Employee deleteEmployee(EmployeeDto employeeDto) {
        // A implementação da exclusão não é necessária, pois estamos apenas convertendo DTO para entidade.
        // A lógica de exclusão deve ser tratada no serviço (EmployeeService).
        // Neste método, podemos simplesmente retornar null, pois não precisamos retornar nada após a exclusão.
        return null;
    }

}
