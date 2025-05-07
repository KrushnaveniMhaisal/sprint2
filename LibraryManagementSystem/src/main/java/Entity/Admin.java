package Entity;

import java.io.IOException;
import java.util.Scanner;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import antlr.collections.List;

@Entity
public class Admin {
	 @Id
	 private int id;
	// @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	// private List staffList;
	/* private String loginId="Admin";
	 private String password="admin@123";
	 
	 
	 
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter Login ID: ");
	        String inputLogin = scanner.nextLine();
	        System.out.print("Enter Password: ");
	        String inputPassword = scanner.nextLine();

	        Admin admin = new Admin();

	        if (inputLogin.equals(admin.loginId) && inputPassword.equals(admin.password)) {
	            System.out.println("Login Successful! Proceeding to further details...");
	            // Continue with application logic here
	        } else {
	            System.out.println("Invalid Credentials! Access Denied.");
	        }
	        scanner.close();
	    }*/
	
	
	
}


