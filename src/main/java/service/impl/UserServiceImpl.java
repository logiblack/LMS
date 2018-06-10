package service.impl;

import dao.BookDao;
import dao.UserBaseDao;
import dto.UserBaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private UserBaseDao userDao;
    private BookDao bookDao;

    @Autowired
    public UserServiceImpl(UserBaseDao userDao, BookDao bookDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
    }

    public Map<String, String> register(UserBaseDto dto) {
        Map<String, String> json = new HashMap<String, String>();
        if (userDao.search(dto.getUsername()) != null) {
            userDao.save(dto);
            json.put("result", "success");
            json.put("message", "register succeed!");
            return json;
        }
        json.put("result", "error");
        json.put("message", "username has exist!");
        return json;
    }

    public Map<String, Object> login(UserBaseDto loginDto, HttpSession session) {
        String username = loginDto.getUsername();
        String pwd = loginDto.getPwd();
        Map<String, Object> json = new HashMap<String, Object>();
        loginDto = userDao.search(username);

        if (loginDto != null && checkPwd(username, pwd)) {
            session.setAttribute("currentUser", username);
            json.put("user", loginDto);
            json.put("result", "success");
        } else {
            json.put("result", "error");
            json.put("message", "username or password wrong!");
        }
        return json;
    }

    public Map<String, String> logout(HttpSession session) {
        Map<String, String> json = new HashMap<String, String>();
        session.invalidate();
        json.put("result", "success");
        json.put("message", "logout succeed!");
        return json;
    }

    public Map<String, String> updateInfo(UserBaseDto newInfo) {
        Map<String, String> json = new HashMap<String, String>();
        userDao.update(newInfo);
        return json;
    }

    public Map<String, String> changePwd(Integer userId ,String pwd) {
        Map<String, String> json = new HashMap<String, String>();
        userDao.updatepwd(userId, pwd);
        return json;
    }

    public Map<String, String> borrowBook(Integer userId, Integer bookId) {
        Map<String, String> json = new HashMap<String, String>();
        return json;
    }

    public Map<String, String> returnBook(Integer userId, Integer bookId) {
        Map<String, String> json = new HashMap<String, String>();
        return json;
    }

    private boolean checkPwd(String username, String pwd){
        return userDao.search(username).getPwd().equals(pwd);
    }
}
