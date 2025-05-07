package Dao;

import java.util.List;

import Entity.Readers;
import Entity.Reports;


public interface ReadersDao {
	Readers addReader(Readers readers);	
	List<Readers> getAllReaders();
	//Enrollment StudentEnrollment(Enrollment enrollment);
	Readers getReader(String userID);
	//List<Enrollment> getEnrollmentDetailsByCourseId(String courseId);
	Readers updateReader(String userId,Readers updatedReader);
	String deleteReader(String userID);
	
	
    /*List<Reports> getReportsByReader(String userId);*/


}
