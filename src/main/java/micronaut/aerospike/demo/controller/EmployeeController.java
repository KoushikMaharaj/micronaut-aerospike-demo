package micronaut.aerospike.demo.controller;

import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import micronaut.aerospike.demo.pojo.Employee;
import micronaut.aerospike.demo.service.EmployeeService;

@Controller("/emp")
public class EmployeeController {
    @Inject
    EmployeeService employeeService;

    @Post()
    public void save(@Body Employee employee) {
        employeeService.save(employee);
    }

    @Get("/{id}")
    public Employee findById(@PathVariable("id") Integer empId) {
        return employeeService.findById(empId);
    }
}
