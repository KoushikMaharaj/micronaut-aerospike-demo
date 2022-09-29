package micronaut.aerospike.demo.service;

import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import micronaut.aerospike.demo.pojo.Employee;
import micronaut.aerospike.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
class EmployeeServiceTest {
    @Inject
    EmployeeService employeeService;
    @Inject
    EmployeeRepository employeeRepository;

    @Test
    void findAll() {
        List<Employee> employees = Arrays.asList(new Employee(123, "ram")
                , new Employee(124, "sham"));
        when(employeeRepository.findAll()).thenReturn(employees);
        assertEquals(employees, employeeService.findAll());
    }


    @Test
    void findById() {
        Employee employee = new Employee(123, "ram");
        when(employeeRepository.findById(123)).thenReturn(employee);
        assertEquals(employee, employeeService.findById(123));
    }

    @MockBean(EmployeeRepository.class)
    EmployeeRepository employeeRepository() {
        return mock(EmployeeRepository.class);
    }
}