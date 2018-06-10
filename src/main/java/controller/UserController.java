package controller;

import dao.UserBaseDao;
import dto.UserBaseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    private UserService userService;
    public UserController(UserServiceImpl service){
        userService = service;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> register(@RequestBody UserBaseDto user){
        Map<String, String> result = new HashMap<String, String>();
        result.putAll(userService.register(user));
        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody UserBaseDto loginDto, HttpSession session){
        Map<String, Object> json = new HashMap<String, Object>();
        System.out.println("request username:"+loginDto.getUsername());
        json.putAll(userService.login(loginDto, session));
        return json;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> logout(){
        Map<String, String> result = new HashMap<String, String>();
        return result;
    }
}
