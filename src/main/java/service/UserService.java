package service;

import dto.UserBaseDto;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public interface UserService {
    Map<String, String> register(UserBaseDto dto);
    Map<String, Object> login(UserBaseDto loginDto, HttpSession session);
    Map<String, String> logout(HttpSession session);
    Map<String, String> updateInfo(UserBaseDto newInfo);
    Map<String, String> changePwd(Integer userId, String pwd);
    Map<String, String> borrowBook(Integer userId, Integer bookId);
    Map<String, String> returnBook(Integer UserId, Integer bookId);
}
