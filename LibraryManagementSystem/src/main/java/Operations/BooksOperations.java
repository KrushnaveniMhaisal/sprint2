package Operations;

import java.util.List;
import java.util.Scanner;

import com.demo.LMS.App;

import Entity.Books;
import Entity.Publisher;
import Exception.ResourceNotFoundException;
import service.Bookservice;
import serviceImpl.BookserviceImpl;


public class BooksOperations {

	static BookserviceImpl bookService=new BookserviceImpl();
	static Scanner sc=new Scanner(System.in);
	public static Books BooksInputs() {
		sc.nextLine();

		String isbn;
		do {
			System.out.print("Enter ISBN: ");
			isbn = sc.nextLine();
			if (isbn.trim().isEmpty()) System.out.println("ISBN cannot be empty.");
		} while (isbn.trim().isEmpty());

		String title;
		do {
			System.out.print("Enter Title: ");
			title = sc.nextLine();
			if (title.trim().isEmpty()) System.out.println("Title cannot be empty.");
		} while (title.trim().isEmpty());

		String edition;
		do {
			System.out.print("Enter Edition: ");
			edition = sc.nextLine();
			if (edition.trim().isEmpty()) System.out.println("Edition cannot be empty.");
		} while (edition.trim().isEmpty());

		String category;
		do {
			System.out.print("Enter Category: ");
			category = sc.nextLine();
			if (category.trim().isEmpty()) System.out.println("Category cannot be empty.");
		} while (category.trim().isEmpty());

		int price;
		do {
			System.out.print("Enter Price: ");
			while (!sc.hasNextInt()) {
				System.out.println("Price must be a number.");
				sc.next(); // discard invalid input
			}
			price = sc.nextInt();
			if (price <= 0) System.out.println("Price must be a positive number.");
		} while (price <= 0);
		sc.nextLine();

		String idate;
		do {
			System.out.print("Enter Issue Date (YYYY-MM-DD): ");
			idate = sc.nextLine();
			if (!idate.matches("\\d{4}-\\d{2}-\\d{2}")) System.out.println("Invalid date format.");
		} while (!idate.matches("\\d{4}-\\d{2}-\\d{2}"));

		String pid;
		Publisher p;
		do {
			System.out.print("Enter Publisher Id: ");
			pid = sc.nextLine();
			p = bookService.getPublisher(pid);
			if (p == null) System.out.println("Publisher not found. Enter valid Publisher Id.");
		} while (p == null);

		return new Books(isbn, title, edition, category, price, idate,  p);
	}

	public static Void booksOperations()
	{
		while(true) {
			System.out.println();
			System.out.println("======Books Details=====");
			System.out.println("Press 1.Add Books\nPress 2.View Books\n"
					+ "Press 3.Update Books \nPress 4.Delete Books \n"
					+ "Press 5.To getback to the main menu");
			int input=sc.nextInt();	

			switch(input) {
			case 1:
				Books books=BooksInputs();
				Books savedEntity=bookService.addBooks(books);
				System.out.println();
				System.out.println("Books Data has been saved successfully\n"+ savedEntity);
				break;

			case 2:
				List<Books> books1=bookService.getAllBooks();
				System.out.println();
				for(Books book:books1)
				{
					System.out.println(book);
				}
				break;

			case 3:sc.nextLine();
			System.out.println("Enter isbn to update the Books data");
			String bId=sc.next();
			Books r=bookService.getBook(bId);
			if(r!=null) {
				Books rd=updatedBooksData(bId);
				//service
				Books updatedInfo=bookService.updateBook(bId, rd);
				System.out.println("Books Data has been updated Successfully\n"+ updatedInfo);
			}

			else
			{
				throw new ResourceNotFoundException("user Id not found");
			}

			break;

			case 4:
				System.out.println("Enter isbn to delete the Books Data");
				String id=sc.next();
				String message=bookService.deleteBook(id);
				System.out.println(message);
				break;
			case 5:App.mainOps();
			}
		}

	}

	public static Books updatedBooksData(String isbn)
	{
		sc.nextLine();


		String title;
		do {
			System.out.print("Enter Title: ");
			title = sc.nextLine();
			if (title.trim().isEmpty()) System.out.println("Title cannot be empty.");
		} while (title.trim().isEmpty());

		String edition;
		do {
			System.out.print("Enter Edition: ");
			edition = sc.nextLine();
			if (edition.trim().isEmpty()) System.out.println("Edition cannot be empty.");
		} while (edition.trim().isEmpty());

		String category;
		do {
			System.out.print("Enter Category: ");
			category = sc.nextLine();
			if (category.trim().isEmpty()) System.out.println("Category cannot be empty.");
		} while (category.trim().isEmpty());

		int price;
		do {
			System.out.print("Enter Price: ");
			while (!sc.hasNextInt()) {
				System.out.println("Price must be a number.");
				sc.next(); // discard invalid input
			}
			price = sc.nextInt();
			if (price <= 0) System.out.println("Price must be a positive number.");
		} while (price <= 0);
		sc.nextLine();

		String idate;
		do {
			System.out.print("Enter Issue Date (YYYY-MM-DD): ");
			idate = sc.nextLine();
			if (!idate.matches("\\d{4}-\\d{2}-\\d{2}")) System.out.println("Invalid date format.");
		} while (!idate.matches("\\d{4}-\\d{2}-\\d{2}"));



		String pid;
		Publisher p;
		do {
			System.out.print("Enter Publisher Id: ");
			pid = sc.nextLine();
			p = bookService.getPublisher(pid);
			if (p == null) System.out.println("Publisher not found. Enter valid Publisher Id.");
		} while (p == null);

		return new Books(isbn, title, edition, category, price, idate,  p);
	}
}
