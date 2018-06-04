package controller;

import dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.impl.BookServiceImpl;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {

    private BookServiceImpl bookServiceImpl;

    @Autowired
    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @RequestMapping("/book/{id}")
    @ResponseBody
    public BookDTO getBookInfo(@PathVariable int id){
        BookDTO dto = bookServiceImpl.getBookById(id);
        System.out.println(dto.getName());
        return dto;
    }
}
