package micronaut.aerospike.demo.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Data;



@Data
@ConfigurationProperties("aerospike")
public class AerospikeConfigurationProperties {
    private String host;
    private int port;
    private String namespace;
}
