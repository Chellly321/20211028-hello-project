package nl.novi.hello.controller;

import nl.novi.hello.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


import nl.novi.hello.model.Book;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    //attribute
    public List<Book> books = new ArrayList<>();

    //getters and setters
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    //constructor
    public BookController(){
        Book boek1 = new Book();
        boek1.setTitle("Harry Potter");
        boek1.setAuthor("Rowling");
        boek1.setIsbn("23435345433487468726");
        books.add(boek1);

        Book boek2 = new Book();
        boek2.setTitle("Harry Potter, deel 2");
        boek2.setAuthor("Rownling");
        boek2.setIsbn("237463876478642873");
        books.add(boek2);
    }

    @Autowired
    private BookRepository bookRepository;


 @GetMapping(value = "/books")
    public ResponseEntity<Object> getBooks(){
        return ResponseEntity.ok(bookRepository.findAll());  //Jackson object => json
 }

 @GetMapping(value = "/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable int id){
        return ResponseEntity.ok(bookRepository.findById(id));
 }

 @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Object> deleteBooks(@PathVariable int id){
        return ResponseEntity.ok(bookRepository.findById(id));
 }

 @PostMapping(value = "/books")
    public ResponseEntity<Object> addBook(@RequestBody Book book) {
    Book newBook = bookRepository.save(book);
    int newID = newBook.getId();

     URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
             .buildAndExpand(newID).toUri();

     return ResponseEntity.created(null).build();

 }

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable("id")int id,@RequestBody Book book) {
        books.set(id, book);
        return ResponseEntity.created(null).build();
    }


    @PatchMapping(value = "/books/{id}")
    public ResponseEntity<Object> partialUpdateBook(@PathVariable int id, @RequestBody Book book) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (!(book==null) && book.getTitle().isEmpty()) {
            existingBook.setTitle(book.getTitle());
        }
        if (!(book==null) && book.getAuthor().isEmpty()) {
            existingBook.setAuthor(book.getAuthor());
        }
        if (!(book==null) && book.getIsbn().isEmpty()) {
            existingBook.setIsbn(book.getIsbn());
        }
        bookRepository.save(existingBook);
        return ResponseEntity.noContent().build();
    }

}