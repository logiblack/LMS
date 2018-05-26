package dao.impl;

import dao.BookDao;
import domain.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao  {

    String resourse = "mybatis/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resourse);
    SqlSessionFactory sqlSessionFactory =
            new SqlSessionFactoryBuilder().build(inputStream);

    String namespace = "book";

    public BookDaoImpl() throws IOException {
    }

    public Book getBookById(int id) {
        SqlSession session =sqlSessionFactory.openSession();
        try {

            Book book = session.selectOne(namespace+".selectById",id);
            return book;
        }finally {
            session.close();
        }
    }

    public List<Book> getAll() {
        return null;
    }

    public boolean addBook(Book book) {
        return false;
    }
}
