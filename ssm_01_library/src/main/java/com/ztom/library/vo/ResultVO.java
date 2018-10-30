package com.ztom.library.vo;

/**
 * 封装返回给前端的数据,以json字符串的形式返回给前端ajax
 * author:ztom
 * date:2018/10/25 21:51
 */
public class ResultVO<T> {
    public static final Integer SUCCESS = 1;
    public static final Integer FAIL = 0;

    private Integer flag;
    private T data;
    private String msg;

    public ResultVO() {
    }

    public ResultVO(Integer flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public ResultVO(Integer flag, T data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
