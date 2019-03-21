package top.pushme.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BeanListHandler<T> implements IResultSetHandler<List<T>> {
	private Class<T> clz;
	
	public BeanListHandler(Class<T> clz) {
		// TODO Auto-generated constructor stub
		this.clz = clz;
	}
	
	

	@Override
	public List<T> handle(ResultSet rs) {
		// TODO Auto-generated method stub
		List<T> list = new ArrayList<>();
		try(ResultSet r = rs) {
			while(r.next()) {
				T obj = clz.newInstance();
				BeanInfo info = Introspector.getBeanInfo(clz, Object.class);
				PropertyDescriptor[] pds = info.getPropertyDescriptors();
				for (PropertyDescriptor pd : pds) {
					String name = pd.getName();
					Object value = r.getObject(name);
					pd.getWriteMethod().invoke(obj, value);
				}
				list.add(obj);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
