package com.daniel.mapstructdemo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.daniel.mapstructdemo.dto.EmployeeDto;
import com.daniel.mapstructdemo.entity.Employee;

@Mapper
public interface EmployeePopulator {

    EmployeePopulator INSTANCE = Mappers.getMapper(EmployeePopulator.class);

    // Convertendo de um objeto DTO (Data Transfer Object) para uma entidade (Entity) - gerar um registro para o banco
    @Mapping(target = "id", ignore = true)                                              // Indica que durante o mapeamento de um objeto de origem para um objeto de destino, a propriedade "id" deve ser ignorada.
    @Mapping(target = "creationDate", ignore = true)
    Employee populateEmployee(EmployeeDto employeeDto);

    // Convertendo de uma entidade (Entity) para um objeto DTO (Data Transfer Object) - gerar um dto para o usuario
    @Mapping(target = "id", ignore = true)                                              
    @Mapping(target = "creationDate", ignore = true)
    List<EmployeeDto> findAllEmployeeDtos(List<Employee> employees);


    // Convertendo de uma entidade (Entity) para um objeto DTO (Data Transfer Object) - gerar um dto para o usuario
    @Mapping(target = "id", ignore = true)
    EmployeeDto findByIdEmployeeDto(Integer idEmployee, Employee employee);


    @Mapping(target = "id", ignore = true)                                              
    @Mapping(target = "creationDate", ignore = true)
    void updateEmployeeFromDto(EmployeeDto employeeDto, @MappingTarget Employee employee);

}

/*Bom Saber:
 * DTO: Objetos leves que carregam apenas os dados necessários para a interface do usuário ou para a comunicação entre camadas.
 * 
 * Entidade: Objetos que representam as entidades do domínio da aplicação, com todas as suas propriedades e regras de negócio.
 * 
 * Então, nesse caso, o método populateEmployee() está pegando os dados do objeto DTO EmployeeDto e preenchendo as propriedades da 
 * entidade Employee, transformando o DTO em uma entidade.
 * Isso é importante para separar as preocupações entre as camadas e manter a integridade do modelo de domínio da aplicação.
*/