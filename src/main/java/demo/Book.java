package demo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="Book") // This will be the name of the table
public class Book { 
    @Id // Auto generated id number for the book
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

	@Column(nullable = false)
    private String name;

	public Book(){ } // Default Constructor

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}