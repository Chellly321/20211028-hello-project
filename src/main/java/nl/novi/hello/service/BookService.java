package nl.novi.hello.service;

import nl.novi.hello.model.Book;
import nl.novi.hello.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import  java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> getBooks(String title) {
        if (title.isEmpty()){
            return (bookRepository.findAll());
        }
      else{
          return bookRepository.findAllByTitleContainingIgnoreCase(title);
        }
    }

    public Book getBook(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()){
            return optionalBook.get();
        } else {
            // exception
            throw new RecordNotFoundException("ID does not exist!!!");
    }}

    public void deleteBook(int id) {
        BookRepository.deleteById(id);
    }

    public int addBook(Book book) {
        Book newBook = bookRepository.save(book);
        return
    }

    public void updateBook() {}

    public void partialUpdateBook() {}
}
