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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="author")
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

	// @JsonIgnore
    public void addBook(Book book){
        books.add(book);
        book.setAuthor(this);
	}

	public void addBooks(List<Book> book){
		for(int i = 0; i < books.size(); i++){
			books.add(books.get(i));
        	books.get(i).setAuthor(this);
		}
        
	}

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	@JsonIgnore
	public List<Book> getBooks(){
		return books;
	}
}