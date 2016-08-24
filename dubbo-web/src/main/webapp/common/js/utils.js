/**
 * Created by Administrator on 2016/8/4.
 */

(function($){

    /**
     *
     *   ajax请求接口
     * @param url 接口地址
     * @param data 请求参数
     * @param async 是否同步 true 异步， false 同步
     * @param method 请求方式
     * @param callBack 回调函数
     * @returns {*}
     * @constructor
     */
    $.Http = function(url, data,async,method, callBack){
        if(url === void 0 || async === void 0 ){
            console.log("url and syn must be not is null");
            return false;
        }
        var json = void 0;
        $.ajax({
            //	请求配置
            url: url,
            type: method,
            data: data,
            async: async
        }).done(function(data){
            json = data || [];
            callBack(data, true);
        }).fail(function(data){
            callBack(data, false);
        })
        return json;
    };


    $.GetHttp = function(url,callBack){
        this.Http(url,null,false,"GET",callBack);
    };

    $.GetHttpWithParams = function(url,data,callBack){
        this.Http(url,data,false,"GET",callBack);
    };


})(jQuery)
