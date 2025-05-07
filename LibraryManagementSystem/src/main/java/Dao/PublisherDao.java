package Dao;

import java.util.List;

import Entity.Publisher;

public interface PublisherDao {
	Publisher addPublisher(Publisher publisher);	
	List<Publisher> getAllPublishers();
	
	Publisher getPublisher(String publisher_id);
	
	Publisher updatePublisher(String publisher_id,Publisher updatedPublisher);
	String deletePublisher(String publisher_id);

}
