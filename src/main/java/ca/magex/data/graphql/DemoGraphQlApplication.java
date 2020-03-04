package ca.magex.data.graphql;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ca.magex.data.api.repositories.Repository;
import ca.magex.data.datastore.repositories.DataStoreRepository;
import ca.magex.data.graphql.resolvers.BookResolver;
import ca.magex.data.graphql.service.Mutation;
import ca.magex.data.graphql.service.Query;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;

@SpringBootApplication
public class DemoGraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGraphQlApplication.class, args);
	}

	@Bean
	public GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream().filter(this::isClientError)
						.collect(Collectors.toList());

				List<GraphQLError> serverErrors = errors.stream().filter(e -> !isClientError(e))
						.map(GraphQLErrorAdapter::new).collect(Collectors.toList());

				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}

			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
	}
	
	@Bean
	public Repository repo() {
		return new DataStoreRepository();
	}

    @Bean
	public BookResolver authorResolver(Repository repo) {
		return new BookResolver(repo);
	}

	@Bean
	public Query query(Repository repo) {
		return new Query(repo);
	}

	@Bean
	public Mutation mutation(Repository repo) {
		return new Mutation(repo);
	}

}