package ca.magex.data.datastore.repositories;

import ca.magex.data.api.entities.Author;
import ca.magex.data.api.entities.Book;
import ca.magex.data.api.entities.Identifier;

public class DataStorePopulator {

	private DataStoreRepository ds;
	
	public DataStorePopulator(DataStoreRepository ds) {
		this.ds = ds;
		addBooks(5);
	}

	private void addBooks(int count) {
		for (int i = 1; i <= count; i++) {
			Author author = ds.authors().save(new Author(new Identifier("author" + i), "First " + i, "Last " + i));
			ds.books().save(new Book(new Identifier("book" + i), "Title " + i, "ISBN-" + (i+17 * 33 + 2000), i + 10 * 8, author));
		}
	}
	
}
