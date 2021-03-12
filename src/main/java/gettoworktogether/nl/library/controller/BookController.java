package gettoworktogether.nl.library.controller;

import gettoworktogether.nl.library.model.Book;

import gettoworktogether.nl.library.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public ResponseEntity<Object> getBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(value = "/books/title/{title}")
    public ResponseEntity<Object> getBooks(@PathVariable("title") String title) {
        List<Book> books = bookService.getBooksTitleStartsWith(title);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable("id") long id) {
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }

    @PostMapping(value = "/books")
    public ResponseEntity<Object> createBook(@RequestBody Book book) {
        bookService.save(book);
        return new ResponseEntity<>("Book created", HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") long id) {
        bookService.deleteById(id);
        return new ResponseEntity<>("Book deleted", HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Object>  updateBook(@RequestBody Book bookUpdate, @PathVariable("id") long id) {
        bookUpdate.setId(id);
        bookService.save(bookUpdate);
        return new ResponseEntity<>("Book updated", HttpStatus.OK);
    }



}
