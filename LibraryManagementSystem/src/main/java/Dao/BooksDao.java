package Dao;

import java.util.List;

import Entity.Books;
import Entity.Publisher;

public interface BooksDao {
	Books addBooks(Books books);	
	List<Books> getAllBooks();
	Publisher getPublisher(String publisher_id);
	
	Books getBook(String isbn);
	Books updateBook(String isbn,Books updatedBook);
	String deleteBook(String isbn);

}
