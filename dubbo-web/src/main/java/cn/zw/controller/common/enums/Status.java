package cn.zw.controller.common.enums;

public enum Status{

    SUCCESS(2000,"响应成功"),
    FAIL(5000,"响应失败");

    private int status;

    private String msg;

    Status(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}