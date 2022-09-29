package micronaut.aerospike.demo.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import micronaut.aerospike.demo.pojo.EmailMapper;
import micronaut.aerospike.demo.pojo.Employee;
import micronaut.aerospike.demo.service.EmployeeService;

import java.util.HashSet;
import java.util.Map;

@Controller("/emp")
public class EmployeeController {
    @Inject
    EmployeeService employeeService;

    @Post
    public void save(@Body Employee employee) {

        employeeService.save(employee);
    }

    @Get("/{id}")
    public HttpResponse<?> findById(@PathVariable("id") Integer empId) {
        return HttpResponse.ok(employeeService.findById(empId));
    }

    @Get
    public HttpResponse<?> findByEmail(@QueryValue String email) {
        return HttpResponse.ok(employeeService.findByEmail(email));
    }

    @Get("/findAll")
    public HttpResponse<?> findAll() {
        return HttpResponse.ok(employeeService.findAll());
    }
}
