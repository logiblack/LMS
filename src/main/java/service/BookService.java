package service;

import dto.BookDto;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    BookDto getBookById(int id);
}
