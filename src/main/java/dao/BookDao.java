package dao;

import domain.BookDomain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    BookDomain getBookById(int id);
    List<BookDomain> getAll();
    boolean addBook(BookDomain bookDomain);
}
