package Datebase;

import java.sql.*;

public class ProductDbOops {
	public static int insert(int Product_Id , String Product_name, int Price,int OpeningStock) throws Exception{
		Connection conn = DbOops.getConnection();
		
		String sql = "INSERT INTO Product VALUES(?,?,?,?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		
		statement.setInt(1, Product_Id);
		statement.setString(2, Product_name);
		statement.setInt(3,Price);
		statement.setInt(4, OpeningStock);
		
		int rowsInserted = statement.executeUpdate();
		
		return rowsInserted;
	}

}
