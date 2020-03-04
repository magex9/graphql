package ca.magex.data.api.repositories;

import ca.magex.data.api.entities.Book;
import ca.magex.data.api.exceptions.EntityNotFoundException;

public interface BookRepository {

	Book findOne(String id) throws EntityNotFoundException;

	Iterable<Book> findAll();

	long count();

	Book save(Book book);

	boolean delete(String id) throws EntityNotFoundException;

}
