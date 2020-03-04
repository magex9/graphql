package ca.magex.data.graphql.queries;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import ca.magex.data.api.entities.Book;
import ca.magex.data.api.repositories.Repository;

@Component
public class BookQuery implements GraphQLQueryResolver {
	
    private Repository repository;
    
    public BookQuery(Repository repository) {
        this.repository = repository;
    }

    public Iterable<Book> findAllBooks() {
        return repository.books().findAll();
    }

    public long countBooks() {
        return repository.books().count();
    }
    
}
