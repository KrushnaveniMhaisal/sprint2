package com.demo.LMS;


import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Entity.Readers;
import Operations.BooksOperations;
import Operations.PublisherOperations;
import Operations.ReadersOperations;
import Operations.ReportOperations;
import Operations.StaffOperations;


public class App 
{
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		/*System.out.println("======Library Management System=====");   	 


	    System.out.print("Enter Login ID: ");
	    String loginId = sc.nextLine();

	    System.out.print("Enter Password: ");
	    String password = sc.nextLine();


	        if (loginId.equals("Admin") && password.equals("*****")) {
	            System.out.println("Admin Login Successful!\n");
	            App.mainOps();
	        } else {
	            System.out.println("Invalid Admin Credentials!");
	        }


	    sc.close();
	}*/
		JFrame frame = new JFrame("Library Management - Admin Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null); // Center on screen

		// Create main panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);

		// Title
		JLabel titleLabel = new JLabel("Admin Login");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		titleLabel.setBounds(130, 10, 200, 30);
		panel.add(titleLabel);

		// Login ID Label and Field
		JLabel userLabel = new JLabel("Login ID:");
		userLabel.setBounds(50, 60, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField();
		userText.setBounds(140, 60, 200, 25);
		panel.add(userText);

		// Password Label and Field
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(50, 100, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(140, 100, 200, 25);
		panel.add(passwordField);

		// Login Button
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(140, 140, 100, 30);
		panel.add(loginButton);

		// Button Action
		loginButton.addActionListener(e -> {
			String loginId = userText.getText();
			String password = new String(passwordField.getPassword());

			if ("Admin".equals(loginId) && "admin@123".equals(password)) {
				JOptionPane.showMessageDialog(frame, "Admin Login Successful!");
				frame.dispose(); // Close login window
				App.mainOps();   // Call your main app method
			} else {
				JOptionPane.showMessageDialog(frame, "Invalid Admin Credentials", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});

		// Show frame
		frame.setVisible(true);
	}



	//Main operations menu after successful Admin login.    
	public static void mainOps()
	{
		while(true) {
			System.out.println("===========Library Management System==========");
			System.out.println("Press 1.Readers Details\nPress 2.Books Deatils"
					+ "\nPress 3.Staff Details\n"
					+ "Press 4.Report Details\n"+ "Press 5 for quit");
			System.out.print("Enter your choice:");
			int input=sc.nextInt();

			switch(input)
			{
			case 1:
				ReadersOperations.readersOperations();
				System.out.println("=======================================");
				break;

			case 2:
				BooksOperations.booksOperations();
				System.out.println("=======================================");
				break;

				/*case 3:
    				PublisherOperations.publisherOperations();
    				System.out.println("=======================================");
    				break;*/

			case 3:
				StaffOperations.staffOperations();
				System.out.println("=======================================");
				break;
			case 4:
				ReportOperations.reportOperations();
				System.out.println("=======================================");
				break;

			case 5:
				System.out.println("Loging out from Admin");
				return;

			default:
				System.out.println("wrong input");
			}
		}


	}

}
