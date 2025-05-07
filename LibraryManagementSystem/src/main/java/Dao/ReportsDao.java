package Dao;


import Entity.Books;
import Entity.Readers;
import Entity.Reports;
import Entity.Staff;

import java.util.List;

public interface ReportsDao {
	
	 void addReport(Reports report);

	    // Generate a report from entity IDs (helper, optional)
	    Reports generateReport(String user_id, String isbn);

	    // Get individual entities by their IDs
	    Readers getReaders(String user_id);
	    
	    Books getBooks(String isbn);
	    
	

    
}
