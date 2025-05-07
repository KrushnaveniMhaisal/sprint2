package serviceImpl;

import java.util.List;
import Entity.Staff;
import service.Staffservice;
import Dao.StaffDao;
import DaoImpl.StaffDaoImpl;


public class StaffserviceImpl implements Staffservice{
	StaffDao staffDao =new StaffDaoImpl();

	public Staff addStaff(Staff staff) {
		//invoke daoimple method to save staff object
		
		return staffDao.addStaff(staff);
	
	}

	@Override
	public List<Staff> getAllStaffs() {
		// TODO Auto-generated method stub
		return staffDao.getAllStaffs();
	}


	@Override
	public Staff getStaff(String staff_id) {
		// TODO Auto-generated method stub
		return staffDao.getStaff(staff_id);
	}


	@Override
	public Staff updateStaff(String staff_id, Staff updatedStaff) {
		
		return staffDao.updateStaff(staff_id, updatedStaff);
	}

	@Override
	public String deleteStaff(String staff_id) {
		return staffDao.deleteStaff(staff_id);
	}



}
