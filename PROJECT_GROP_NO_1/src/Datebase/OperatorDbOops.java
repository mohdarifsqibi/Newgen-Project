package Datebase;

import java.sql.*;




public class OperatorDbOops {
	public static int insert(String Operator_Id , String Operator_Name, String User_Phonenumber,String Password) throws Exception{
		Connection conn = DbOops.getConnection();
		
		String sql = "INSERT INTO Operator VALUES(?,?,?,?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		
		statement.setString(1, Operator_Id);
		statement.setString(2, Operator_Name);
		statement.setString(3,User_Phonenumber);
		statement.setString(4, Password);
		
		int rowsInserted = statement.executeUpdate();
		
		return rowsInserted;
	}
}
