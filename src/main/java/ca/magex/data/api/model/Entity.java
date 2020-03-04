package ca.magex.data.api.model;

import java.util.Objects;

public class Entity {

	private Identifier id;
	
	public Entity(String id) {
		this.id = new Identifier(id);
	}
	
	public Entity(Identifier id) {
		this.id = id;
	}
	
	public Identifier getId() {
		return id;
	}
	
	public boolean equals(Object o) {
		return Objects.equals(this, o);
	}

	public int hashCode() {
		return Objects.hashCode(this);
	}

	@Override
	public String toString() {
		return Objects.toString(this);
	}
	
}
