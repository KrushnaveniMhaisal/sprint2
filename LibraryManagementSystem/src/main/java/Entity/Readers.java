package Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // Marks this class as a JPA entity
public class Readers {

	@Id // Primary key for the Readers table
	private String user_id;

	// Reader's personal information
	private String firstName;
	private String lastName;
	private String address;
	private String phoneno;
	private String email;
	private String role; // Role could be "student", "staff", etc.
    private String course;
	// One reader can have multiple reports (borrowed books, transactions, etc.)
	@OneToMany(mappedBy = "reader", fetch = FetchType.EAGER)
	private List<Reports> reports;


	// Getter and Setter methods
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Reports> getReports() {
		return reports;
	}

	public void setReports(List<Reports> reports) {
		this.reports = reports;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course=course;
	}

	// Default constructor
	public Readers() {
		super();
	}

	// Parameterized constructor to easily create a Readers object
	public Readers(String user_id, String firstName, String lastName, String address, String phoneno, String email, String role,String course) {
		super();
		this.user_id = user_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneno = phoneno;
		this.email = email;
		this.role = role;
		this.course=course;
	}
	
	
	// toString method for displaying reader details
	@Override
	public String toString() {
		return "Readers [user_id=" + user_id + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", phoneno=" + phoneno + ", email=" + email + ", role=" + role + ",course="+course+"]";
	}

	
	
}
