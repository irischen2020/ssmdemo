package cn.sd.ssmdemo.service;

import cn.sd.ssmdemo.dao.BaseDao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 抽象类
 *
 * @param <T>
 */

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	/**
	 * 获取baseDao对象的解决方法：将这个实现类声明为抽象类
	 *
	 * @return
	 */
	public abstract BaseDao getBaseDao();
	
	/**
	 * 在增删改查方法中需要知道T到底是什么Class
	 *
	 * @param t
	 */
	public Class<?> clazz;
	public String tableName;
	
	public BaseServiceImpl() {
//		Type type = this.getClass().getGenericSuperclass();
//		ParameterizedType pt = (ParameterizedType)type;
//		Type[] types = pt.getActualTypeArguments();
//		clazz = (Class<?>)types[0];
		//获取数据表的名字
		tableName = "t_" + clazz.getSimpleName().toLowerCase();
		//连起来写，通过构造函数拿到T的类型
		clazz = (Class<?>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments())[0];
	}
	
	public void add(T t) {
		//获取数据表的名字
		String tableName = "t_" + clazz.getSimpleName().toLowerCase();
		List<Object> list = new ArrayList<Object>();
		for (Field field : t.getClass().getDeclaredFields()) {
			field.setAccessible(true); //打开获取private修饰的属性的权限
			try {
				list.add(field.get(t));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		getBaseDao().add(tableName, list.toArray());
	}
	
	public void delete(int id) {
		getBaseDao().delete(tableName, id);
	}
	
	public void update(T t) {
		int id = 0;
		List<Object> list = new ArrayList<Object>();
		for (Field field : t.getClass().getDeclaredFields()) {
			field.setAccessible(true); //打开获取private修饰的属性的权限
			try {
				if (field.get(t) == null) {
					continue;
				}
				if (("id").equals(field.getName())) {
					id = (Integer) field.get(t);
					continue;
				}
				// 拼接成 ：变量名='值' 的形式
				list.add(field.getName() + "=" + "'" + field.get(t) + "'");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		getBaseDao().update(tableName,id,list.toArray());
	}
	
	public T select(int id) {
		return null;
	}
	
	public List<T> selectall() {
		return null;
	}
	
}
