package micronaut.aerospike.demo.configuration;

import com.aerospike.client.AerospikeClient;
import com.aerospike.mapper.tools.AeroMapper;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
public class AerospikeConfiguration {

/*    private static final int maxCommandsInProcess = 40;
    private static final int eventLoopSize = Math.min(Runtime.getRuntime().availableProcessors(), 8);
    private static final int writeTimeout = 5000;*/

    /**
     * Aerospike client aerospike client.
     *
     * @param aerospikeProperties the aerospike properties
     * @return the aerospike client
     */
    @Singleton
    public AerospikeClient aerospikeClient(AerospikeConfigurationProperties aerospikeProperties) {
        //final ClientPolicy clientPolicy = new ClientPolicy();
/*        if (aerospikeProperties.getUsername() != null && aerospikeProperties.getPassword() != null) {
            clientPolicy.user = aerospikeProperties.getUsername();
            clientPolicy.password = aerospikeProperties.getPassword();
        }

        String hosts = String.join(",", aerospikeProperties.getHost());*/
        return new AerospikeClient(aerospikeProperties.getHost(), aerospikeProperties.getPort());
    }

    /**
     * Aerospike mapper aero mapper.
     *
     * @param aerospikeClient the aerospike client
     * @return the aero mapper
     */
    @Singleton
    public AeroMapper aerospikeMapper(AerospikeClient aerospikeClient) {
        return new AeroMapper.Builder(aerospikeClient).build();
    }

    /*    *//**
     * Nio event loops event loops.
     *
     * @return the event loops
     *//*
    @Bean(preDestroy = "close")
    @Singleton
    public EventLoops nioEventLoops() {
        EventPolicy eventPolicy = new EventPolicy();
        eventPolicy.maxCommandsInProcess = maxCommandsInProcess;
        eventPolicy.maxCommandsInQueue = 60;
        eventPolicy.minTimeout = writeTimeout;
        return new NioEventLoops(eventPolicy, eventLoopSize);
    }*/


}
