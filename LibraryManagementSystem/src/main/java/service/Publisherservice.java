package service;

import java.util.List;

import Entity.Publisher;

public interface Publisherservice {
	Publisher addPublisher(Publisher publisher);	
	List<Publisher> getAllPublishers();
	//Enrollment StudentEnrollment(Enrollment enrollment);
	Publisher getPublisher(String publisher_id);
	//List<Enrollment> getEnrollmentDetailsByCourseId(String courseId);
	Publisher updatePublisher(String publisher_id,Publisher updatedPublisher);
	String deletePublisher(String publisher_id);

}
