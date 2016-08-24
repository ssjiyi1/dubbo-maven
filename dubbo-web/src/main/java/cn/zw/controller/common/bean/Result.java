package cn.zw.controller.common.bean;

import cn.zw.controller.common.enums.Status;

import java.io.Serializable;

/**
 * @description 接口数据返回的封装类
 * @auther 'Amos'
 * @created 2016/8/3  10:34
 */
public class Result implements Serializable {


    private int code;

    private String msg;

    private Object data;

    public void setData(Object data) {
        this.data = data;
    }

    public void setStatus(Status status) {
        setMsg(status);
    }

    private void setMsg(Status status) {
        this.code = status.getStatus();
        this.msg = status.getMsg();
    }

    public Result(Status status, Object data) {
        setMsg(status);
        this.data = data;
    }

    public Result() {
    }

    public Result(Status status) {
        setMsg(status);
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

    public Object getData() {
        return data;
    }
}


