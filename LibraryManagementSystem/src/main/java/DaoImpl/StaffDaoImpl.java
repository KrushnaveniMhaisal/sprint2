package DaoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Dao.StaffDao;
import Entity.Staff;
import Util.HibernateUtil;

public class StaffDaoImpl implements StaffDao {
    
    // Scanner for user input (used for deletion confirmation)
    Scanner sc = new Scanner(System.in);

    // Adds a new staff record into the database
    @Override
    public Staff addStaff(Staff staff) {
        try (Session session = HibernateUtil.getSession()) {

            session.beginTransaction();      // Begin transaction
            session.save(staff);             // Save the staff object to the database
            session.getTransaction().commit(); // Commit the transaction
            return staff;                    // Return the saved staff object

        } catch (HibernateException e) {
            System.out.println(e);          
        } catch (Exception e) {
            System.out.println(e);           
        }
        return null;  
        }

    // Retrieves all staff members from the database
    @Override
    public List<Staff> getAllStaffs() {
        try (Session session = HibernateUtil.getSession()) {

            // Execute HQL query to retrieve all staff records from the database
            Query<Staff> query = session.createQuery("FROM Staff");
            List<Staff> staffList = query.list(); // Execute query and retrieve result
            return staffList; // Return the list of staff members

        } catch (HibernateException e) {
            System.out.println(e);           
        } catch (Exception e) {
            System.out.println(e);           
        }

        return null;                      
    }

    // Retrieves a specific staff member by staff_id
    @Override
    public Staff getStaff(String staff_id) {
        try (Session session = HibernateUtil.getSession()) {

            Staff staff = session.get(Staff.class, staff_id); // Fetch staff by primary key
            return staff; // Return the staff object

        } catch (HibernateException e) {
            System.out.println(e);           
        } catch (Exception e) {
            System.out.println(e);          
        }

        return null;                       
    }

    //Updates an existing staff member's details
    @Override
    public Staff updateStaff(String staff_id, Staff updatedStaff) {
        try (Session session = HibernateUtil.getSession()) {
            Staff staff = session.get(Staff.class, staff_id); // Fetch the staff object to update
            session.beginTransaction();    // Begin transaction

            // Update the staff fields with the new values
            staff.setStaff_id(staff_id);
            staff.setName(updatedStaff.getName());
            staff.setAddress(updatedStaff.getAddress());
            staff.setPhoneno(updatedStaff.getPhoneno());
            staff.setEmail(updatedStaff.getEmail());
            staff.setDept(updatedStaff.getDept());

            session.saveOrUpdate(staff);   // Save or update the staff object in the database
            session.getTransaction().commit(); // Commit the transaction
            return staff; // Return the updated staff object

        } catch (HibernateException e) {
            System.out.println(e);           
        } catch (Exception e) {
            System.out.println(e);           
        }
        return null;                      
    }

    // Deletes a staff member by staff_id, with user confirmation
    @Override
    public String deleteStaff(String staff_id) {
        String message = null;
        try (Session session = HibernateUtil.getSession()) {
            Staff staff = session.get(Staff.class, staff_id); // Fetch the staff object to delete
            session.beginTransaction(); // Begin transaction

            // Ask for confirmation before deleting the staff member
            System.out.println("Are you sure you want to delete?");
            String status = sc.next(); // Read user input

            if (status.equalsIgnoreCase("yes")) {
                session.delete(staff);      // Delete the staff object from the database
                session.getTransaction().commit(); // Commit the transaction
                session.evict(staff);       // Remove staff object from session cache
                message = "Staff data is deleted"; // Set success message

            } else {
                message = "User wants to retain this object!!"; // Set cancellation message
            }

        } catch (HibernateException e) {
            System.out.println(e);           
        } catch (Exception e) {
            System.out.println(e);           
        }
        return message; // Return the deletion message
    }
}
