package ca.magex.data.graphql.mutations;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import ca.magex.data.api.entities.Author;
import ca.magex.data.api.repositories.Repository;

@Component
public class AuthorMutation implements GraphQLMutationResolver {

	private Repository repository;

	public AuthorMutation(Repository repository) {
		this.repository = repository;
	}

	public Author newAuthor(String firstName, String lastName) {
		return repository.authors().save(new Author(null, firstName, lastName));
	}

}