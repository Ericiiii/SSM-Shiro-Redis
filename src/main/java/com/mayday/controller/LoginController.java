package com.mayday.controller;

import com.mayday.model.BookModel;
import com.mayday.service.BookService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping("loginMain")
public class LoginController {

    @Autowired
    private BookService  bookService;

    Log log= LogFactory.getLog(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String  login(String userName,String password){

        log.info("【！！！】进入login方法 "+userName+password);
        BookModel bookModel=bookService.getOne(1003);

        return bookModel.getName();
    }


}
