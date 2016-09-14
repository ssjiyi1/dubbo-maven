package cn.zw.controller;

import cn.zw.common.web.common.bean.Result;
import cn.zw.common.web.common.bean.ResultBuild;
import cn.zw.message.active.Message;
import cn.zw.message.active.client.MessageProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static cn.zw.common.web.common.bean.ResultBuild.*;

/**
 * @description 赞美的controller
 * @auther 'Amos'
 * @created 2016/9/13  16:39
 */
@Controller
@RequestMapping("/praise")
public class PraiseController {


    @Autowired
    private MessageProducerService messageProducerService;

    private final static Logger LOGGER = LoggerFactory.getLogger(PraiseController.class);


    @RequestMapping("/add")
    @ResponseBody
    public Result add(String data){
        try {
            Message message = new Message(data);
            messageProducerService.send(message);
            LOGGER.info("添加评论信息,成功转发----------->"+data);
            return success(ResultBuild.SUCCESS_OK);
        } catch (Exception e) {
            LOGGER.error("添加评论信息,转发失败----------->"+data,e);
            return fail(e.getMessage());
        }
    }

}