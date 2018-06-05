package controller;

import dto.UserBaseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;
import service.impl.UserServiceImpl;

@Controller
@RequestMapping("user")
public class UserController {
    private UserService userService;
    public UserController(UserServiceImpl service){
        userService = service;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(UserBaseDto user){
        userService.register(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(){

    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(){

    }
}
