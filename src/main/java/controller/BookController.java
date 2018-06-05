package controller;

import dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.impl.BookServiceImpl;

@RestController
public class BookController {

    private BookServiceImpl bookServiceImpl;

    @Autowired
    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @RequestMapping("/book/{id}")
    @ResponseBody
    public BookDto getBookInfo(@PathVariable int id){
        BookDto dto = bookServiceImpl.getBookById(id);
        System.out.println(dto.getName());
        return dto;
    }
}
