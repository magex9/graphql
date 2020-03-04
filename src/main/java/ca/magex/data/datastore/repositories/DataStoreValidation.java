package ca.magex.data.datastore.repositories;

import java.util.ArrayList;
import java.util.List;

import ca.magex.data.api.entities.Author;
import ca.magex.data.api.entities.Book;
import ca.magex.data.api.entities.Entity;

public class DataStoreValidation {
	
	private DataStoreRepository ds;
	
	public DataStoreValidation(DataStoreRepository ds) {
		this.ds = ds;
	}
	
	public List<DataStoreMessage> validate(Entity entity) {
		List<DataStoreMessage> messages = new ArrayList<>();
		if (entity.getId() == null)
			messages.add(new DataStoreMessage(entity, "id", "error", "Entities must have valid id's"));
		return messages;
	}
	
	public List<DataStoreMessage> validate(Book book) {
		List<DataStoreMessage> messages = validate((Entity)book);
		if (book.getTitle() == null || book.getTitle().length() < 3)
			messages.add(new DataStoreMessage(book, "title", "error", "Titles must be at least 2 characters long"));
		if (book.getPageCount() < 1)
			messages.add(new DataStoreMessage(book, "pageCount", "error", "Page count must be positive"));
		if (book.getAuthor() == null)
			messages.add(new DataStoreMessage(book, "author", "error", "Author is required"));
		return messages;
	}

	public List<DataStoreMessage> validate(Author author) {
		List<DataStoreMessage> messages = validate((Entity)author);
		if (author.getFirstName() == null || author.getFirstName().length() < 3)
			messages.add(new DataStoreMessage(author, "firstName", "error", "Names must be at least 2 characters long"));
		if (author.getLastName() == null || author.getLastName().length() < 3)
			messages.add(new DataStoreMessage(author, "lastName", "error", "Names must be at least 2 characters long"));
		return messages;
	}

}
