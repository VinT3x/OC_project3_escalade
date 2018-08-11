package com.oc.projet3.escalade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;


@SpringBootApplication
@ComponentScan
public class EscaladeApplication {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(EscaladeApplication.class, args);
	}

}
