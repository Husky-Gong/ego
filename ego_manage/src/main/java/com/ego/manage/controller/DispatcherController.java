package com.ego.manage.controller;

import com.ego.commons.pojo.EgoResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 电商后台页面跳转控制器
 */
@Controller
public class DispatcherController {
    /**
     * 进入首页面。登录页面
     * @return
     */
    @RequestMapping(value = {"/", "/index", "/default", "/welcome"})
    public String toIndex(){
        System.out.println("进入首页面。登录页面");
        return "login"; // "forward:/WEB-INF/jsp/login.jsp
    }

    /**
     * 登录认证成功
     * @return {"status":200}
     */
    @RequestMapping("/success")
    @ResponseBody
    public EgoResult success(){
        return EgoResult.ok();
    }

    /**
     * 登录认证失败
     * @return {"status":非200}
     */
    @RequestMapping("/failure")
    @ResponseBody
    public EgoResult failure(){
        return EgoResult.error();
    }

    /**
     * 登录成功后，跳转页面的处理方法。
     * @return
     */
    @RequestMapping("/main")
    public String toMain(){
        return "index";
    }
}
