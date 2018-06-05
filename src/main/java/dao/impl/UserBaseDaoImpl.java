package dao.impl;

import dao.UserBaseDao;
import dto.UserBaseDto;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;

@Repository
public class UserBaseDaoImpl implements UserBaseDao {
    private String resource = "mybatis/mybatis-config.xml";
    private InputStream inputStream = Resources.getResourceAsStream(resource);

    private SqlSessionFactory sqlSessionFactory =
            new SqlSessionFactoryBuilder().build(inputStream);

    private String namespace = "users_base";
    public UserBaseDaoImpl() throws IOException {

    }
    public void save(UserBaseDto user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert(namespace + ".save", user);
        } finally {
            sqlSession.close();
        }
    }

    public void update(UserBaseDto newInfo) {

    }

    public void updatepwd(String pwd) {

    }
}
