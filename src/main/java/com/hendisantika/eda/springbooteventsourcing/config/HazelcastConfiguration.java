package com.hendisantika.eda.springbooteventsourcing.config;

import com.hazelcast.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-event-sourcing
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-24
 * Time: 06:55
 */
@Configuration
public class HazelcastConfiguration {
    //    @Bean
//    public HazelcastInstance hazelcastClient() {
//        ClientConfig clientConfig = new ClientConfig();
//        return HazelcastClient.newHazelcastClient(clientConfig);
//    }
    @Bean
    public Config hazelConfig() {

        Config config = new Config();
        config.setInstanceName("hazel-test");
        config.getGroupConfig().setName("dev").setPassword("pass");
        return config;
    }

}