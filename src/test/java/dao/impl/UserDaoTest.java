package dao.impl;

import dao.UserBaseDao;
import dto.UserBaseDto;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class UserDaoTest {
    static UserBaseDao dao;

    @BeforeClass
    public static void beforeClass(){
        try {
            dao = new UserBaseDaoImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
        UserBaseDto dto = new UserBaseDto();
        dto.setName("wuye");
        dto.setPwd("12345678");
        dto.setNickname("lloo");
        dto.setNickname("xiaozi");
        dto.setEmail("1814727278@qq.com");
        System.out.println("...........\n");
        dao.save(dto);
    }
}
