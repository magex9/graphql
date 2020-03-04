package ca.magex.data.graphql.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import ca.magex.data.api.entities.Author;
import ca.magex.data.api.entities.Book;
import ca.magex.data.api.repositories.Repository;

public class Query implements GraphQLQueryResolver {
	
    private Repository repository;
    
    public Query(Repository repository) {
        this.repository = repository;
        this.repository = repository;
    }

    public Iterable<Book> findAllBooks() {
        return repository.books().findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return repository.authors().findAll();
    }

    public long countBooks() {
        return repository.books().count();
    }
    
    public long countAuthors() {
        return repository.authors().count();
    }
    
}