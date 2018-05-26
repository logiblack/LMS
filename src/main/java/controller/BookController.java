package controller;

import dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.impl.BookServiceImpl;

@RestController
public class BookController {

    private BookServiceImpl bookServiceImpl;

    @Autowired
    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @GetMapping("/book/{id}")
    public Book getBookInfo(@PathVariable int id){
        return bookServiceImpl.getBookById(id);
    }
}
