package nl.novi.hello.repository;

import nl.novi.hello.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Iterable<Book> findAllByTitle(String title);
    Iterable<Book> findAllByTitleContainingIgnoreCase(String title);

    //    @Query("SELECT * FROM books b WHERE b.title LIKE %:s%")
    //    Iterable<Book> searchByTitleLike(@Param("s") String s);
}
