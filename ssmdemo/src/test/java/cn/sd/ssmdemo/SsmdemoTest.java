package cn.sd.ssmdemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class SsmdemoTest {
    @Test
    public  void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource.getClass());
    }

}
