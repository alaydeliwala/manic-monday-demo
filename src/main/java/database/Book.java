package database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="book")
public class Book {

	@Id
  @GeneratedValue
  private Integer id;

	@Column(nullable = false)
	private String name;

	@ManyToOne
	private Author author;

	public Book() { }

	public Book(String name){
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

	public void setAuthor(Author author){
		this.author = author;
	}

	@ManyToOne
	@JoinColumn(name = "author_id")
	public Author getAuthor(){
		return author;
	}
}
