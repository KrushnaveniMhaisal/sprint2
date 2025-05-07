package Dao;

import java.util.List;

import Entity.Staff;

public interface StaffDao {
	Staff addStaff(Staff staff);	
	List<Staff> getAllStaffs();
	Staff getStaff(String staff_id);
	Staff updateStaff(String staff_id,Staff updatedStaff);
	String deleteStaff(String Staff_id);


}
