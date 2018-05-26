package service;

import dto.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Book getBookById(int id);
}
