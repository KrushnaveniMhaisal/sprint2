package service;

import java.util.List;

import Entity.Readers;
import Entity.Reports;

public interface Readerservice {
	Readers addReader(Readers readers);	
	List<Readers> getAllReaders();
	//Enrollment StudentEnrollment(Enrollment enrollment);
	Readers getReader(String userID);
	//List<Enrollment> getEnrollmentDetailsByCourseId(String courseId);
	Readers updateReader(String userID,Readers updatedReader);
	String deleteReader(String userID);
	
	Readers getReaderDetails(String userId);
    
}
