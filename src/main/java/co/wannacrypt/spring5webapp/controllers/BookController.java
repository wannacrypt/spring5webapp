package co.wannacrypt.spring5webapp.controllers;

import co.wannacrypt.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Very simple Spring MVC controller
@Controller
public class BookController {

    private BookRepository bookRepository;

    // Spring auto wire the bookRepository for us.
    // Automatically will get the instance.
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Whenever request invoked with /books
    // this method will be executed
    @RequestMapping("/books")
    public String getBooks(Model model) {
        // Take all the books from database and associate it with model
        // findAll() will return list of books, and it will passed to
        // model
        model.addAttribute("books", bookRepository.findAll());

        // Associate this model with view
        // When create Thymeleaf, it will
        // look things up
        return "books";
    }
}
