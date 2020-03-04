package ca.magex.data.graphql.mutations;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import ca.magex.data.api.entities.Book;
import ca.magex.data.api.repositories.Repository;

@Component
public class BookMutation implements GraphQLMutationResolver {

	private Repository repository;

	public BookMutation(Repository repository) {
		this.repository = repository;
	}

	public Book newBook(String title, String isbn, Integer pageCount, String authorId) {
		return repository.books().save(new Book(null, title, isbn, pageCount, repository.authors().findOne(authorId)));
	}

	public boolean deleteBook(String id) {
		return repository.books().delete(id);
	}

	public Book updateBookPageCount(Integer pageCount, String id) {
		return repository.books().save(repository.books().findOne(id).withPageCount(pageCount));
	}

}