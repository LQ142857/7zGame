package com.a7z.sevenzgame.entity.vo;

/**
 * 管理系统登录注册返回的结果
 *
 * @author lq
 * @create 2020/3/18-11:14
 */

public class ResultAdmin {

    private int code;
    private String msg;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultAdmin{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
