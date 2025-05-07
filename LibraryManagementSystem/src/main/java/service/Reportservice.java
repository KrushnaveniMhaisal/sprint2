package service;

import java.util.List;

import Entity.Books;
import Entity.Readers;
import Entity.Reports;
import Entity.Staff;

public interface Reportservice {
	
	    Readers getReaders(String user_id);
	    Books getBooks(String isbn);

	    // Save a new report
	    void addReport(Reports report);

	    // Fetch all reports (optional, for display/reporting)
	   
	    // Create a Reports object using IDs (optional utility)
	    Reports generateReport(String user_id, String isbn);
	    /*List<Reports> getAllReports();*/
	    
	    

	
    

}
