package service;

import java.util.List;

import Entity.Staff;

public interface Staffservice {
	Staff addStaff(Staff staff);	
	List<Staff> getAllStaffs();
	//Enrollment StudentEnrollment(Enrollment enrollment);
	Staff getStaff(String staff_id);
	//List<Enrollment> getEnrollmentDetailsByCourseId(String courseId);
	Staff updateStaff(String staff_id,Staff updatedStaff);
	String deleteStaff(String Staff_id);


}
