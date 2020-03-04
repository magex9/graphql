package ca.magex.data.graphql.resolvers;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import ca.magex.data.api.entities.Author;
import ca.magex.data.api.entities.Book;
import ca.magex.data.api.repositories.Repository;

@Component
public class BookResolver implements GraphQLResolver<Book> {
	
    private Repository repository;

    public BookResolver(Repository repository) {
        this.repository = repository;
    }
    
    public Author getAuthor(Book book) {
        return repository.authors().findOne(book.getAuthor().getId().toString());
    }
    
}