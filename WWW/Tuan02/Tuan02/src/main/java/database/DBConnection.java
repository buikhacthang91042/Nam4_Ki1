package database;

import java.sql.Connection;
import java.sql.DriverManager;



public class DBConnection {

	public DBConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static Connection getConnection() {
		Connection connect = null;
		String jdbcURL = "jdbc:sqlserver://localhost: 1433; databaseName= UploadFileServletDB;encrypt=false;";
		String taiKhoanSQL = "sa";
		String passWordSQL = "123";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect = DriverManager.getConnection(jdbcURL,taiKhoanSQL,passWordSQL);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return connect;
	}
}
