import cn.sd.ssmdemo.dao.CatDao;
import cn.sd.ssmdemo.dao.EmployeeDao;
import cn.sd.ssmdemo.dao.KeyDao;
import cn.sd.ssmdemo.dao.LockDao;
import cn.sd.ssmdemo.model.Cat;
import cn.sd.ssmdemo.model.Employee;
import cn.sd.ssmdemo.model.Key;
import cn.sd.ssmdemo.model.Lock;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MybatisTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException {
		//		1、根据全局配置文件创建出一个SqlSessionFactory
		String resource = "mybatis-config1.xml";
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
	
	@Test
	public void testGetEmmByIdReturnMap(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
		try{
			Map<String,Object> map = employeeDao.getEmmByIdReturnMap(1);
			System.out.println(map);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testGetAllEmps(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
		try{
			List<Employee> list = employeeDao.getAllEmps();
			System.out.println(list);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testGetAllEmpsReturnMap(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
		try{
			Map<Integer,Employee> map = employeeDao.getAllEmpsReturnMap();
			System.out.println(map);
		}finally {
			sqlSession.close();
		}
	}
	@Test
	public void testGetOneCatById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		CatDao catDao = sqlSession.getMapper(CatDao.class);
		try{
			Cat cat = catDao.getOneCatById(1);
			System.out.println(cat);
		}finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 联合查询情况下：
	 * 1、使用级联属性封装联合查询后的所有结果；
	 *
	 *
	 */
	@Test
	public void testGetKeyById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		KeyDao keyDao = sqlSession.getMapper(KeyDao.class);
		try{
			Key key = keyDao.getKeyById(2);
			System.out.println(key);
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testGetLockById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		LockDao lockDao = sqlSession.getMapper(LockDao.class);
		try{
			Lock lock = lockDao.getLockById(3);
			System.out.println(lock);
		}finally {
			sqlSession.close();
		}
	}
	
}
