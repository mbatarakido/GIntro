package ben;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Statements {
	public static void main(String[] args) {
		Properties p = new Properties();
		try {
			FileInputStream fis = new FileInputStream("/Users/Ben/eclipse-workspace/JDBCproject/src/db.properties");
			p.load(fis);
			String url = p.getProperty("url");
			String username = p.getProperty("user");
			String password = p.getProperty("password");
			Connection conn = DriverManager.getConnection(url, username, password);
			if(conn != null) {
				System.out.println("Connection Successful.");
			}else {
				System.out.println("Cannot connect to the DB.");
			}
			String sql = "SELECT * FROM Movies.movies";
			String sqlUpdate = "INSERT INTO Movies.movies VALUES(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sqlUpdate);
			pst.setInt(1, 4);
			pst.setString(2, "Spiderman");
			pst.setString(3, "Peter");
			pst.setString(4, "Gwen");
			
			int rs = pst.executeUpdate();
			
			System.out.println(rs + " number of rows affected");
			conn.close();
				
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
