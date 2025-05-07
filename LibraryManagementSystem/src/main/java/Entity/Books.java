package Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity  // Marks this class as a JPA entity
public class Books { 

	@Id // Marks ISBN as the primary key
	private String ISBN;

	// Book details
	private String Title;
	private String Edition;
	private String category;
	private int price;
	private String issueDate;   // Can be stored as Date instead of String for better practice


	// Many books can belong to one publisher
	@ManyToOne
	@JoinColumn(name = "publisher_id") // Foreign key column in Books table
	private Publisher publisher;

	// One book can have multiple reports
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private List<Reports> reports;

	// Getters and setters
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getEdition() {
		return Edition;
	}

	public void setEdition(String edition) {
		Edition = edition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}


	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Reports> getReports() {
		return reports;
	}

	public void setReports(List<Reports> reports) {
		this.reports = reports;
	}

	// Default constructor
	public Books() {
		super();
	}

	// Parameterized constructor for easy object creation
	public Books(String iSBN, String title, String edition, String category, int price, String issueDate, Publisher publisher) {
		super();
		ISBN = iSBN;
		Title = title;
		Edition = edition;
		this.category = category;
		this.price = price;
		this.issueDate = issueDate;
		this.publisher = publisher;
	}

	// toString method for displaying book information
	@Override
	public String toString() {
		return "Books [ISBN=" + ISBN + ", Title=" + Title + ", Edition=" + Edition + ", category=" + category
				+ ", price=" + price + ", issueDate=" + issueDate +  ", publisher="
				+ publisher + "]";
	}
}
