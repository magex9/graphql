package ca.magex.data.graphql.queries;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import ca.magex.data.api.entities.Author;
import ca.magex.data.api.repositories.Repository;

@Component
public class AuthorQuery implements GraphQLQueryResolver {
	
    private Repository repository;
    
    public AuthorQuery(Repository repository) {
        this.repository = repository;
    }

    public Iterable<Author> findAllAuthors() {
        return repository.authors().findAll();
    }

    public long countAuthors() {
        return repository.authors().count();
    }
    
}
