package service;

import dto.UserBaseDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void register(UserBaseDto dto);
    void login(String name, String pwd);
    void logout();
    void updateInfo(UserBaseDto newInfo);
    void changePwd(String pwd);
    void borrowBook(int bookId);
    void returnBook(int bookId);
}
