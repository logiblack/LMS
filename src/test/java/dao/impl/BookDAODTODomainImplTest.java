package dao.impl;

import dao.BookDao;
import domain.BookDomain;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;


public class BookDAODTODomainImplTest {

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
        BookDomain bookDomain = bookDao.getBookById(1);
        System.out.println(bookDomain.getName());
    }

}