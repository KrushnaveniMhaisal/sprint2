package DaoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Entity.Books;
import Entity.Publisher;
import Dao.BooksDao;
import Util.HibernateUtil;

public class BooksDaoImpl implements BooksDao {

	Scanner sc = new Scanner(System.in);

	// Add a new book to the database
	@Override
	public Books addBooks(Books books) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction(); // Start transaction
			session.save(books);        // Save book entity
			session.getTransaction().commit(); // Commit transaction
			return books;
		} catch (HibernateException e) {
			System.out.println("HibernateException: " + e);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	// Retrieve all books from the database
	@Override
	public List<Books> getAllBooks() {
		try (Session session = HibernateUtil.getSession()) {
			// HQL query to fetch all book records
			Query<Books> query = session.createQuery("FROM Books");
			List<Books> bookList = query.list();
			return bookList;
		} catch (HibernateException e) {
			System.out.println("HibernateException: " + e);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	// Fetch a single book using its ISBN
	public Books getBook(String isbn) {
		try (Session session = HibernateUtil.getSession()) {
			Books book = session.get(Books.class, isbn); // Retrieve by primary key
			return book;
		} catch (HibernateException e) {
			System.out.println("HibernateException: " + e);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	// Get Publisher details by Publisher ID
	@Override
	public Publisher getPublisher(String publisher_id) {
		try (Session session = HibernateUtil.getSession()) {
			Publisher publisher = session.get(Publisher.class, publisher_id);
			return publisher;
		} catch (HibernateException e) {
			System.out.println("HibernateException: " + e);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	// Update an existing book's details using its ISBN
	@Override
	public Books updateBook(String isbn, Books updatedBook) {
		try (Session session = HibernateUtil.getSession()) {
			Books book = session.get(Books.class, isbn); // Fetch the existing book
			session.beginTransaction();

			// Set new values
			book.setISBN(isbn);
			book.setTitle(updatedBook.getTitle());
			book.setEdition(updatedBook.getEdition());
			book.setCategory(updatedBook.getCategory());
			book.setPrice(updatedBook.getPrice());
			book.setIssueDate(updatedBook.getIssueDate());
			book.setPublisher(updatedBook.getPublisher());

			session.saveOrUpdate(book); // Update the book
			session.getTransaction().commit();
			return book;
		} catch (HibernateException e) {
			System.out.println("HibernateException: " + e);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

	// ✅ Delete a book by ISBN (with user confirmation)
	@Override
	public String deleteBook(String isbn) {
		String message = null;
		try (Session session = HibernateUtil.getSession()) {
			Books book = session.get(Books.class, isbn); // Fetch book by ISBN
			session.beginTransaction();

			System.out.println("Are you sure you want to delete? (yes/no)");
			String status = sc.next();

			if (status.equalsIgnoreCase("yes")) {
				session.delete(book);              // Delete from DB
				session.getTransaction().commit(); // Commit transaction
				session.evict(book);               // Evict from session cache
				message = "Books data is deleted";
			} else {
				message = "User wants to retain this object!!";
			}
		} catch (HibernateException e) {
			System.out.println("HibernateException: " + e);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return message;
	}

}
