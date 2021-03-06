package dao.impl;

import dao.BookDao;
import domain.BookDomain;
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

    private String resource = "mybatis/mybatis-config.xml";
    private InputStream inputStream = Resources.getResourceAsStream(resource);
    private SqlSessionFactory sqlSessionFactory =
            new SqlSessionFactoryBuilder().build(inputStream);

    private String namespace = "book";

    public BookDaoImpl() throws IOException {
    }

    public BookDomain getBookById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BookDomain bookDomain = session.selectOne(namespace+".selectById",id);
            return bookDomain;
        }finally {
            session.close();
        }
    }

    public List<BookDomain> getAll() {
        return null;
    }

    public boolean addBook(BookDomain bookDomain) {
        return false;
    }
}
