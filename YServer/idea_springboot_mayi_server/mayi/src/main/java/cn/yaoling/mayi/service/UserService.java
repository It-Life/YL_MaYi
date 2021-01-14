package cn.yaoling.mayi.service;

import cn.yaoling.mayi.dataobject.MayiUser;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    MayiUser findOne(Integer userId);
    List<MayiUser> findAll();
    MayiUser findByPhone(String phone);
    MayiUser findByUuid(String uUid);
    void save(MayiUser mayiUser);
    MayiUser login(String phone,String password);
    MayiUser register(String userName,String phone,String password);
}
