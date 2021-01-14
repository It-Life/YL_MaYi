package cn.yaoling.mayi.VO;

/*
* http请求的最外层对象
* */
public class ResultVO<T> {
    public Integer code;

    public String msg;

    public T data;
}
