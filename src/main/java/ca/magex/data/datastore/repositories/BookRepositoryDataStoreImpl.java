package ca.magex.data.datastore.repositories;

import ca.magex.data.api.entities.Book;
import ca.magex.data.api.repositories.BookRepository;

public class BookRepositoryDataStoreImpl implements BookRepository {

	private DataStoreRepository ds;
	
	public BookRepositoryDataStoreImpl(DataStoreRepository ds) {
		this.ds = ds;
	}
	
	@Override
	public Book findOne(String id) {
		return ds.findObjectById(Book.class, id);
	}

	@Override
	public Iterable<Book> findAll() {
		return ds.findObjectByType(Book.class);
	}

	@Override
	public long count() {
		return ds.findCountByType(Book.class);
	}

	@Override
	public Book save(Book book) {
		return ds.save(book);
	}

	@Override
	public boolean delete(String id) {
		return ds.delete(Book.class, id);
	}

}
