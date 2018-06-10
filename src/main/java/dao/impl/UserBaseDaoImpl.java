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
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert(namespace + ".update_user", newInfo);
        } finally {
            sqlSession.close();
        }
    }

    public void updatepwd(int userId, String pwd) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserBaseDto dto = new UserBaseDto();
            dto.setPwd(pwd);
            dto.setId(userId);
            sqlSession.insert(namespace + ".update_pwd", dto);
        } finally {
            sqlSession.close();
        }
    }

    //username不能重复
    public UserBaseDto search(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserBaseDto s;
        try {
            s = sqlSession.selectOne(namespace+".selectByName", username);
        }finally {
            sqlSession.close();
        }
        return s;
    }
}
