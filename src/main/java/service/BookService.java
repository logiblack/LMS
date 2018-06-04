package service;

import dto.BookDTO;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    BookDTO getBookById(int id);
}
