package Operations;

import java.util.List;
import java.util.Scanner;

import com.demo.LMS.App;

import Entity.Books;
import Entity.Readers;
import Entity.Reports;
import Entity.Staff;
import serviceImpl.ReportserviceImpl;
/*
public class ReportOperations {


	 static ReportserviceImpl reportService = new ReportserviceImpl();
	    static Scanner sc = new Scanner(System.in);

	    public static void reportOperations() {
	        while (true) {
	            System.out.println("====== Report Menu ======");
	            System.out.println("1. Generate New Report");
	            System.out.println("2. Back to Main Menu");
	            System.out.print("Enter your choice: ");
	            int input = sc.nextInt();
	            sc.nextLine(); // Consume newline

	            switch (input) {
	                case 1:
	                    generateReport();
	                    break;

	                case 2:
	                    return; // Exit to main menu
	                default:
	                    System.out.println("Invalid choice! Please try again.");
	            }
	        }
	    }

	    private static void generateReport() {
	        System.out.print("Enter Reader ID: ");
	        String uid = sc.nextLine();

	        System.out.print("Enter Book ISBN: ");
	        String isbn = sc.nextLine();

	        System.out.print("Enter Staff ID: ");
	        String sid = sc.nextLine();

	        Readers reader = reportService.getReaders(uid);
	        Books book = reportService.getBooks(isbn);
	        Staff staff = reportService.getStaff(sid);

	        if (reader == null || book == null || staff == null) {
	            System.out.println("❌ One or more IDs are invalid. Please try again.");
	            return;
	        }

	        System.out.print("Enter Issue Date (YYYY-MM-DD): ");
	        String issueDate = sc.nextLine();

	        System.out.print("Enter Return Date (YYYY-MM-DD): ");
	        String returnDate = sc.nextLine();

	        Reports report = new Reports(issueDate, returnDate, staff, reader, book);
	        reportService.addReport(report); // Save to DB

	        // ✅ Display the saved report
	        System.out.println("\n✅ Report Generated Successfully!");
	        System.out.println("--- Report Details ---");
	        System.out.println("RegNo: " + report.getRegNo());
	        System.out.println("Reader ID: " + reader.getUser_id());
	        System.out.println("Reader Name: " + reader.getFirstName() + " " + reader.getLastName());
	        System.out.println("Book ISBN: " + book.getISBN());
	        System.out.println("Book Title: " + book.getTitle());
	        System.out.println("Staff ID: " + staff.getStaff_id());
	        System.out.println("Issue Date: " + issueDate);
	        System.out.println("Return Date: " + returnDate);
	    }
}*/



import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class ReportOperations {

	static ReportserviceImpl reportService = new ReportserviceImpl();
	static Scanner sc = new Scanner(System.in);

	public static void reportOperations() {
		while (true) {
			System.out.println("\n====== Report Menu ======");
			System.out.println("1. Generate New Report");
			System.out.println("2. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int input = sc.nextInt();
			sc.nextLine(); // Consume newline

			switch (input) {
			case 1:
				generateReport();
				break;
			case 2:
				return;
			default:
				System.out.println("❌ Invalid choice! Please try again.");
			}
		}
	}

	private static void generateReport() {
		String uid, isbn, role;
		do {
			System.out.print("Enter Reader ID: ");
			uid = sc.nextLine();
			if (uid.trim().isEmpty()) System.out.println("❌ Reader ID cannot be empty.");
		} while (uid.trim().isEmpty());

		do {
			System.out.print("Enter Book ISBN: ");
			isbn = sc.nextLine();
			if (isbn.trim().isEmpty()) System.out.println("❌ ISBN cannot be empty.");
		} while (isbn.trim().isEmpty());

		/* do {
            System.out.print("Enter Role: ");
            role = sc.nextLine();
            if (role.trim().isEmpty()) System.out.println("❌ Staff ID cannot be empty.");
        } while (role.trim().isEmpty());*/

		Readers reader = reportService.getReaders(uid);
		Books book = reportService.getBooks(isbn);
		//Staff staff = reportService.getStaff(sid);

		if (reader == null || book == null ) {
			System.out.println("❌ One or more IDs are invalid. Please try again.");
			return;
		}

		String issueDate, returnDate;
		while (true) {
			System.out.print("Enter Issue Date (YYYY-MM-DD): ");
			issueDate = sc.nextLine();
			if (isValidDate(issueDate)) break;
			else System.out.println("❌ Invalid date format. Please use YYYY-MM-DD.");
		}

		while (true) {
			System.out.print("Enter Return Date (YYYY-MM-DD): ");
			returnDate = sc.nextLine();
			if (isValidDate(returnDate)) break;
			else System.out.println("❌ Invalid date format. Please use YYYY-MM-DD.");
		}

		Reports report = new Reports(issueDate, returnDate,  reader, book);
		reportService.addReport(report);

		System.out.println("\n✅ Report Generated Successfully!");
		System.out.println("======= Report Details =======");
		System.out.println("RegNo        : " + report.getRegNo());
		System.out.println("Reader ID    : " + reader.getUser_id());
		System.out.println("Reader Name  : " + reader.getFirstName() + " " + reader.getLastName());
		System.out.println("Book ISBN    : " + book.getISBN());
		System.out.println("Book Title   : " + book.getTitle());
		System.out.println("Role         : " +reader.getRole());
		System.out.println("Issue Date   : " + issueDate);
		System.out.println("Return Date  : " + returnDate);
	}

	private static boolean isValidDate(String dateStr) {
		try {
			LocalDate.parse(dateStr); // Uses ISO_LOCAL_DATE (yyyy-MM-dd) format
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}

