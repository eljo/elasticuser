package com.github.eljo.elasticuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@SpringBootApplication
@Import(RepositoryRestMvcConfiguration.class)
public class ElasticuserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticuserApplication.class, args);
	}
}
