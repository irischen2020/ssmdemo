package cn.sd.ssmdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
	private Integer id;
	private String name;
	private String age;
	private Integer gender;
}
