package Operations;

import java.util.List;
import java.util.Scanner;

import com.demo.LMS.App;

import Entity.Readers;
import Entity.Reports;
import Dao.ReadersDao;
import Dao.ReportsDao;
import DaoImpl.ReaderDaoImpl;
import DaoImpl.ReportDaoImpl;
import Exception.ResourceNotFoundException;
import service.Readerservice;
import serviceImpl.ReaderserviceImpl;


public class ReadersOperations {

	static ReaderserviceImpl readerService=new ReaderserviceImpl();
	static Scanner sc=new Scanner(System.in);

	public static Readers ReadersInputs() {
		sc.nextLine();

		String userId;
		do {
			System.out.print("Enter userID: ");
			userId = sc.nextLine();
			if (userId.trim().isEmpty()) System.out.println("User ID cannot be empty.");
		} while (userId.trim().isEmpty());

		String firstName;
		do {
			System.out.print("Enter First Name: ");
			firstName = sc.nextLine();
			if (firstName.trim().isEmpty()) System.out.println("First Name cannot be empty.");
		} while (firstName.trim().isEmpty());

		String lastName;
		do {
			System.out.print("Enter Last Name: ");
			lastName = sc.nextLine();
			if (lastName.trim().isEmpty()) System.out.println("Last Name cannot be empty.");
		} while (lastName.trim().isEmpty());

		String address;
		do {
			System.out.print("Enter Address: ");
			address = sc.nextLine();
			if (address.trim().isEmpty()) System.out.println("Address cannot be empty.");
		} while (address.trim().isEmpty());

		String phoneno;
		do {
			System.out.print("Enter Phone number: ");
			phoneno = sc.nextLine();
			if (!phoneno.matches("\\d{10}")) System.out.println("Phone number must be 10 digits.");
		} while (!phoneno.matches("\\d{10}"));

		String email;
		do {
			System.out.print("Enter Email: ");
			email = sc.nextLine();
			if (!email.matches("^\\S+@\\S+\\.\\S+$")) System.out.println("Invalid email format.");
		} while (!email.matches("^\\S+@\\S+\\.\\S+$"));

		String role;
		do {
			System.out.print("Enter Your Role(Student/Staff): ");
			role = sc.nextLine();
			if (!(role.equalsIgnoreCase("Student") || role.equalsIgnoreCase("Staff"))) {
				System.out.println("Role must be 'Student' or 'Staff'.");
			}
		} while (!(role.equalsIgnoreCase("Student") || role.equalsIgnoreCase("Staff")));
		String course = null; // Initialize as null
		if (role.equalsIgnoreCase("Student")) {
			do {
				System.out.print("Enter Course: ");
				course = sc.nextLine();
				if (course.trim().isEmpty()) {
					System.out.println("Course cannot be empty for Student.");
				}
			} while (course.trim().isEmpty());
		}
		return new Readers(userId, firstName, lastName, address, phoneno, email, role,course);
	}


	public static Void readersOperations()
	{
		while(true) {
			System.out.println();
			System.out.println("======Readers Details=====");
			System.out.println("Press 1.Add Readers\nPress 2.View Readers\n"
					+ "Press 3.Update Readers\nPress 4.Delete Readers \n"
					+ "Press 5.To getback to the main menu");
			int input=sc.nextInt();	

			switch(input) {
			case 1:
				Readers readers=ReadersInputs();
				Readers savedEntity=readerService.addReader(readers);
				System.out.println();
				System.out.println("Readers Data has been saved successfully\n"+ savedEntity);
				break;

			case 2:
				List<Readers> students=readerService.getAllReaders();
				System.out.println();

				for(Readers read:students)
				{

					System.out.println(read);
				}
				break;

			case 3:sc.nextLine();
			System.out.println("Enter user Id to update the Readers Data");
			String rId=sc.next();
			Readers r=readerService.getReader(rId);
			if(r!=null) {
				Readers rd=updatedReadersData(rId);
				//service
				Readers updatedInfo=readerService.updateReader(rId, rd);
				System.out.println();
				System.out.println("Student Data has been updated Successfully\n"+ updatedInfo);
			}

			else
			{
				throw new ResourceNotFoundException("user Id not found");
			}

			break;

			case 4:
				System.out.println("Enter user Id to delete the Readers data");
				String id=sc.next();
				String message=readerService.deleteReader(id);
				System.out.println(message);
				break;
			case 5:App.mainOps();
			}
		}

	}

	public static Readers updatedReadersData(String userId)
	{
		sc.nextLine();

		String firstName;
		do {
			System.out.print("Enter First Name: ");
			firstName = sc.nextLine();
			if (firstName.trim().isEmpty()) System.out.println("First Name cannot be empty.");
		} while (firstName.trim().isEmpty());

		String lastName;
		do {
			System.out.print("Enter Last Name: ");
			lastName = sc.nextLine();
			if (lastName.trim().isEmpty()) System.out.println("Last Name cannot be empty.");
		} while (lastName.trim().isEmpty());

		String address;
		do {
			System.out.print("Enter Address: ");
			address = sc.nextLine();
			if (address.trim().isEmpty()) System.out.println("Address cannot be empty.");
		} while (address.trim().isEmpty());

		String phoneno;
		do {
			System.out.print("Enter Phone number: ");
			phoneno = sc.nextLine();
			if (!phoneno.matches("\\d{10}")) System.out.println("Phone number must be 10 digits.");
		} while (!phoneno.matches("\\d{10}"));

		String email;
		do {
			System.out.print("Enter Email: ");
			email = sc.nextLine();
			if (!email.matches("^\\S+@\\S+\\.\\S+$")) System.out.println("Invalid email format.");
		} while (!email.matches("^\\S+@\\S+\\.\\S+$"));

		String role;
		do {
			System.out.print("Enter Your Role(Student/Staff): ");
			role = sc.nextLine();
			if (!(role.equalsIgnoreCase("Student") || role.equalsIgnoreCase("Staff"))) {
				System.out.println("Role must be 'Student' or 'Staff'.");
			}
		} while (!(role.equalsIgnoreCase("Student") || role.equalsIgnoreCase("Staff")));
		String course = null; // Initialize as null
		if (role.equalsIgnoreCase("Student")) {
			do {
				System.out.print("Enter Course: ");
				course = sc.nextLine();
				if (course.trim().isEmpty()) {
					System.out.println("Course cannot be empty for Student.");
				}
			} while (course.trim().isEmpty());
		}    

		return new Readers(userId, firstName, lastName, address, phoneno, email, role,course);
	}
}