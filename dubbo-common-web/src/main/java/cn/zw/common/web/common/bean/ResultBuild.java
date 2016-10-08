package cn.zw.common.web.common.bean;


import cn.zw.common.web.common.enums.Status;

/**
 * @description 构建返回对象的工具类
 * @auther 'Amos'
 * @created 2016/8/3  10:48
 */
public class ResultBuild {


    public static final String SUCCESS_OK = "ok";

    /**
     *  请求成功
     * @param data
     * @return
     */
    public  static Result success(Object data){
        Result result =  new Result(Status.SUCCESS,data);
        return  result;
    }


    /**
     *  请求失败
     * @return
     */
    public  static Result fail(){
        return new Result(Status.FAIL);
    }


    /**
     *  请求失败
     * @return
     */
    public  static Result fail(String msg){
        Result result = new Result(Status.FAIL);
        result.setMsg(msg);
        return result;
    }


}
