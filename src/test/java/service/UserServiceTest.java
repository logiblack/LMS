package service;

import dao.impl.BookDaoImpl;
import dao.impl.UserBaseDaoImpl;
import dto.UserBaseDto;
import org.junit.BeforeClass;
import org.junit.Test;

import service.impl.UserServiceImpl;

import java.io.IOException;

public class UserServiceTest {
    private static UserService userService;

    @BeforeClass
    public static void before(){
        try {
            userService = new UserServiceImpl(new UserBaseDaoImpl(), new BookDaoImpl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
        UserBaseDto dto = new UserBaseDto();
        dto.setPwd("linagasdw");
        dto.setUsername("switch");
        dto.setEmail("11044546@qq.com");
        dto.setSex("female");
        userService.register(dto);
    }
}
