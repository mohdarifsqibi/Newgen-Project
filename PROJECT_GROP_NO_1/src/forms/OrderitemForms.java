package forms;

import Datebase.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class OrderitemForms extends JFrame implements ActionListener 
{
	JLabel lblItem_Id , lblProduct_Id, lblPrice, lblOrder_Date;
	JTextField txtItem_Id, txtPrice,txtOrder_Date;
	JComboBox cmbProduct_Id;
	JButton btnSave;
	
	  public OrderitemForms() throws Exception
	  {
		  lblItem_Id= new JLabel("Item Id");
		  lblPrice= new JLabel("Price");
		  lblOrder_Date= new JLabel("Order Date");
		  lblProduct_Id= new JLabel("Product Id");
		  
		  
		  txtItem_Id = new JTextField(20);
		  txtPrice = new JTextField(20);
		  txtOrder_Date = new JTextField(20);
		  
		  cmbProduct_Id = new JComboBox();  
		  
		  
		 
		  
		  btnSave = new JButton("Save");
		  btnSave.addActionListener(this);
		  
		  this.loadControls();
		  
		  ResultSet rs = OrderitemDbOops.select();
		  
		  while(rs.next())
		  {
			  cmbProduct_Id.addItem(rs.getInt(1));
		  }

}
	  void loadControls()
	  {
		  
		  this.getContentPane().add(lblItem_Id);
		  this.getContentPane().add(txtItem_Id);
		  this.getContentPane().add(lblProduct_Id);
		  this.getContentPane().add(cmbProduct_Id);
		  this.getContentPane().add(lblOrder_Date);
		  this.getContentPane().add(txtOrder_Date);
		  this.getContentPane().add(lblPrice);
		  this.getContentPane().add(txtPrice);
		  this.getContentPane().add(btnSave);
		  this.setSize(300,200);
		  this.setLayout(new FlowLayout());
		  this.setVisible(true);
		  
	  }
	  
	  public void actionPerformed(ActionEvent e) 
	  {
		 
		  int itemid = Integer.parseInt(txtItem_Id.getText());
		  int price = Integer.parseInt(txtPrice.getText());
		  Date orderDate = Date.valueOf(txtOrder_Date.getText());	 
		  int productid = Integer.parseInt(cmbProduct_Id.getSelectedItem().toString());
		
		  try
		  {
		    OrderitemDbOops.insert(itemid, productid, price, orderDate);
		  }
		  catch(Exception ex)
		  {		  
			  JOptionPane.showMessageDialog(null, ex.getMessage());
		  }
		  JOptionPane.showMessageDialog(null, "Saved");
	  }
	  

	public static void main(String[] args)throws Exception {
		
		// TODO Auto-generated method stub
		
		OrderitemForms ofms = new OrderitemForms();

	}

}
