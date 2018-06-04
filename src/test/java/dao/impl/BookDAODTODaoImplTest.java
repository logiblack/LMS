package dao.impl;

import dao.BookDao;
import domain.BookDAO;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;


public class BookDAODTODaoImplTest {

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
        BookDAO bookDAO = bookDao.getBookById(1);
        System.out.println(bookDAO.getName());
    }

}