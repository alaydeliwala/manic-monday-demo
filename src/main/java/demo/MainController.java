package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called bookRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private BookRepository bookRepository;

	@GetMapping(path="/addBook") // Maps a GET request at /demo/addBook
	public @ResponseBody String addBook (@RequestParam String name) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Book newBook = new Book();
		newBook.setName(name);
		bookRepository.save(newBook);
		return "Book Added";
	}

	@GetMapping(path="/removeBook") // Maps a GET request at /demo/removeBook
	public @ResponseBody String removeBook (@RequestParam String name) {
		for(Book item: getAllBooks()){
			if(item.getName().equals(name)){
				bookRepository.deleteById(item.getId());
				return "Book removed";
			}
		}
		return "Book not found";
	}

	@GetMapping(path="/findBook") // Maps a GET request at /demo/findBook
	public @ResponseBody Book findBook (@RequestParam String name) {
		for(Book item: getAllBooks()){
			if(item.getName().equals(name)){
				return item;
			}
		}
		return null; // Book not found
	}

	@GetMapping(path="/allBooks")
	public @ResponseBody Iterable<Book> getAllBooks() {
		// This returns a JSON or XML with the books
		return bookRepository.findAll();
	}
}






