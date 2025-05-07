package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity // Marks this class as a persistent entity to be mapped to a database table
public class Staff {

    @Id // Primary key for the Staff entity
    private String staff_id; // Unique identifier for the staff member

    private String name;      // Staff member's name
    private String address;   // Address of the staff member
    private String phoneno;   // Phone number
    private String email;     // Email address
    private String department; // Department to which the staff belongs

    

    // Getters and setters
    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDept() {
        return department;
    }

    public void setDept(String department) {
        this.department = department;
    }

   
    // Default constructor required by JPA
    public Staff() {
        super();
    }

    // Constructor for creating a staff object with full details
    public Staff(String staff_id, String name, String address, String phoneno, String email, String department) {
        super();
        this.staff_id = staff_id;
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
        this.email = email;
        this.department = department;
    }

    // toString method for easy logging and debugging
    @Override
    public String toString() {
        return "Staff [staff_id=" + staff_id + ", name=" + name + ", address=" + address +
               ", phoneno=" + phoneno + ", email=" + email + ", department=" + department + "]";
    }
}
