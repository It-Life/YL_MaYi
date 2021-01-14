package cn.yaoling.mayi.controller;

import cn.yaoling.mayi.VO.ResultVO;
import cn.yaoling.mayi.VO.UserVO;
import cn.yaoling.mayi.dataobject.MayiUser;
import cn.yaoling.mayi.enums.ResultEnum;
import cn.yaoling.mayi.exception.CommonException;
import cn.yaoling.mayi.form.LoginForm;
import cn.yaoling.mayi.form.RegisterForm;
import cn.yaoling.mayi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public MayiUser dologin(@Valid LoginForm loginForm,
                            BindingResult bindingResult
    )
    {
        if (bindingResult.hasErrors()) {
            log.error("【登录】参数不正确, loginForm={}", loginForm);
            throw new CommonException(ResultEnum.USER_NAME_ERROR);
        }
        String userPhone = loginForm.getUserPhone();
        String password = loginForm.getPassword();
        return userService.login(userPhone,password);
    }
    @PostMapping("/register")
    public ResultVO doregister(@Valid RegisterForm registerForm,
                           BindingResult bindingResult
                           ){
        if (bindingResult.hasErrors()) {
            log.error("【注册】参数不正确, RegisterForm={}", registerForm);
            throw new CommonException(ResultEnum.USER_NAME_ERROR);
        }
        String userName = registerForm.getUserName();
        String userPhone = registerForm.getUserPhone();
        String password = registerForm.getPassword();
        MayiUser mayiUser = userService.register(userName,userPhone,password);
        UserVO userVO = new UserVO();
        userVO.userId = mayiUser.getUserUuid();
        userVO.userSex = mayiUser.getUserSex();
        userVO.phone = mayiUser.getUserPhone();
        userVO.name = mayiUser.getUserName();
        ResultVO resultVO = new ResultVO();
        resultVO.code = 0;
        resultVO.msg = "注册成功";
        resultVO.data = userVO;
        return resultVO;
    }
}
