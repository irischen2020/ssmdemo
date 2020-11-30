package cn.sd.ssmdemo.dao;

import cn.sd.ssmdemo.model.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
	//根据员工ID查出员工
	public Employee getEmpById(Integer id);
	
	public int updateEmployee(Employee employee);
	
	public int insertEmployee(Employee employee);
	
	public int deleteEmployee(Integer id);
	
	//各种返回值类型练习
	//返回单条数据，数据类型为MAP。
	public Map<String,Object> getEmmByIdReturnMap(Integer id);
	
	//返回LIST集合
	public List<Employee> getAllEmps();
	
	/**
	 * 查询出所有数据，并且把所有数据都封装在MAP里面，指定ID为KEY，Employee对象为value
	 */
	@MapKey("id")
	public Map<Integer,Employee> getAllEmpsReturnMap();
	
	
	
}
