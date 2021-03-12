package gettoworktogether.nl.library.repository;

import gettoworktogether.nl.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitleStartingWith(String title);

}
