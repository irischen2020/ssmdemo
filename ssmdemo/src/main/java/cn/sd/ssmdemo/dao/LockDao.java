package cn.sd.ssmdemo.dao;

import cn.sd.ssmdemo.model.Key;
import cn.sd.ssmdemo.model.Lock;

import java.util.List;

public interface LockDao {
	public Lock getLockById(Integer id);
}
