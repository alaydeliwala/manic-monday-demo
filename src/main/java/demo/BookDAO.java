package demo;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import demo.Book;

// This will be AUTO IMPLEMENTED by Spring into a Bean called bookRepository
// CRUD refers Create, Read, Update, Delete

@Repository
@Transactional
public interface BookDAO extends CrudRepository<Book, Integer> {

}


