package ca.magex.data.datastore.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import ca.magex.data.api.exceptions.EntityNotFoundException;
import ca.magex.data.api.model.Entity;
import ca.magex.data.api.model.Identifier;
import ca.magex.data.api.repositories.AuthorRepository;
import ca.magex.data.api.repositories.BookRepository;
import ca.magex.data.api.repositories.Repository;

public class DataStoreRepository implements Repository {

	private Map<Identifier, Object> data;
	
	private AuthorRepository authors;
	
	private BookRepository books;
	
	public DataStoreRepository() {
		data = new HashMap<Identifier, Object>();
		authors = new AuthorRepositoryDataStoreImpl(this);
		books = new BookRepositoryDataStoreImpl(this);
		new DataStorePopulator(this);
	}
	
	@SuppressWarnings("unchecked")
	public <T> Iterable<T> findObjectByType(Class<T> cls) {
		return data.values().stream()
			.filter(o -> o.getClass().isAssignableFrom(cls))
			.map(o -> (T)o)
			.collect(Collectors.toList());
	}
	
	public <T> long findCountByType(Class<T> cls) {
		return data.values().stream()
			.filter(o -> o.getClass().isAssignableFrom(cls))
			.count();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findObjectById(Class<T> cls, String id) {
		Identifier mid = new Identifier(id);
		if (data.containsKey(mid))
			throw new EntityNotFoundException(mid);
		if (!(data.get(mid).getClass().isAssignableFrom(cls)))
			throw new IllegalArgumentException("Value is not of expected class: " + cls.getName());
		return (T)data.get(mid);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T save(Entity entity) {
		new DataStoreValidation(this).validate(entity);
		data.put(entity.getId(), entity);
		return (T)entity;
	}
	
	public <T> boolean delete(Class<T> cls, String id) {
		Identifier mid = new Identifier(id);
		if (data.containsKey(mid))
			return false;
		if (!(data.get(mid).getClass().isAssignableFrom(cls)))
			throw new IllegalArgumentException("Value is not of expected class: " + cls.getName());
		data.remove(mid);
		return true;
	}
	
	public AuthorRepository authors() {
		return authors;
	}
	
	public BookRepository books() {
		return books;
	}
	
}
