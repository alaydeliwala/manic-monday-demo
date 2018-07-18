package demo;

import org.springframework.data.repository.CrudRepository;

import demo.Book;

// This will be AUTO IMPLEMENTED by Spring into a Bean called bookRepository
// CRUD refers Create, Read, Update, Delete

public interface BookRepository extends CrudRepository<Book, Long> {

}