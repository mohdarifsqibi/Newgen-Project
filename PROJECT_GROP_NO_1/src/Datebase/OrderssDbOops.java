package Datebase;

import java.sql.Date;

import java.sql.*;

public class OrderssDbOops {
	public static int insert(int Order_Id , int CustomerId, String PaymentMode,int Total_Amount, int Balance_Amount,Date Order_Date,Date Order_Deliverydate) throws Exception{
		Connection conn = DbOops.getConnection();
		
		String sql = "INSERT INTO Orderss VALUES(?,?,?,?,?,?,?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		
		statement.setInt(1, Order_Id);
		statement.setInt(2, CustomerId);
		statement.setString(3,PaymentMode);
		statement.setInt(4,Total_Amount );
		statement.setInt(5, Balance_Amount);
		statement.setDate(6, Order_Date);
		statement.setDate(7, Order_Deliverydate);
		
		int rowsInserted = statement.executeUpdate();
		
		return rowsInserted;
	}


  public static ResultSet select() throws Exception
   {
	Connection conn = DbOops.getConnection();
	PreparedStatement selectStmt = conn.prepareStatement("select * from Customers");
	ResultSet spresultset = selectStmt.executeQuery();
	return spresultset;
}
 
  
}
 


