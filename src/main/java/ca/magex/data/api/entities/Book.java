package ca.magex.data.api.entities;

public class Book extends Entity {

	private String title;

	private String isbn;

	private int pageCount;

	private Author author;

	public Book(Identifier id, String title, String isbn, int pageCount, Author author) {
		super(id);
		this.title = title;
		this.isbn = isbn;
		this.pageCount = pageCount;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}
	
	public Book withTitle(String title) {
		return new Book(getId(), title, isbn, pageCount, author);
	}

	public String getIsbn() {
		return isbn;
	}

	public Book withIsbn(String isbn) {
		return new Book(getId(), title, isbn, pageCount, author);
	}

	public int getPageCount() {
		return pageCount;
	}

	public Book withPageCount(Integer pageCount) {
		return new Book(getId(), title, isbn, pageCount, author);
	}

	public Author getAuthor() {
		return author;
	}

	public Book withAuthor(Author author) {
		return new Book(getId(), title, isbn, pageCount, author);
	}

}