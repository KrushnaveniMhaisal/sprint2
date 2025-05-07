package serviceImpl;

import java.util.List;

import DaoImpl.ReaderDaoImpl;
import Entity.Readers;
import Entity.Reports;
import service.Readerservice;

public class ReaderserviceImpl implements Readerservice {
ReaderDaoImpl readersDao =new ReaderDaoImpl();
	
	@Override
	public Readers addReader(Readers readers) {
		//invoke daoimple method to save readers object
		
		return readersDao.addReader(readers);
	
	}

	@Override
	public List<Readers> getAllReaders() {
		// TODO Auto-generated method stub
		return readersDao.getAllReaders();
	}

	
	@Override
	public Readers getReader(String userID) {
		return readersDao.getReader(userID);
	}


	@Override
	public Readers updateReader(String userID, Readers updatedReaders) {
		
		return readersDao.updateReader(userID, updatedReaders);
	}

	@Override
	public String deleteReader(String userID) {
		return readersDao.deleteReader(userID);
	}
	
	@Override
	    public Readers getReaderDetails(String userId) {
	        return readersDao.getReader(userId);
	    }

	   

}
