package database;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import database.Book;


@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Integer> {
}
