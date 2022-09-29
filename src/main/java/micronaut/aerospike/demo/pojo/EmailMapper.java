package micronaut.aerospike.demo.pojo;

import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@AerospikeRecord(namespace = "test",set = "m_email")
public class EmailMapper {
    @AerospikeKey
    private String email;
    private int id;
}
