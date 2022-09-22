package micronaut.aerospike.demo.repository;

import com.aerospike.mapper.tools.AeroMapper;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import micronaut.aerospike.demo.pojo.Employee;


@AllArgsConstructor
public class EmployeeRepository {

    @Inject
    AeroMapper aeroMapper;

    public void save(Employee employee) {
        aeroMapper.save(employee);
    }

    public Employee findById(Integer id) {
        return aeroMapper.read(Employee.class, id);
    }

}
