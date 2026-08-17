package ben;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import javax.sql.*;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.*;

public class ConnectionPoolDemoMySql {
	public static void main(String[] args) throws SQLException, IOException {
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("/Users/Ben/eclipse-workspace/JDBCproject/src/db.properties");
		p.load(fis);
		String url = p.getProperty("url");
		String username = p.getProperty("user");
		String password = p.getProperty("password");
		MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
		ds.setURL(url);
		ds.setUser(username);
		ds.setPassword(password);
		
		Connection conn = ds.getConnection();
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM Movies.movies");
		
		while(rs.next()) {
			System.out.println(
					rs.getInt(1) + "\t" + 
					rs.getString(2) + "\t" + 
					rs.getString(3) + "\t" + 
					rs.getString(4)
					);
		}
		
		conn.close();
	}
}
