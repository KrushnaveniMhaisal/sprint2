package DaoImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Dao.PublisherDao;
import Entity.Publisher;
import Util.HibernateUtil;

public class PublisherDaoImpl implements PublisherDao {

    Scanner sc = new Scanner(System.in);

    //  Adds a new Publisher to the database
    @Override
    public Publisher addPublisher(Publisher publisher) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();       // Start a transaction
            session.save(publisher);          // Save the publisher entity
            session.getTransaction().commit(); // Commit the transaction
            return publisher;
        } catch (HibernateException e) {
            System.out.println("HibernateException: " + e);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return null;
    }

    // Retrieves a list of all Publishers from the database
    @Override
    public List<Publisher> getAllPublishers() {
        try (Session session = HibernateUtil.getSession()) {
            // HQL query to get all Publisher entities
            Query<Publisher> query = session.createQuery("FROM Publisher");
            List<Publisher> publisherList = query.list();
            return publisherList;
        } catch (HibernateException e) {
            System.out.println("HibernateException: " + e);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return null;
    }

    // Retrieves a specific Publisher by its ID
    @Override
    public Publisher getPublisher(String publisher_id) {
        try (Session session = HibernateUtil.getSession()) {
            Publisher publisher = session.get(Publisher.class, publisher_id); // Load by primary key
            return publisher;
        } catch (HibernateException e) {
            System.out.println("HibernateException: " + e);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return null;
    }

    // Updates a Publisher’s details using its ID
    @Override
    public Publisher updatePublisher(String publisher_id, Publisher updatedPublisher) {
        try (Session session = HibernateUtil.getSession()) {
            Publisher publisher = session.get(Publisher.class, publisher_id); // Retrieve current data
            session.beginTransaction();

            // Set updated fields
            publisher.setPublisher_id(publisher_id);
            publisher.setPublisher_name(updatedPublisher.getPublisher_name());
            publisher.setYearofpublication(updatedPublisher.getYearofpublication());

            session.saveOrUpdate(publisher);       // Save changes
            session.getTransaction().commit();     // Commit transaction
            return publisher;
        } catch (HibernateException e) {
            System.out.println("HibernateException: " + e);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return null;
    }

    // Deletes a Publisher from the database after confirmation
    @Override
    public String deletePublisher(String publisher_id) {
        String message = null;
        try (Session session = HibernateUtil.getSession()) {
            Publisher publisher = session.get(Publisher.class, publisher_id); // Fetch publisher
            session.beginTransaction();

            System.out.println("Are you sure you want to delete? (yes/no)");
            String status = sc.next();

            if (status.equalsIgnoreCase("yes")) {
                session.delete(publisher);             // Delete from DB
                session.getTransaction().commit();     // Commit transaction
                session.evict(publisher);              // Remove from cache
                message = "Publishers data is deleted";
            } else {
                message = "User wants to retain this object!!";
            }

        } catch (HibernateException e) {
            System.out.println("HibernateException: " + e);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return message;
    }
}
