package ca.magex.data.datastore.repositories;

import ca.magex.data.api.entities.Author;
import ca.magex.data.api.repositories.AuthorRepository;

public class AuthorRepositoryDataStoreImpl implements AuthorRepository {

	private DataStoreRepository ds;
	
	public AuthorRepositoryDataStoreImpl(DataStoreRepository ds) {
		this.ds = ds;
	}

	@Override
	public Author findOne(String id) {
		return ds.findObjectById(Author.class, id);
	}

	@Override
	public Iterable<Author> findAll() {
		return ds.findObjectByType(Author.class);
	}

	@Override
	public long count() {
		return ds.findCountByType(Author.class);
	}

	@Override
	public Author save(Author author) {
		return ds.save(author);
	}

}
