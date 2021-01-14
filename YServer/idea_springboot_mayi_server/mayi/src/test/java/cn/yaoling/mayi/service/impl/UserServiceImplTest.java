package cn.yaoling.mayi.service.impl;

import cn.yaoling.mayi.dataobject.MayiUser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    @Test
    void findOne() {
        MayiUser mayiUser = userService.findOne(1);
        System.out.println(mayiUser.toString());
    }

    @Test
    void findAll() {
        List<MayiUser> mayiUserList = userService.findAll();
        System.out.println(mayiUserList.toString());
    }

    @Test
    void findByPhone() {
        MayiUser mayiUser = userService.findByPhone("12345678912");
        System.out.println(mayiUser.toString());
    }

    @Test
    void findByUuid() {
        MayiUser mayiUser = userService.findByUuid("11");
        System.out.println(mayiUser.toString());
    }

    @Test
    void save() {
        MayiUser mayiUser = new MayiUser();
        mayiUser.setUserName("xxx");
        mayiUser.setUserSex(1);
        mayiUser.setUserUuid("13");
        mayiUser.setUserPhone("12346578912");
        userService.save(mayiUser);
    }
}