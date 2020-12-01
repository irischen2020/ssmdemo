import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;

/**
 * 演示动态SQL效果
 */
public class MyBatisTest2 {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException {
		//		1、根据全局配置文件创建出一个SqlSessionFactory
		String resource = "mybatis-config1.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
}
