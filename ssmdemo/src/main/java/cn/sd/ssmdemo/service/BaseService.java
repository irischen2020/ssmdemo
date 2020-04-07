package cn.sd.ssmdemo.service;

import java.util.List;

public interface BaseService<T> {
	//增删改查
	
	public void add(T t);
	
	public void delete(int id);
	
	public void update(T t);
	
	public T select(int id);
	
	public List<T> selectall();
	
}
