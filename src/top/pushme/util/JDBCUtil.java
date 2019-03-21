package top.pushme.util;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;






public class JDBCUtil {
	/*
	 * db.properties
	 */
	private static String dbmsUsername;
	private static String dbmsPassword;
	private static String url;

	/*
	 * private constructor
	 */
	private JDBCUtil() {
		
	}
	
	static {
		try {
			System.out.println("static codes");
			Properties p = new Properties();
			
			/*
			 * use class file get ClassLoader
			 */
			ClassLoader loader = JDBCUtil.class.getClassLoader();
			System.out.println(p);
			System.out.println(loader);
			/*
			 * load property file into stream by getResourceAsStream
			 */
			
 		    InputStream in = loader.getResourceAsStream("db.properties");
			System.out.println(in);

			p.load(in);
			System.out.println("p");
			in.close();
				
			
			Class.forName(p.getProperty("driverClass"));
			url = p.getProperty("url");
			dbmsUsername = p.getProperty("dbmsUsername");
			dbmsPassword = p.getProperty("dbmsPassword");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("null,property" + url + dbmsPassword + dbmsUsername);
		}

	}

	public static Connection getConn() {
		try {
			return DriverManager.getConnection(url, dbmsUsername, dbmsPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
		
}
