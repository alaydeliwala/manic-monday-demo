package database.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {

	@Id
  @GeneratedValue
  private Integer id;

	@Column(nullable = false)
	private String name; // name of symptom

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
}