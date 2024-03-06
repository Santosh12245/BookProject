package com.bookProject.service;

import com.bookProject.entity.Book;
import com.bookProject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    @Autowired
    public BookRepository bookRepository ;


    public  BookService(){

    }


//    private static List<Book> list = new ArrayList<>() ;
//
//    static {
//        list.add(new Book(12 , "xyz" , "ashis"));
//        list.add(new Book(15 , "abc" , "rudra"));
//        list.add(new Book(100 , "pqr" , "somu"));
//    }

    public Book getAllbook(int id){
       Book book = new Book() ;

//       BookRepository repository = null ;
   try{
       book = bookRepository.findById(id) ;
       return book ;
   }catch (Exception e){
       System.out.println(e.getMessage());
       return book;

   }
    }

    public Book getBookbyId(int id){
//        Book book = null ;
//       book  = list.stream().filter(e -> e.getId() == id ).findFirst().get();
//       return book;

       return bookRepository.findById(id);
    }


    public Book addBook(Book book){
//        list.add(book) ;
//
//        list.forEach(p->{
//            System.out.println(p.toString());
//        });
//        return book ;
        return  bookRepository.save(book);
    }

    public Book updateBook(Book book){
//        Book book1 = new Book() ;
//        book1  = list.stream().filter(p-> p.getId() == book.getId()).findFirst().get() ;
//        book1.setId(book.getId());
//        book1.setTitle(book.getTitle());
//        book1.setAuthor(book.getAuthor());
//        list.forEach(p ->{
//            System.out.println(p.toString());
//        });
//        return book1 ;
        Book book1 = new Book() ;
        book1 = bookRepository.findById(book.getId());
        book1.setAuthor(book.getAuthor());
        book1.setTitle(book.getTitle());
        book1.setId(book.getId());
        bookRepository.save(book1);

    return book1 ;
    }

    public void deleteBook(int id){
        Book book = new Book() ;
       bookRepository.deleteById(id);
    }

}
