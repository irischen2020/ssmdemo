package cn.sd.ssmdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Key {
	private Integer id;
	private String keyName;
	
	private Lock lock; //当前钥匙能开哪个锁
}
