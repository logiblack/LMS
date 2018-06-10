package dao;

import domain.UserBaseDomain;
import dto.UserBaseDto;
import org.springframework.stereotype.Repository;

public interface UserBaseDao {
    void save(UserBaseDto user);
    void update(UserBaseDto newInfo);
    void updatepwd(int userId ,String pwd);
    UserBaseDto search(String username);
}
