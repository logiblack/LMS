package dao.impl;

import dao.BookDao;
import domain.Book;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;


public class BookDaoImplTest {

    public static BookDao bookDao;

    @BeforeClass
    public static void testBefore(){
        try {
            bookDao = new BookDaoImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelect(){
        Book book = bookDao.getBookById(1);
        System.out.println(book.getName());
    }

}