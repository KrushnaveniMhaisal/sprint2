package Operations;

import java.util.List;
import java.util.Scanner;

import com.demo.LMS.App;

import Entity.Publisher;
import service.Publisherservice;
import Exception.ResourceNotFoundException;
import serviceImpl.PublisherserviceImpl;

public class PublisherOperations {

	static PublisherserviceImpl publisherService=new PublisherserviceImpl();
	static Scanner sc=new Scanner(System.in);
	public static Publisher publisherInputs() {
		sc.nextLine();
		String pid;
		do {
			System.out.print("Enter Publisher Id: ");
			pid = sc.nextLine();
			if (pid.trim().isEmpty()) System.out.println("Publisher ID cannot be empty.");
		} while (pid.trim().isEmpty());

		String pname;
		do {
			System.out.print("Enter Publisher Name: ");
			pname = sc.nextLine();
			if (pname.trim().isEmpty()) System.out.println("Publisher name cannot be empty.");
		} while (pname.trim().isEmpty());

		long yop;
		do {
			System.out.print("Enter Year of Publication: ");
			while (!sc.hasNextLong()) {
				System.out.println("Year must be a number.");
				sc.next(); // discard invalid input
			}
			yop = sc.nextLong();
			if (yop <= 0) System.out.println("Year must be a positive number.");
		} while (yop <= 0);

		return new Publisher(pid, pname, yop);
	}


	public static Void publisherOperations()
	{
		while(true) {
			System.out.println("=====Publihshers Details=====");
			System.out.println("Press 1.Add Publisher\nPress 2.View Publisher\n"
					+ "Press 3.Update Publisher \nPress 4.Delete Publisher \n"
					+ "Press 5.To getback to the main menu");
			int input=sc.nextInt();	

			switch(input) {
			case 1:
				Publisher publisher=publisherInputs();
				Publisher savedEntity=publisherService.addPublisher(publisher);
				System.out.println("Publishers Data has been saved successfully\n"+ savedEntity);
				break;

			case 2:
				List<Publisher> publisher1=publisherService.getAllPublishers();
				for(Publisher publis:publisher1)
				{
					System.out.println(publis);
				}
				break;

			case 3:sc.nextLine();
			System.out.println("Enter publisher id to update the publishers data");
			String bId=sc.next();
			Publisher r=publisherService.getPublisher(bId);
			if(r!=null) {
				Publisher rd=updatedPublishersData(bId);
				//service
				Publisher updatedInfo=publisherService.updatePublisher(bId, rd);
				System.out.println("Publishers Data has been updated Successfully\n"+ updatedInfo);
			}

			else
			{
				throw new ResourceNotFoundException("user Id not found");
			}

			break;

			case 4:
				System.out.println("Enter publisher id to delete the publishers data");
				String id=sc.next();
				String message=publisherService.deletePublisher(id);
				System.out.println(message);
				break;
			case 5:App.mainOps();
			}
		}

	}

	public static Publisher updatedPublishersData(String pid)
	{
		sc.nextLine();


		String pname;
		do {
			System.out.print("Enter Publisher Name: ");
			pname = sc.nextLine();
			if (pname.trim().isEmpty()) System.out.println("Publisher name cannot be empty.");
		} while (pname.trim().isEmpty());

		long yop;
		do {
			System.out.print("Enter Year of Publication: ");
			while (!sc.hasNextLong()) {
				System.out.println("Year must be a number.");
				sc.next(); // discard invalid input
			}
			yop = sc.nextLong();
			if (yop <= 0) System.out.println("Year must be a positive number.");
		} while (yop <= 0);

		return new Publisher(pid, pname, yop);
	}




}
