package cn.sd.ssmdemo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseDao {
	//增删改查
	public void add(@Param("tableName") String tableName,@Param("objects") Object[] objects);
	
	public void delete(@Param("tableName") String tableName,@Param("id") Integer id);
	
	public void update(@Param("tableName") String tableName,@Param("id") Integer id,@Param("objects") Object[] objects);
	
	//查询一条记录
	public Map<Object,Object> select(@Param("tableName") String tableName,@Param("id") Integer id);
	//查询所有记录
	public List<Map<Object,Object>> selectall(@Param("tableName") String tableName);
}
