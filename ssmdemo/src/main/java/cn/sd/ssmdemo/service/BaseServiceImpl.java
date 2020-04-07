package cn.sd.ssmdemo.service;

import cn.sd.ssmdemo.dao.BaseDao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 抽象类
 * @param <T>
 */

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	/**
	 * 获取baseDao对象的解决方法：将这个实现类声明为抽象类
	 * @return
	 */
	public abstract BaseDao getBaseDao();
	
	/**
	 * 在增删改查方法中需要知道T到底是什么Class
	 * @param t
	 */
	public Class<?> clazz;
	
	public BaseServiceImpl(){
//		Type type = this.getClass().getGenericSuperclass();
//		ParameterizedType pt = (ParameterizedType)type;
//		Type[] types = pt.getActualTypeArguments();
//		clazz = (Class<?>)types[0];
		//连起来写，通过构造函数拿到T的类型
		clazz = (Class<?>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments())[0];
	}
	
	public void add(T t) {
	
	
	}
	
	public void delete(int id) {
	
	}
	
	public void update(T t) {
	
	}
	
	public T select(int id) {
		return null;
	}
	
	public List<T> selectall() {
		return null;
	}
	
}
