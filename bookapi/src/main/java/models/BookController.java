package models;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    final private MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    //metoda sprawdzająca
    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    public List<Book> getAllBooks() {
        return mockBookService.getList();
    }

    @GetMapping("/{id}")
    public Book findBook(@PathVariable Long id) {
        return this.mockBookService.findBooksById(id).get();
    }

    @PostMapping("")
    public void addingBook(@RequestBody Book book) {
        mockBookService.addBook(book);
    }
    @PutMapping("")
    public void updateBook(@RequestBody Book book){
        mockBookService.updateBook(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        mockBookService.removeBook(id);
    }
}
