package serviceImpl;

import java.util.List;

import Dao.ReportsDao;
import DaoImpl.ReportDaoImpl;
import Entity.Books;
import Entity.Readers;
import Entity.Reports;
import Entity.Staff;
import service.Reportservice;


public class ReportserviceImpl implements Reportservice {
    private ReportsDao reportsDao = new ReportDaoImpl();
/*
    @Override
    public Readers getReaders(String user_id) {
        return reportsDao.getReaders(user_id);
    }

    @Override
    public Books getBooks(String isbn) {
        return reportsDao.getBooks(isbn);
    }
    @Override
    public Staff getStaff(String staff_id) {
        return reportsDao.getStaff(staff_id);
    }
    
    @Override
    public void addReport(Reports report) {
        reportDao.addReport(report); // Calls the DAO save method
    }
}

	

public class ReportserviceImpl implements Reportservice {

    private ReportsDao reportDao = new ReportDaoImpl();

    @Override
    public void addReport(Reports report) {
        reportDao.addReport(report);
    }

    @Override
    public List<Reports> generateReport() {
        return reportDao.getAllReports();
    }
}*/
    
    @Override
    public Readers getReaders(String user_id) {
        return reportsDao.getReaders(user_id);
    }

    @Override
    public Books getBooks(String isbn) {
        return reportsDao.getBooks(isbn);
    }

   
    @Override
    public void addReport(Reports report) {
        reportsDao.addReport(report);
    }

    
    @Override
    public Reports generateReport(String user_id, String isbn) {
        return reportsDao.generateReport(user_id, isbn);
    }
    
    
   }

	

   

