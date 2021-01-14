package cn.yaoling.mayi.dataobject;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
* 用户
* */
@Entity
@Data
@Proxy(lazy=false)
public class MayiUser {
    /**
     * 用戶id
     * Id  主鍵
     * GeneratedValue 自增类型
     */
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer userId;
    /*
    * 用户唯一id
    * */
    private String userUuid;
    /*
    * 用户名字
    * */
    private String userName;
    /*
    * 用户性别
    * */
    private Integer userSex;
    /*
    * 用户手机号
    * */
    private String userPhone;
    /*
    * 用户密码
    * */
    private String userPassword;
}
