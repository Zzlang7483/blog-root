package com.zdz.vo;

public enum ErrorCode {

    PARAMS_ERROR(10001,"参数错误"),
    TOKEN_ERROR(10003,"TOKEN不合法"),
    ACCOUNTE_PWD_NOT_EXIST(10002,"用户名或密码不存在"),
    ACCOUNT_EXIST(10004,"账号已存在"),
    NO_PERROR(10007,"无访问权限"),
    SESSION_TIME_OUT(10009,"会话超时"),
    NO_LOGIN(10000,"未登录"),;

    private int code;
    private String msg;
    ErrorCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }


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
}
