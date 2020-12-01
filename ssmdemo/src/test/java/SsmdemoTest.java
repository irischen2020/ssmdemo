import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class SsmdemoTest {
	@Test
	public  void ssmTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		System.out.println(dataSource.getClass());
	
	}
}
