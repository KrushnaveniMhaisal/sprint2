package Operations;

import java.util.List;
import java.util.Scanner;

import com.demo.LMS.App;

import Entity.Staff;
import Exception.ResourceNotFoundException;
import serviceImpl.StaffserviceImpl;

public class StaffOperations {

	static StaffserviceImpl staffService=new StaffserviceImpl();
	static Scanner sc=new Scanner(System.in);
	public static Staff staffInputs() {
		sc.nextLine();

		String pid;
		do {
			System.out.print("Enter Staff Id: ");
			pid = sc.nextLine();
			if (pid.trim().isEmpty()) System.out.println("Staff ID cannot be empty.");
		} while (pid.trim().isEmpty());

		String pname;
		do {
			System.out.print("Enter Staff Name: ");
			pname = sc.nextLine();
			if (pname.trim().isEmpty()) System.out.println("Name cannot be empty.");
		} while (pname.trim().isEmpty());

		String padd;
		do {
			System.out.print("Enter Staff Address: ");
			padd = sc.nextLine();
			if (padd.trim().isEmpty()) System.out.println("Address cannot be empty.");
		} while (padd.trim().isEmpty());

		String phoneno;
		do {
			System.out.print("Enter Staff Phone number: ");
			phoneno = sc.nextLine();
			if (!phoneno.matches("\\d{10}")) System.out.println("Phone number must be 10 digits.");
		} while (!phoneno.matches("\\d{10}"));

		String pemail;
		do {
			System.out.print("Enter Staff email: ");
			pemail = sc.nextLine();
			if (!pemail.matches("^\\S+@\\S+\\.\\S+$")) System.out.println("Invalid email format.");
		} while (!pemail.matches("^\\S+@\\S+\\.\\S+$"));

		String dept;
		do {
			System.out.print("Enter Staff Department: ");
			dept = sc.nextLine();
			if (dept.trim().isEmpty()) System.out.println("Department cannot be empty.");
		} while (dept.trim().isEmpty());

		return new Staff(pid, pname, padd, phoneno, pemail, dept);
	}

	public static Void staffOperations()
	{
		while(true) {
			System.out.println("======Staff Details=====");
			System.out.println("Press 1.Add Staff \nPress 2.View Staff\n"
					+ "Press 3.Update Staff \nPress 4.Delete Staff \n"
					+ "Press 5.To getback to the main menu");
			int input=sc.nextInt();	

			switch(input) {
			case 1:
				Staff staff=staffInputs();
				Staff savedEntity=staffService.addStaff(staff);
				System.out.println("Staffs Data has been saved successfully\n"+ savedEntity);
				break;

			case 2:
				List<Staff> staff1=staffService.getAllStaffs();
				for(Staff publis:staff1)
				{
					System.out.println(publis);
				}
				break;

			case 3:sc.nextLine();
			System.out.println("Enter staff id to update the Staffs Data");
			String bId=sc.next();
			Staff r=staffService.getStaff(bId);
			if(r!=null) {
				Staff rd=updatedStaffData(bId);
				//service
				Staff updatedInfo=staffService.updateStaff(bId, rd);
				System.out.println("Staffs Data has been updated Successfully\n"+ updatedInfo);
			}

			else
			{
				throw new ResourceNotFoundException("user Id not found");
			}

			break;

			case 4:
				System.out.println("Enter staff id to delete the Staffs Data");
				String id=sc.next();
				String message=staffService.deleteStaff(id);
				System.out.println(message);
				break;
			case 5:App.mainOps();
			}
		}

	}

	public static Staff updatedStaffData(String pid)
	{
		sc.nextLine();

		String pname;
		do {
			System.out.print("Enter Staff Name: ");
			pname = sc.nextLine();
			if (pname.trim().isEmpty()) System.out.println("Name cannot be empty.");
		} while (pname.trim().isEmpty());

		String padd;
		do {
			System.out.print("Enter Staff Address: ");
			padd = sc.nextLine();
			if (padd.trim().isEmpty()) System.out.println("Address cannot be empty.");
		} while (padd.trim().isEmpty());

		String phoneno;
		do {
			System.out.print("Enter Staff Phone number: ");
			phoneno = sc.nextLine();
			if (!phoneno.matches("\\d{10}")) System.out.println("Phone number must be 10 digits.");
		} while (!phoneno.matches("\\d{10}"));

		String pemail;
		do {
			System.out.print("Enter Staff email: ");
			pemail = sc.nextLine();
			if (!pemail.matches("^\\S+@\\S+\\.\\S+$")) System.out.println("Invalid email format.");
		} while (!pemail.matches("^\\S+@\\S+\\.\\S+$"));

		String dept;
		do {
			System.out.print("Enter Staff Department: ");
			dept = sc.nextLine();
			if (dept.trim().isEmpty()) System.out.println("Department cannot be empty.");
		} while (dept.trim().isEmpty());

		return new Staff(pid, pname, padd, phoneno, pemail, dept);
	}
	/*
public static void staffMenu() {
    while (true) {
        System.out.println("\n--- Staff Menu ---");
        System.out.println("1. Issue Book to Reader");
        System.out.println("2. Return Book from Reader");
        System.out.println("3. View Reports");
        System.out.println("4. Exit to Main Menu");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Issuing book (dummy logic)");
                break;
            case 2:
                System.out.println("Returning book (dummy logic)");
                break;
            case 3:
                System.out.println("Viewing reports (dummy logic)");
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice");
        }
    }
}*/



}
