package com.projecthub.rk.Book_Management_App.controller;

import com.projecthub.rk.Book_Management_App.model.Book;
import com.projecthub.rk.Book_Management_App.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepo repo;

    //Home page end point
    @RequestMapping("/")
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("Hello from Books app" , HttpStatus.OK);

    }
    // GET ALL BOOKS
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
     List<Book> allBook =  repo.findAll();
     if(allBook.isEmpty()){
         return new ResponseEntity<>(allBook,HttpStatus.NO_CONTENT);
     }
     return new ResponseEntity<>(allBook,HttpStatus.OK);
    }

    //POST NEW BOOK
    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = repo.save(book);  // save() returns Book, not Optional

        if (newBook != null) {
            return new ResponseEntity<>(newBook, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //GET BOOK BY ID
    @GetMapping("/book/{id}")
    public ResponseEntity findBookById(@PathVariable int id){
        Optional<Book> foundBook = repo.findById(id);
        if(foundBook.isEmpty()){
            return new ResponseEntity<>(foundBook,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundBook,HttpStatus.FOUND);
    }
    //PUT BOOK DETAILS
    @PutMapping("/book/{id}")
    public ResponseEntity updateBook(@PathVariable int id ,@RequestBody Book book){
        Optional<Book> foundBook = repo.findById(id);
        if(foundBook.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
           foundBook.get().setAuthor(book.getAuthor());
            foundBook.get().setTitle(book.getTitle());
           Book updatedBook = repo.save(foundBook.get());
           return new ResponseEntity(updatedBook,HttpStatus.OK);
    }
    //DELETE BOOK
    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBook(@PathVariable int id){
        Optional<Book> foundBook = repo.findById(id);
        if(foundBook.isEmpty()){
            return new ResponseEntity(foundBook,HttpStatus.NOT_FOUND);
        }
        repo.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
