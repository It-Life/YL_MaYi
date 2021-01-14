package cn.yaoling.mayi.repository;

import cn.yaoling.mayi.dataobject.MayiUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MayiUserRepositoryTest {
    @Autowired
    private MayiUserRepository mayiUserRepository;
    @Test
    public void findOneTest()
    {
        MayiUser mayiUser = mayiUserRepository.findByUserUuid("11");
        //System.out.println(mayiUser.toString());
        Assert.assertNotNull(mayiUser);
    }
    @Test
    public void saveOneTest()
    {
        MayiUser mayiUser = new MayiUser();
        mayiUser.setUserId(3);
        mayiUser.setUserName("dudu12");
        mayiUser.setUserUuid("12");
        mayiUser.setUserSex(2);
        mayiUser.setUserPhone("12345678912");
        MayiUser saveResult = mayiUserRepository.save(mayiUser);
        Assert.assertNotNull(saveResult);
    }
}