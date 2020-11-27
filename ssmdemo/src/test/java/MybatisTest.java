import cn.sd.ssmdemo.dao.EmployeeDao;
import cn.sd.ssmdemo.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException {
		//		1、根据全局配置文件创建出一个SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void test() throws IOException {
		
//		2、获取和数据库的一次会话：getConnection()
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
//		3、使用SqlSession操作数据库,获取到dao接口的实现
		EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
		try {
			Employee employee = employeeDao.getEmpById(1);
			System.out.println(employee);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	//以下SQL语句有问题
	public void testUpdate(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
		Employee employee = new Employee();
		employee.setId(1);
		employee.setEmpName("admin08");
		employee.setEmail("888@qq.com");
		employee.setGender(1);
		try{
			int i = employeeDao.updateEmployee(employee);
			System.out.println(i);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
		try {
			Employee employee = new Employee();
			employee.setEmpName("admin04");
			employee.setEmail("000@qq.com");
			employee.setGender(1);
			int i = employeeDao.insertEmployee(employee);
			System.out.println(i);
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	@Test
	public void testDelete(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
		try {
			int i = employeeDao.deleteEmployee(1);
			System.out.println(i);
		}finally {
			sqlSession.close();
		}
	}

}
