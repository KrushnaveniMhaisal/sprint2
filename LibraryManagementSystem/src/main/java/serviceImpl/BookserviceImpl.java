package serviceImpl;

import java.util.List;

import DaoImpl.BooksDaoImpl;
import Entity.Books;
import Entity.Publisher;
import service.Bookservice;



public class BookserviceImpl implements Bookservice {
	BooksDaoImpl booksDao =new BooksDaoImpl();

	public Books addBooks(Books book) {
		//invoke daoimpl method to save book object

		return booksDao.addBooks(book);

	}

	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		return booksDao.getAllBooks();
	}


	@Override
	public Books getBook(String isbn) {
		// TODO Auto-generated method stub
		return booksDao.getBook(isbn);
	}

	public Publisher getPublisher(String publisher_id) {
		// TODO Auto-generated method stub
		return booksDao.getPublisher(publisher_id);
	}


	@Override
	public Books updateBook(String isbn, Books updatedBooks) {

		return booksDao.updateBook(isbn, updatedBooks);
	}

	@Override
	public String deleteBook(String isbn) {
		return booksDao.deleteBook(isbn);
	}




}
