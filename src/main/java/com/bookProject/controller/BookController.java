package com.bookProject.controller;

import com.bookProject.entity.Book;
import com.bookProject.service.BookService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    public BookService bookService;

    @GetMapping("/")
    public ResponseEntity<Book> getBook() {

        Book book = new Book();
//        book.setAuthor("santosh");
        book.setTitle("java complete course");
        book.setId(100);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/getAllBook/{id}")
    public ResponseEntity<Book> getAllbook(@PathVariable("id") int id) {
        BookService bookService = new BookService();
        Book book = bookService.getAllbook(id);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {

        Book book = bookService.getBookbyId(id);
        if (book == null) return new ResponseEntity<>(book, HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(book, HttpStatus.FOUND);
    }

    @PostMapping("/addbook")
    @CrossOrigin
    public ResponseEntity<Book> addBook(@RequestBody Book book , ServletRequest servletRequest) {

//        BookService service = new BookService() ;

        try{
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//            JSONParser parser = new JSONParser();
            System.out.println(httpServletRequest.getHeader("id"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Book book1 = new Book();
        book1 = this.bookService.addBook(book);
        return new ResponseEntity<>(book1, HttpStatus.CREATED);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book book1 = new Book();
        book1 = this.bookService.updateBook(book);
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }
}
