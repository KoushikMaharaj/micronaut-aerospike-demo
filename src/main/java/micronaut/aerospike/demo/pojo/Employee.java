package micronaut.aerospike.demo.pojo;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@AerospikeRecord(namespace = "test", set = "emp")
public class Employee implements Serializable {
    @AerospikeKey
    private Integer id;

    @AerospikeBin
    private String name;
}
