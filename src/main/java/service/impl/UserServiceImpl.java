package service.impl;

import dao.BookDao;
import dao.UserBaseDao;
import dao.impl.UserBaseDaoImpl;
import dto.UserBaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserBaseDao userDao;
    private BookDao bookDao;

    @Autowired
    public UserServiceImpl(UserBaseDao userDao, BookDao bookDao) {
        this.userDao = userDao;
        this.bookDao = bookDao;
    }

    public void register(UserBaseDto dto) {
        userDao.save(dto);
    }

    public void login(String name, String pwd) {

    }

    public void logout() {

    }

    public void updateInfo(UserBaseDto newInfo) {
        userDao.update(newInfo);
    }

    public void changePwd(String pwd) {
        userDao.updatepwd(pwd);
    }

    public void borrowBook(int bookId) {

    }

    public void returnBook(int bookId) {

    }
}
