package nl.novi.hello.model;

import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    // atributten

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   int id;

   @Column(name = "title")
   String title;

   @Column(name = "author")
   String author;

   @Column(name = "isbn")
   String isbn;

    //constructor is niet nodig

    //setters and getters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
