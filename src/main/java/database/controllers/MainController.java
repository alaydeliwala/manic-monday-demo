package database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import database.BookRepository;
import database.data.Book;

@Controller    // This means that this class is a Controller
@RequestMapping(path="") // This means URL's start with /patient (after Application path)
public class MainController {

	@Autowired
	private BookRepository bookRepository;

	/**
	 * A method to find a symptom based on its name
	 *
	 * @param name the name of the symptom
	 * @return JSON of specfied symptom
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
	 * Gets a list of all the symptoms in the database
	 *
	 * @return the list of symptoms
	 */
	@GetMapping(path="/allBooks")
	public @ResponseBody Iterable<Book> getAllBooks() { 
		return bookRepository.findAll();
	}

	/**
	 * Adds a symptom to the database
	 *
	 * @param name the name of the symptom
	 */
	@GetMapping(path="/addBook")
	public @ResponseBody String addNewBook (@RequestParam String name) {
		Book newBook = new Book(name);
		bookRepository.save(newBook);
		return "New book has been added";
	}
}
