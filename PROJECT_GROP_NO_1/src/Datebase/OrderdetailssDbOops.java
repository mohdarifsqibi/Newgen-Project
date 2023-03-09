package Datebase;

import java.sql.*;

public class OrderdetailssDbOops {
	public static int insert(int Order_Id , int Product_Id, float QtySold,int SalesPrice) throws Exception{
		Connection conn = DbOops.getConnection();
		
		String sql = "INSERT INTO Orderdetailss VALUES(?,?,?,?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		
		statement.setInt(1, Order_Id);
		statement.setInt(2, Product_Id);
		statement.setFloat(3,QtySold);
		statement.setInt(4, SalesPrice);
		
		int rowsInserted = statement.executeUpdate();
		
		return rowsInserted;
	}

	  public static ResultSet select() throws Exception
	   {
		Connection conn = DbOops.getConnection();
		PreparedStatement selectStmt = conn.prepareStatement("select * from Orderss");
		ResultSet rs = selectStmt.executeQuery();
		return rs;
	   }
		
	}
		
	   





	   


