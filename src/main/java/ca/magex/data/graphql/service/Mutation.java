package ca.magex.data.graphql.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import ca.magex.data.api.entities.Author;
import ca.magex.data.api.entities.Book;
import ca.magex.data.api.repositories.Repository;

public class Mutation implements GraphQLMutationResolver {

	private Repository repository;

	public Mutation(Repository repository) {
		this.repository = repository;
	}

	public Author newAuthor(String firstName, String lastName) {
		return repository.authors().save(new Author(null, firstName, lastName));
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