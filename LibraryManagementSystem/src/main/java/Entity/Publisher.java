package Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // Marks this class as a JPA Entity
public class Publisher {

	@Id // Primary key of the Publisher entity
	private String publisher_id;

	private String publisher_name;
	private long yearofpublication; // Year when the publisher started or published the book

	// One publisher can be associated with multiple books
	@OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
	private List<Books> books;

	// Getter and Setter methods
	public String getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(String publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getPublisher_name() {
		return publisher_name;
	}

	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}

	public long getYearofpublication() {
		return yearofpublication;
	}

	public void setYearofpublication(long yearofpublication) {
		this.yearofpublication = yearofpublication;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	// Default constructor
	public Publisher() {
		super();
	}

	// Parameterized constructor
	public Publisher(String publisher_id, String publisher_name, long yearofpublication) {
		super();
		this.publisher_id = publisher_id;
		this.publisher_name = publisher_name;
		this.yearofpublication = yearofpublication;
	}

	// toString method for displaying publisher info
	@Override
	public String toString() {
		return "Publisher [publisher_id=" + publisher_id + ", publisher_name=" + publisher_name + ", yearofpublication="
				+ yearofpublication + "]";
	}
}
