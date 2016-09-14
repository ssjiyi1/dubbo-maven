package cn.zw.controller;


import cn.zw.common.web.common.bean.Result;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

import static cn.zw.common.web.common.bean.ResultBuild.*;

/**
 * @description 天气接口
 * @auther 'Amos'
 * @created 2016/8/22  17:44
 */
@Controller
@RequestMapping("/weather")
public class WeatherController {


    String url = "http://client.k780.com:88/?app=weather.today&weaid=265&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";


    @RequestMapping("/get")
    @ResponseBody
    public Result getWeather() {
//        HttpClient httpClient = new  HttpClient();
        try {
//            GetMethod get = new GetMethod(url);
//            httpClient.executeMethod(get);
//            return  success(new String(get.getResponseBody(),"UTF-8"));
            return  success(new String("{'name':'网络不通'}"));
        } catch (Exception e) {
            e.printStackTrace();
            return  fail(e.getMessage());
        }

    }

}
