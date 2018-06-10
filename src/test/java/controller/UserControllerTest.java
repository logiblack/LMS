package controller;

import dao.impl.BookDaoImpl;
import dao.impl.UserBaseDaoImpl;
import dto.UserBaseDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.impl.UserServiceImpl;

import java.io.IOException;

public class UserControllerTest {
    @Autowired
    UserController controller;

    {
        try {
            controller = new UserController(new UserServiceImpl(new UserBaseDaoImpl(), new BookDaoImpl()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        UserBaseDto dto = new UserBaseDto();
        dto.setUsername("wuye");
        dto.setPwd("12345678");
        dto.setEmail("1814727278@qq.com");
        controller.register(dto);
    }
}
