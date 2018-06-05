package service.impl;

import dao.BookDao;
import dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BookService;

@Service
public class BookServiceImpl implements BookService {

    private BookDto bookDto;
    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDto bookDto, BookDao bookDao) {
        this.bookDto = bookDto;
        this.bookDao = bookDao;
    }

    public BookDto getBookById(int id) {
       domain.BookDomain bookinfo = bookDao.getBookById(id);
       setBookInfo(bookDto,bookinfo);
       return bookDto;
    }

    private void setBookInfo(BookDto bookDto, domain.BookDomain bookinfo) {
        bookDto.setId(bookinfo.getId());
        bookDto.setName(bookinfo.getName());
        bookDto.setAuthor(bookinfo.getAuthor());
        bookDto.setCover(bookinfo.getCover());
        bookDto.setIsbn(bookinfo.getIsbn());
        bookDto.setPrice(bookinfo.getPrice());
        bookDto.setStatus(bookinfo.getStatus());
    }

}
