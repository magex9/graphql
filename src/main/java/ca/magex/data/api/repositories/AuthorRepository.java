package ca.magex.data.api.repositories;

import ca.magex.data.api.entities.Author;
import ca.magex.data.api.exceptions.EntityNotFoundException;

public interface AuthorRepository {

	Author findOne(String id) throws EntityNotFoundException;

	Iterable<Author> findAll();

	long count();

	Author save(Author author) throws EntityNotFoundException;

}
