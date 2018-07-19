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
	@GetMapping(path="/symptom/find")
	public @ResponseBody Book findSymptom(@RequestParam String name) {

		Iterable<Book> books = bookRepository.findAll();
		for (Book s: books) { // make sure symptom is a valid symptom
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return new Book();
	}

	/**
	 * Gets a list of all the symptoms in the database
	 *
	 * @return the list of symptoms
	 */
	@GetMapping(path="/symptom/all")
	public @ResponseBody Iterable<Book> getAllSymptoms() {
		// This returns a JSON or XML with the symptoms
		return bookRepository.findAll();
	}

	/**
	 * Adds a symptom to the database
	 *
	 * @param name the name of the symptom
	 */
	@GetMapping(path="/symptom/add") // Map ONLY GET Requests
	public @ResponseBody String addNewSymptom (@RequestParam String name) {
		Book newSymptom = new Book(name);
		bookRepository.save(newSymptom);
		return "New symptom has been added";
	}
}
