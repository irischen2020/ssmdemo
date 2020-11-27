package cn.sd.ssmdemo.dao;

import cn.sd.ssmdemo.model.Employee;

public interface EmployeeDao {
	//根据员工ID查出员工
	public Employee getEmpById(Integer id);
	
	public int updateEmployee(Employee employee);
	
	public int insertEmployee(Employee employee);
	
	public int deleteEmployee(Integer id);
}
