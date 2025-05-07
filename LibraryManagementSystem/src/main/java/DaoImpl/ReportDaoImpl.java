package DaoImpl;

import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import Entity.Books;
import Entity.Readers;
import Entity.Reports;
import Entity.Staff;
import Dao.ReportsDao;
import Util.HibernateUtil;
import antlr.collections.List;

public class ReportDaoImpl implements ReportsDao {
    
    Scanner sc = new Scanner(System.in);

    // Adds a new report record into the database
    @Override
    public void addReport(Reports report) {
        org.hibernate.Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();      // Begin transaction
            session.save(report);                 // Save the report object to the database
            tx.commit();                          // Commit transaction
           // System.out.println("✅ Report saved successfully with RegNo: " + report.getRegNo());
        } catch (Exception e) {
            if (tx != null) tx.rollback();        // Rollback in case of error
            e.printStackTrace();
        }
    }

    // ✅ Retrieves a Readers object by user_id
    @Override
    public Readers getReaders(String user_id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Readers.class, user_id); // Load by primary key
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ✅ Retrieves a Books object by ISBN
    @Override
    public Books getBooks(String isbn) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Books.class, isbn); // Load by primary key
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ✅ Retrieves a Staff object by staff_id
  /*  @Override
    public Staff getStaff(String staff_id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Staff.class, staff_id); // Load by primary key
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/

    // ✅ Builds a Reports object using the provided user_id, isbn, and staff_id
   
    @Override
    public Reports generateReport(String user_id, String isbn) {
        Readers reader = getReaders(user_id); // Fetch Reader entity
        Books book = getBooks(isbn);          // Fetch Book entity
        //Staff staff = getStaff(staff_id);     // Fetch Staff entity

        // If all entities are found, build and return the report
        if (reader != null && book != null) {
            Reports report = new Reports();
            report.setReader(reader);
            report.setBook(book);
          
            // Optional: set issueDate, returnDate if needed
            return report;
        }

        // Log if any entity is not found
        System.out.println("❌ Failed to generate report. One or more IDs not found.");
        return null;
    }
   

}
