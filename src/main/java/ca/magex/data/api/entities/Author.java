package ca.magex.data.api.entities;

import ca.magex.data.api.model.Entity;
import ca.magex.data.api.model.Identifier;

public class Author extends Entity {

	private String firstName;

	private String lastName;

	public Author(Identifier id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public Author withFirstName(String firstName) {
		return new Author(getId(), firstName, firstName);
	}

	public String getLastName() {
		return lastName;
	}

	public Author withLastName(String lastName) {
		return new Author(getId(), firstName, firstName);
	}

}