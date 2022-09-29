package micronaut.aerospike.demo.pojo;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeEmbed;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@AerospikeRecord(namespace = "test", set = "emp")
public class Employee implements Serializable {
    @AerospikeKey
    private Integer id;

    @AerospikeBin
    private String name;

    @AerospikeBin
    private String email;

    @AerospikeEmbed
    private Aaadhar aaadhar;

    @AerospikeEmbed(type = AerospikeEmbed.EmbedType.LIST)
    private List<String> phones;


    public Employee(int i, String ram) {
        this.id = i;
        this.name = ram;
    }
}
