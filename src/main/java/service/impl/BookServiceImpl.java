package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BookService;

@Service
public class BookServiceImpl implements BookService {

    private Book book;
    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(Book book, BookDao bookDao) {
        this.book = book;
        this.bookDao = bookDao;
    }

    public Book getBookById(int id) {
       domain.Book bookinfo = bookDao.getBookById(id);
       setBookInfo(book,bookinfo);
       return book;
    }

    private void setBookInfo(Book book, domain.Book bookinfo) {
        book.setName(bookinfo.getName());
        book.setAuthor(bookinfo.getAuthor());
        book.setCover(bookinfo.getCover());
        book.setIsbn(bookinfo.getIsbn());
        book.setPrice(bookinfo.getPrice());
        book.setStatus(bookinfo.getStatus());
    }

}
