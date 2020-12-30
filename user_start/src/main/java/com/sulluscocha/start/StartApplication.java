package com.sulluscocha.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableEurekaClient
@EnableScheduling
@SpringBootApplication
@ComponentScan("com.sulluscocha.*")
@EntityScan("com.sulluscocha.*")
@EnableJpaRepositories("com.sulluscocha.user_persistence.persistence.repositorymysql")
@EnableMongoRepositories("com.sulluscocha.user_persistence.persistence.repositorymongo")
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
