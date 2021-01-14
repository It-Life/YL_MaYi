package cn.yaoling.mayi.repository;

import cn.yaoling.mayi.dataobject.MayiUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
* DAO 层
* */
public interface MayiUserRepository extends JpaRepository<MayiUser,Integer> {
    MayiUser findByUserUuid(String userUuid);
    MayiUser findByUserPhone(String phone);
}
