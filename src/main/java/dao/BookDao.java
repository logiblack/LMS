package dao;

import domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    Book getBookById(int id);
    List<Book> getAll();
    boolean addBook(Book book);
}
