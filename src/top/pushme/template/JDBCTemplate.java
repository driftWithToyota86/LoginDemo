package top.pushme.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import top.pushme.handler.IResultSetHandler;
import top.pushme.util.JDBCUtil;

public class JDBCTemplate {

	
	public static <T> T query(String sql, IResultSetHandler<T> rsh, Object...params) {
		try (
		Connection conn = JDBCUtil.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
				 ) {
			for(int i = 0; i< params.length; i++) {
				ps.setObject(i + 1,  params[i]);
			}
			ResultSet rs = ps.executeQuery();
//			rs.close();
			return rsh.handle(rs);	

			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}
		
	
	}		
}
