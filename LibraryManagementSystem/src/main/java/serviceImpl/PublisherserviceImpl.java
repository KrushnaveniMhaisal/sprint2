package serviceImpl;

import java.util.List;

import DaoImpl.PublisherDaoImpl;
import Dao.PublisherDao;
import Entity.Publisher;
import service.Publisherservice;




public class PublisherserviceImpl implements Publisherservice{
	PublisherDao publisherDao =new PublisherDaoImpl();

	public Publisher addPublisher(Publisher publisher) {
		//invoke daoimple method to save publisher object
		
		return publisherDao.addPublisher(publisher);
	
	}

	@Override
	public List<Publisher> getAllPublishers() {
		// TODO Auto-generated method stub
		return publisherDao.getAllPublishers();
	}

	@Override
	public Publisher getPublisher(String publisher_id) {
		// TODO Auto-generated method stub
		return publisherDao.getPublisher(publisher_id);
	}


	@Override
	public Publisher updatePublisher(String publisher_id, Publisher updatedPublisher) {
		
		return publisherDao.updatePublisher(publisher_id, updatedPublisher);
	}

	@Override
	public String deletePublisher(String publisher_id) {
		return publisherDao.deletePublisher(publisher_id);
	}



}
