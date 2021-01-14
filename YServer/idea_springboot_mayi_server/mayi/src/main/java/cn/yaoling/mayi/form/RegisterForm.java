package cn.yaoling.mayi.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegisterForm {
/*    @NotEmpty(message = "用户名不能为空")
    private String userName;*/
    @NotEmpty(message = "手机号不能为空")
    private String userPhone;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotEmpty(message = "用户名不能为空")
    private String userName;
}
