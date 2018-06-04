package dao.impl;

import dao.BookDao;
import domain.BookDAO;
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

    public BookDAO getBookById(int id) {
        SqlSession session =sqlSessionFactory.openSession();
        try {

            BookDAO bookDAO = session.selectOne(namespace+".selectById",id);
            return bookDAO;
        }finally {
            session.close();
        }
    }

    public List<BookDAO> getAll() {
        return null;
    }

    public boolean addBook(BookDAO bookDAO) {
        return false;
    }
}
