package dao;

import domain.UserBaseDomain;
import dto.UserBaseDto;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBaseDao {
    void save(UserBaseDto user);
    void update(UserBaseDto newInfo);
    void updatepwd(String pwd);
}
