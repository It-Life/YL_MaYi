package cn.yaoling.mayi.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),
    USER_NOT_FIND(1,"用户不存在"),
    USER_PASSWORD_ERROR(2,"密码错误"),
    USER_NAME_ERROR(3,"请输入用户名"),
    USER_PHONE_ERROR(4,"请输入手机号"),
    USER_PHONE_NUM_ERROR(5,"请输入正确的手机号"),
    USER_PASSWORD_NULL(6,"请输入密码"),
    USER_PASSWORD_NUM_ERROR(7,"密码太简单"),
    USER_HAVE_ERROR(8,"用户已经存在"),
    ;

    private Integer code;
    private String msg;
    ResultEnum(Integer code,String msg)
    {
        this.code = code;
        this.msg = msg;
    }


}
