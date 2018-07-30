package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import database.BookRepository;
import database.Book;

@Controller    // This means that this class is a Controller
@RequestMapping(path="") // This means URL's start with / (after Application path)
public class MainController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	/**
	 * A method to find a book based on its name
	 *
	 * @param name the name of the book
	 * @return JSON of specfied book
	 */
	@GetMapping(path="/findBook")
	public @ResponseBody Book findBook(@RequestParam String name) {
		Iterable<Book> books = bookRepository.findAll();
		for (Book book: books) {
			if (book.getName().equals(name)) {
				return book;
			}
		}
		return new Book();
	}

	/**
	 * Gets a list of all the books in the database
	 *
	 * @return the list of books
	 */
	@GetMapping(path="/allBooks")
	public @ResponseBody Iterable<Book> getAllBooks() { 
		return bookRepository.findAll();
	}

	/**
	 * Gets a list of all the authors in the database
	 *
	 * @return the list of authors
	 */
	@GetMapping(path="/allAuthors")
	public @ResponseBody Iterable<Author> getAllAuthors() { 
		return authorRepository.findAll();
	}

	/**
	 * Adds a symptom to the database
	 *
	 * @param name the name of the book
	 */
	@GetMapping(path="/addBook")
	public @ResponseBody String addNewBook (@RequestParam String name) {
		
		Book newBook = new Book(name);
		bookRepository.save(newBook);
		return "New book has been added";
	}

	/**
	 * Adds a book with an author to the database
	 *
	 * @param name the name of the book
	 * @param author the name of the author
	 */
	@GetMapping(path="/addBookWithAuthor")
	public @ResponseBody String addNewBookWithAuthor (@RequestParam String name, @RequestParam String author) {
		Book newBook = new Book(name);
		Author newAuthor = new Author(author);
		newAuthor.addBook(newBook);
		authorRepository.save(newAuthor);
		return "New book has been added";
	}
}
