package Datebase;

import java.sql.*;

public class CustomersDbOops {
	public static int insert(int CustomerId, String CustomerName, String HomeAddress,String City, String Mobileno) throws Exception{
		Connection conn = DbOops.getConnection();
		
		String sql = "INSERT INTO Customers VALUES(?,?,?,?,?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		
		statement.setInt(1, CustomerId);
		statement.setString(2, CustomerName);
		statement.setString(3, HomeAddress);
		statement.setString(4, City);
		statement.setString(5, Mobileno);
		
		int rowsInserted = statement.executeUpdate();
		
		return rowsInserted;
	}

}
