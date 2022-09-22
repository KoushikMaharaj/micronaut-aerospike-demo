package micronaut.aerospike.demo.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import micronaut.aerospike.demo.pojo.Employee;
import micronaut.aerospike.demo.repository.EmployeeRepository;

@Singleton
public class EmployeeService {

    @Inject
    EmployeeRepository employeeRepository;

    public void save(Employee employee) {
        employeeRepository.save(employee);

    }

    public Employee findById(Integer empId) {
            return employeeRepository.findById(empId);
    }

//    public Iterable<Employee> findAll() {
//
//    }
}
