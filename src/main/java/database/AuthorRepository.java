package database;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import database.Author;


@Repository
@Transactional
public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
