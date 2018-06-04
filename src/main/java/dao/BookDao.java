package dao;

import domain.BookDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    BookDAO getBookById(int id);
    List<BookDAO> getAll();
    boolean addBook(BookDAO bookDAO);
}
