package cn.yaoling.mayi.controller;

import cn.yaoling.mayi.VO.ResultVO;
import cn.yaoling.mayi.VO.UserVO;
import cn.yaoling.mayi.dataobject.MayiUser;
import cn.yaoling.mayi.repository.MayiUserRepository;
import cn.yaoling.mayi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class MayiUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResultVO list(@RequestParam("uuid") String uuid)
    {
        MayiUser mayiUser = userService.findByUuid(uuid);
        UserVO userVO = new UserVO();
        userVO.name = mayiUser.getUserName();
        userVO.phone = mayiUser.getUserPhone();
        userVO.userId = mayiUser.getUserUuid();
        userVO.userSex = mayiUser.getUserSex();
        ResultVO resultVO = new ResultVO();
        resultVO.code = 1;
        resultVO.msg = "啦啦啦啦";
        resultVO.data = userVO;
        return resultVO;
    }

}
