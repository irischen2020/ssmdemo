package cn.sd.ssmdemo.controller;

import cn.sd.ssmdemo.model.Employee;
import cn.sd.ssmdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/getTea")
	public String getEmployee(@RequestParam(value="bid") Integer id,Model model){
		Employee em = employeeService.getEmployee(id);
		model.addAttribute("employee",em);
		return "success";
	}
}
