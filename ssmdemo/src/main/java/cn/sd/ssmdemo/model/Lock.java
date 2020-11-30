package cn.sd.ssmdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lock {
	private Integer id;
	private String lockName;
	
	private List<Key> keys;
}
