package Datebase;

import java.sql.*;

public class OrderitemDbOops {
	public static int insert(int Item_Id , int Product_Id, int Price,Date Order_Date) throws Exception{
		Connection conn = DbOops.getConnection();
		
		String sql = "INSERT INTO Orderitem VALUES(?,?,?,?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		
		statement.setInt(1, Item_Id);
		statement.setInt(2, Product_Id);
		statement.setInt(3,Price);
		statement.setDate(4, Order_Date);
		
		int rowsInserted = statement.executeUpdate();
		
		return rowsInserted;
	}
	 public static ResultSet select() throws Exception
	    {
	    	Connection conn = DbOops.getConnection();
	    	PreparedStatement selectStmt = conn.prepareStatement("select * from Product");
	    	ResultSet spresultset = selectStmt.executeQuery();
	    	return spresultset;
	    }
	    

}

