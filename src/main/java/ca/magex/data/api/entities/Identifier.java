package ca.magex.data.api.entities;

public class Identifier {

	private String id;
	
	public Identifier(String id) {
		if (id == null || id.length() == 0)
			throw new IllegalArgumentException("Id is required for identifiers");
		String mid = id.replaceAll("[^A-Za-z0-9]", "");
		if (id == null || id.length() < 5)
			throw new IllegalArgumentException("Machine id must be at least 5 characters long: " + mid);
		this.id = mid;
	}

	@Override
	public String toString() {
		return id;
	}
	
}
