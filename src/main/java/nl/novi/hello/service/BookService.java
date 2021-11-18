package nl.novi.hello.service;

import antlr.RecognitionException;
import nl.novi.hello.exceptions.RecordNotFoundException;
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
            throw new RecordNotFoundException("ID does not excist!!");
    }}

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public int addBook(Book book) {
        Book newBook = bookRepository.save(book);
        return newBook.getId();
    }

    public void updateBook(int id, Book book) {
        Book excistingBook = bookRepository.findById(id).orElse(null);

        if (!book.getTitle().isEmpty()){
            excistingBook.setTitle(book.getTitle());
        }
        if (!book.getAuthor().isEmpty()){
            excistingBook.setAuthor((book.getAuthor()));
        }
        if (!book.getIsbn().isEmpty()){
            excistingBook.setIsbn(book.getIsbn());
        }
        bookRepository.save(excistingBook);
    }

    public void partialUpdateBook(int id, Book book) {
        Book existingBook = bookRepository.findById(id).orElse(null);

        if (!book.getTitle().isEmpty()) {
            existingBook.setTitle(book.getTitle());
        }
        if (!book.getAuthor().isEmpty()){
            existingBook.setAuthor(book.getAuthor());
        }
        if (!book.getIsbn().isEmpty()){
            existingBook.setIsbn(book.getIsbn());
        }
        bookRepository.save(existingBook);
    }
}
