package com.mayday.controller;


import com.mayday.service.BookService;
import com.mayday.service.UserService;
import com.mayday.shiro.UserRealm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.Map;

@Controller

@RequestMapping("loginMain")
public class LoginController {

    @Autowired
    private BookService  bookService;

    @Autowired
    private UserService userService;

    Log log= LogFactory.getLog(LoginController.class);

    @RequestMapping(value="/loginJump",method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("html/login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String userName, String password){

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        //得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager =new DefaultSecurityManager(new UserRealm());

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("message", "password error!");
            return modelAndView;
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("message", "username error!");
            return modelAndView;
        } catch (ExcessiveAttemptsException eae) {

            // 捕获错误登录过多的异常
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("message", "times error");
            return modelAndView;
        }
      /*  BIConversion.User user = userService.login(username);
        subject.getSession().setAttribute("user", user);
        return new ModelAndView("success"); */

        //使用重定向操作，不然会报错：POST方法不支持
        return new ModelAndView("success");
    }


    @RequestMapping(value="/loginOut", method=RequestMethod.POST)

    //通过RequestParam来获取参数值
    public String loginOut(@RequestParam Map<String,String> requestParams){

        log.info("requert"+requestParams.get("userName")+requestParams.get("password"));

        return "";
    }


    //註冊
    @RequestMapping(value="/register",method = RequestMethod.GET)
    public ModelAndView register(){
        return new ModelAndView("html/register");
    }


}
