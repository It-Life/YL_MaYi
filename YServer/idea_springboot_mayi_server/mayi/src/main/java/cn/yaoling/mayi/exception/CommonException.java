package cn.yaoling.mayi.exception;

import cn.yaoling.mayi.enums.ResultEnum;

public class CommonException extends RuntimeException {

    private Integer code;
    public CommonException(ResultEnum resultEnum)
    {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public CommonException(Integer code,String msg)
    {
        super(msg);
        this.code = code;
    }
}
