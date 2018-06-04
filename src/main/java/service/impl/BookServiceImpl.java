package service.impl;

import dao.BookDao;
import dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BookService;

@Service
public class BookServiceImpl implements BookService {

    private BookDTO bookDTO;
    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDTO bookDTO, BookDao bookDao) {
        this.bookDTO = bookDTO;
        this.bookDao = bookDao;
    }

    public BookDTO getBookById(int id) {
       domain.BookDAO bookinfo = bookDao.getBookById(id);
       setBookInfo(bookDTO,bookinfo);
       return bookDTO;
    }

    private void setBookInfo(BookDTO bookDTO, domain.BookDAO bookinfo) {
        bookDTO.setName(bookinfo.getName());
        bookDTO.setAuthor(bookinfo.getAuthor());
        bookDTO.setCover(bookinfo.getCover());
        bookDTO.setIsbn(bookinfo.getIsbn());
        bookDTO.setPrice(bookinfo.getPrice());
        bookDTO.setStatus(bookinfo.getStatus());
    }

}
