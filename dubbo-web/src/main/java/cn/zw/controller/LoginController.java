package cn.zw.controller;

import cn.zw.controller.common.bean.Constants;
import cn.zw.entity.Student;
import cn.zw.facade.service.StudentFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;

@Controller
@RequestMapping("/system")
public class LoginController {

    @Autowired
    private StudentFacade studentFacade;

    private final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(String name, String pwd, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("redirect:/student/index");
        try {
            if (StringUtils.isEmpty(name)) {
                mav.setViewName("redirect:/system/index");
                mav.addObject("info", URLEncoder.encode("用户名不能为空", "utf-8"));
                return mav;
            }
            Student student = studentFacade.findByName(name);
            if (null == student || !student.getPwd().equals(pwd)) {
                mav.setViewName("redirect:/system/index");
                mav.addObject("info", URLEncoder.encode("用户名或者密码错误", "UTF-8"));
                return mav;
            } else {
                // 通过session和配置拦截器，判断用户是否登陆
                request.getSession().setAttribute(Constants._USER_LOGIN_TAG, student);
            }
        } catch (Exception e) {
            LOGGER.error("登陆失败", e);
            mav.setViewName("/system/login");
            mav.addObject("info", e.getMessage());
        }
        return mav;
    }


    @RequestMapping("/index")
    public String login() {
        return "/student/login";
    }


}
