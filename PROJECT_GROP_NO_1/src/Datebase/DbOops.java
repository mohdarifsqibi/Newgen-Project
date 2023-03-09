package Datebase;

import java.sql.*;
 
public class DbOops {
private static Connection connection;
	
	public static Connection getConnection() throws Exception
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		connection = DriverManager.getConnection("jdbc:sqlserver://192.168.134.164;databaseName=db113;trustServerCertificate=true","user113","db113");
		return connection;

}
	
}
