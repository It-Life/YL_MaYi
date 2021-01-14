package cn.yaoling.mayi.service.impl;

import cn.yaoling.mayi.dataobject.MayiUser;
import cn.yaoling.mayi.enums.ResultEnum;
import cn.yaoling.mayi.exception.CommonException;
import cn.yaoling.mayi.repository.MayiUserRepository;
import cn.yaoling.mayi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private MayiUserRepository mayiUserRepository;

    @Override
    public MayiUser findOne(Integer userId) {
        MayiUser mayiUser = mayiUserRepository.getOne(userId);
        return  mayiUser;
    }

    @Override
    public List<MayiUser> findAll() {
        List<MayiUser> mayiUserList = mayiUserRepository.findAll();
        return mayiUserList;
    }

    @Override
    public MayiUser findByPhone(String phone) {
        MayiUser mayiUser = mayiUserRepository.findByUserPhone(phone);
        return mayiUser;
    }

    @Override
    public MayiUser findByUuid(String uUid) {
        MayiUser mayiUser = mayiUserRepository.findByUserUuid(uUid);
        return mayiUser;
    }

    @Override
    public void save(MayiUser mayiUser) {
        mayiUserRepository.save(mayiUser);
    }

    @Override
    public MayiUser login(String phone, String password) {
        MayiUser mayiUser = mayiUserRepository.findByUserPhone(phone);
        if (mayiUser == null)
        {
            throw new CommonException(ResultEnum.USER_NOT_FIND);
        }
        if (!mayiUser.getUserPassword().equals(password))
        {
            throw new CommonException(ResultEnum.USER_PASSWORD_ERROR);
        }
        return mayiUser;
    }

    @Override
    public MayiUser register(String userName, String phone, String password) {
        if (userName.isEmpty()){
            throw new CommonException(ResultEnum.USER_NAME_ERROR);
        }
        if (phone.isEmpty()){
            throw new CommonException(ResultEnum.USER_NAME_ERROR);
        }
        if (password.isEmpty()){
            throw new CommonException(ResultEnum.USER_PASSWORD_NULL);
        }
        if (password.length() < 10){
            throw new CommonException(ResultEnum.USER_PASSWORD_NUM_ERROR);
        }
        MayiUser mayiUserPhone = mayiUserRepository.findByUserPhone(phone);
        if (mayiUserPhone != null)
        {
            throw new CommonException(ResultEnum.USER_HAVE_ERROR);
        }
        MayiUser mayiUser = new MayiUser();
        mayiUser.setUserPhone(phone);
        mayiUser.setUserUuid("11");
        mayiUser.setUserPassword(password);
        mayiUser.setUserSex(1);
        mayiUser.setUserName(userName);
        mayiUserRepository.save(mayiUser);
        return mayiUser;
    }
}
