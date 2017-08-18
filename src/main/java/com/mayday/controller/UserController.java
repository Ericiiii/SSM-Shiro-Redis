package com.mayday.controller;


import com.mayday.model.UserModel;
import com.mayday.service.BookService;
import com.mayday.service.UserService;
import com.mayday.shiro.TokenManage;
import com.mayday.shiro.UserRealm;
import com.mayday.utils.MD5Utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import java.util.Date;
import java.util.Map;

@Controller

@RequestMapping("loginMain")
public class UserController extends BaseController{

    @Autowired
    private BookService  bookService;

    @Autowired
    private UserService userService;

    Log log= LogFactory.getLog(UserController.class);

    @RequestMapping(value="/loginJump",method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("/login");
    }

    //登录操作
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(String userName, String password){




        try {

            TokenManage.login(new UserModel(userName,password),true);

        } catch (IncorrectCredentialsException ice) {

            resultMap.put("message","密码错误");
            return resultMap;
        } catch (UnknownAccountException uae) {

            resultMap.put("message","用戶名或者密碼錯誤");
          return  resultMap;

        } catch (ExcessiveAttemptsException eae) {

            resultMap.put("message","连续错误五次，账户被锁定");
           return resultMap;

        }catch (DisabledAccountException e){
            resultMap.put("message","賬戶已經被鎖定");
            return  resultMap;
        }

        resultMap.put("message","success");
        return resultMap;
    }


    @RequestMapping(value="/loginOut", method=RequestMethod.POST)

    //退出登錄
    public String loginOut(){



        return "";
    }


    //註冊
    @RequestMapping(value="/register",method = RequestMethod.GET)
    public ModelAndView register(){
        return new ModelAndView("/register");
    }

    //用戶註冊
    @RequestMapping(value="/registerStart",method=RequestMethod.GET)
    public ModelAndView register(@RequestParam Map<String,String> requestParams){
        log.info("~~~~~進入註冊方法~~~~~");

        String userName=requestParams.get("userName");
        String email=requestParams.get("email");
        String password= MD5Utils.encode(requestParams.get("password"));  //密碼使用MD5加密處理

        UserModel userModel=new UserModel(userName,email,password,new Date(),null,1L);

        try {
            userService.insertUser(userModel);

        } catch (Exception e) {
            e.printStackTrace();
            ModelAndView modelAndView=new ModelAndView("/404");
            modelAndView.addObject("message","用戶註冊失敗");
           return modelAndView;
        }

        ModelAndView modelAndView=new ModelAndView("/index");
        modelAndView.addObject("status",200);
        modelAndView.addObject("message","用戶註冊成功！");

        return modelAndView;
    }



    @RequestMapping(value="/index",method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("/index");
    }


}
