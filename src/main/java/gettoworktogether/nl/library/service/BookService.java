package gettoworktogether.nl.library.service;

import gettoworktogether.nl.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    public List<Book> getAllBooks();
    public Book getBook(long id);
    public List<Book> getBooksTitleStartsWith(String title);
    public void save(Book book);
    public void deleteById(long id);

}
