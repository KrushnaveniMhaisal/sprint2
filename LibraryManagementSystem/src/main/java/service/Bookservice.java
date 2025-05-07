package service;

import java.util.List;

import Entity.Books;
import Entity.Publisher;

public interface Bookservice {
	Books addBooks(Books books);
	Publisher getPublisher(String publisher_id);
	List<Books> getAllBooks();
	//Enrollment StudentEnrollment(Enrollment enrollment);
	Books getBook(String isbn);
	//List<Enrollment> getEnrollmentDetailsByCourseId(String courseId);
	Books updateBook(String isbn,Books updatedBook);
	String deleteBook(String isbn);


}
