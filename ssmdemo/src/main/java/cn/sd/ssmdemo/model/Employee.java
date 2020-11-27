package cn.sd.ssmdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private Integer id;
	private String empName;
	private Integer gender;
	private String email;
	
}
