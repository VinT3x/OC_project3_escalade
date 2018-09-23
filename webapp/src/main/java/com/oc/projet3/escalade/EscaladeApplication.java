package com.oc.projet3.escalade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.oc.projet3.escalade"})
@EntityScan(basePackages = {"com.oc.projet3.escalade"})
public class EscaladeApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(EscaladeApplication.class, args);
    }

}
