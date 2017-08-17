package com.mayday.test;


import com.mayday.model.BookModel;
import com.mayday.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MainTest extends  BestTest{

    @Autowired
    private BookService bookService;
    //测试方法
    @Test
   public void getOne(){

     BookModel bookModel= bookService.getOne(1003);
     System.out.println(bookModel.getName());

   }



}
