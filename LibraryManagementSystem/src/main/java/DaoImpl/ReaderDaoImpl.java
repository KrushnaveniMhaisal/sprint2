package DaoImpl;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Dao.ReadersDao;
import Entity.Books;
import Entity.Readers;
import Entity.Reports;
import Entity.Staff;
import Util.HibernateUtil;

public class ReaderDaoImpl implements ReadersDao {
	Scanner sc=new Scanner(System.in);
	
	// Adds a new reader to the database
	@Override
	public Readers addReader(Readers reader) {
		if (!validateReader(reader)) {
	        System.out.println("Validation failed. Reader not added.");
	        return null;
	    }
		try(Session session=HibernateUtil.getSession()) {

			session.beginTransaction();
			session.save(reader);
			session.getTransaction().commit();
			return reader;

		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// Retrieves all readers from the database
	@Override
	public List<Readers> getAllReaders() {
		try(Session session=HibernateUtil.getSession()) {

			//execute HQL query to retrieve all Readers data
			Query<Readers> query=session.createQuery("FROM Readers");
			List<Readers> readerList=query.list();
			return readerList;

		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	// Retrieves a reader based on their userID
	public Readers getReader(String userID) {

		try(Session session=HibernateUtil.getSession()) {

			Readers reader=session.get(Readers.class, userID);
			return reader;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}
	
	 // Updates an existing reader based on userID
	
	@Override
	public Readers updateReader(String userID,Readers updatedReader) {
		try(Session session=HibernateUtil.getSession()) {
			Readers reader=session.get(Readers.class, userID);
			session.beginTransaction();
  
			 // Update reader details
			reader.setUser_id(userID);
			reader.setFirstName(updatedReader.getFirstName());
			reader.setLastName(updatedReader.getLastName());
			reader.setAddress(updatedReader.getAddress());
			reader.setPhoneno(updatedReader.getPhoneno());
			reader.setEmail(updatedReader.getEmail());
			reader.setRole(updatedReader.getRole());
			

			session.saveOrUpdate(reader);
			session.getTransaction().commit();
			return reader;

		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// Deletes a reader from the database after confirmation
	@Override
	public String deleteReader(String userID) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Readers reader=session.get(Readers.class, userID);
			session.beginTransaction();
			System.out.println("Are you sure  you want to delete?");
			String status=sc.next();
			if(status.equalsIgnoreCase("yes"))
			{
				session.delete(reader);//data will be deleted from DB
				session.getTransaction().commit();
				session.evict(reader);//data will remove from session Cache
				message="Readers data is deleted";

			}else
			{
				message="User wants to retain this object!!";
			}

		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return message;
	}	
	
	private boolean validateReader(Readers reader) {
	    if (reader.getUser_id() == null || reader.getUser_id().trim().isEmpty()) {
	        System.out.println("User ID cannot be empty.");
	        return false;
	    }
	    if (reader.getFirstName() == null || reader.getFirstName().trim().isEmpty()) {
	        System.out.println("First Name cannot be empty.");
	        return false;
	    }
	    if (reader.getPhoneno() == null || !reader.getPhoneno().matches("\\d{10}")) {
	        System.out.println("Phone number must be 10 digits.");
	        return false;
	    }
	    if (reader.getEmail() == null || !reader.getEmail().matches("^\\S+@\\S+\\.\\S+$")) {
	        System.out.println("Invalid email format.");
	        return false;
	    }
	    return true;
	}

	
}
