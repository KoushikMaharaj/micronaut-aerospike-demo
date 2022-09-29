package micronaut.aerospike.demo.repository;

import com.aerospike.mapper.tools.AeroMapper;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import micronaut.aerospike.demo.pojo.EmailMapper;
import micronaut.aerospike.demo.pojo.Employee;

import java.util.List;


@AllArgsConstructor
public class EmployeeRepository {
    @Inject
    AeroMapper aeroMapper;

    public void save(Employee employee) {
        EmailMapper emailMapper = new EmailMapper(employee.getEmail(), employee.getId());
        aeroMapper.save(emailMapper);
        aeroMapper.save(employee);
    }

    public Employee findById(Integer id) {
        return aeroMapper.read(Employee.class, id);
    }


    public EmailMapper findByEmail(String email) {
        return aeroMapper.read(EmailMapper.class, email);
    }

    public List<Employee> findAll() {
        return aeroMapper.scan(Employee.class);
    }

}
