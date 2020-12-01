package cn.sd.ssmdemo.service;

import cn.sd.ssmdemo.dao.EmployeeDao;
import cn.sd.ssmdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public Employee getEmployee(Integer id){
		Employee employee = employeeDao.getEmpById(id);
		return employee;
	}
}
