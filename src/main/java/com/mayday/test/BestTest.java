package com.mayday.test;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

//需要加载的配置文件
@ContextConfiguration("classpath:/spring.xml")
public class BestTest {


}
