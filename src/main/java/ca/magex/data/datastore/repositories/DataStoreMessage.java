package ca.magex.data.datastore.repositories;

public class DataStoreMessage {

	private Object root;
	
	private String path;
	
	private String type;
	
	private String message;

	public DataStoreMessage(Object root, String path, String type, String message) {
		super();
		this.root = root;
		this.path = path;
		this.type = type;
		this.message = message;
	}

	public Object getRoot() {
		return root;
	}

	public String getPath() {
		return path;
	}

	public String getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}
	
}
