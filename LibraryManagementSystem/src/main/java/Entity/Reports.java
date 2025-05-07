package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity // Marks this class as a persistent entity
public class Reports {

    @Id // Primary key for the Reports table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented by the database
    private int regNo; // Unique registration number for the report

    private String issueDate;   // Date when the book was issued
    private String returnDate;  // Date when the book is to be returned


    // Many reports can be associated with one reader
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id") // Foreign key
    private Readers reader;

    // Many reports can be about one book
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "isbn", referencedColumnName = "ISBN") // Foreign key
    private Books book;

    // Default constructor required by JPA
    public Reports() {
        super();
    }

    // Parameterized constructor for convenience
    public Reports(String issueDate, String returnDate,  Readers reader, Books book) {
        this.issueDate = issueDate;
        this.returnDate = returnDate;
       
        this.reader = reader;
        this.book = book;
    }

    // Getters and setters
    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

   /* public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }*/

    public Readers getReader() {
        return reader;
    }

    public void setReader(Readers reader) {
        this.reader = reader;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    // toString method to represent report details in readable format
    @Override
    public String toString() {
        return "Reports [regNo=" + regNo + ", issueDate=" + issueDate +
               ", returnDate=" + returnDate +  ", reader=" + reader + ", book=" + book + "]";
    }
}
