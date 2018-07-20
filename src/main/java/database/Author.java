package database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Author")
public class Author {

	@Id
    @GeneratedValue
    private Integer id;

	@Column(nullable = false)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, 
	mappedBy = "author", orphanRemoval = true)
	private List<Book> books = new ArrayList<>();

	public Author() { }

	public Author(String name){
		setName(name);
	}

    public Integer getId() {
        return id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
    }

    public void addBook(Book book){
        books.add(book);
        book.setAuthor(this);
	}
}