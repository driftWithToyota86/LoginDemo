package top.pushme.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;


public class BeanHandler<T> implements IResultSetHandler<T> {
	private Class<T> clz;
	
	public BeanHandler(Class<T> clz) {
		// TODO Auto-generated constructor stub
		this.clz = clz;
	}

	@Override
	public T handle(ResultSet rs) {
		// TODO Auto-generated method stub
		T obj = null;
		try (ResultSet r = rs) {
			if(r.next()) {
				obj = clz.newInstance();
				BeanInfo info = Introspector.getBeanInfo(clz, Object.class);
				PropertyDescriptor[] pds = info.getPropertyDescriptors();
				for (PropertyDescriptor pd : pds) {
					String name = pd.getName();
					Object value = r.getObject(name);
					pd.getWriteMethod().invoke(obj, value);
					System.out.println("beanhandle");
				}
				
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
