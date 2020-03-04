package ca.magex.data.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ca.magex.data.api.repositories.Repository;
import ca.magex.data.datastore.repositories.DataStoreRepository;

@SpringBootApplication
public class DemoGraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGraphQlApplication.class, args);
	}

	@Bean
	public Repository repo() {
		return new DataStoreRepository();
	}

}