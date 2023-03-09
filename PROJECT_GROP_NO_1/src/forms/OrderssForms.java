package forms;

import Datebase.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
public class OrderssForms extends JFrame implements ActionListener
{
	  JLabel lblOrder_Id, lblCustomer_Id, lblPaymentMode,lblTotal_Amount,lblBalance_Amount,lblOrder_Date,lblOrder_Deliverydate;
	  JTextField txtOrder_Id, txtTotal_Amount, txtBalance_Amount,txtOrder_Deliverydate;
	  JComboBox cmbCustomer_Id,cmbPaymentMode,cmbOrder_Date;
	  
	  JButton btnSave ;
	  
	  public OrderssForms() throws Exception
	  {
		  lblOrder_Id = new JLabel("Order Id");
		  lblCustomer_Id = new JLabel("Customer Id");
		  lblPaymentMode = new JLabel("Payment Mode");
		  lblTotal_Amount = new JLabel("Total amount");
		  lblBalance_Amount = new JLabel("Balance amount");
		  lblOrder_Date= new JLabel("Order Date");
		  lblOrder_Deliverydate = new JLabel("Delivery Date");
		  
		  txtOrder_Id = new JTextField(20);
		  txtTotal_Amount = new JTextField(20);
		  txtBalance_Amount = new JTextField(20);
		  txtOrder_Deliverydate = new JTextField(20);
		  
		  cmbCustomer_Id = new JComboBox();  
		  cmbPaymentMode = new JComboBox();  
		  cmbOrder_Date = new JComboBox();  
		  
		  cmbPaymentMode.addItem("Cash");
		  cmbPaymentMode.addItem("Credit Card");
		  cmbPaymentMode.addItem("Debit Card");
		  
		  cmbOrder_Date.addItem("2021-03-03");
		  cmbOrder_Date.addItem("2022-04-05");
			
		
		  btnSave=new JButton("Save");
		 
		  
			 
		  btnSave.addActionListener(this);  
		  
		  this.loadControls();
		  
		  ResultSet rs = OrderssDbOops.select();
		  
		  while(rs.next())
		  {
			  cmbCustomer_Id.addItem(rs.getInt(1));
			  
		  }
		  
	  }
	
		  
		  	  
	  
	  void loadControls()
	  {
		  
		  this.getContentPane().add(lblOrder_Id);
		  this.getContentPane().add(txtOrder_Id);
		  this.getContentPane().add(lblCustomer_Id);
		  this.getContentPane().add(cmbCustomer_Id);  
		  this.getContentPane().add(lblPaymentMode);
		  this.getContentPane().add(cmbPaymentMode);
		  this.getContentPane().add(lblTotal_Amount);
		  this.getContentPane().add(txtTotal_Amount);
		  this.getContentPane().add(lblBalance_Amount);
		  this.getContentPane().add(txtBalance_Amount);
		  this.getContentPane().add(lblOrder_Date);
		  this.getContentPane().add(cmbOrder_Date);
		  this.getContentPane().add(lblOrder_Deliverydate);
		  this.getContentPane().add(txtOrder_Deliverydate);
		  this.getContentPane().add(btnSave);
		  this.setSize(300,200);
		  this.setLayout(new FlowLayout());
		  this.setVisible(true);
		  
	  }
	  
	  public void actionPerformed(ActionEvent e) 
	  {
		 
		  int orderId = Integer.parseInt(txtOrder_Id.getText());
		  int totalAmount = Integer.parseInt(txtTotal_Amount.getText());
		  int balanceAmount = Integer.parseInt(txtBalance_Amount.getText());
		  Date deliveryDate = Date.valueOf(txtOrder_Deliverydate.getText());	 
		  int customerId = Integer.parseInt(cmbCustomer_Id.getSelectedItem().toString());
		  String paymentMode = cmbPaymentMode.getSelectedItem().toString();
		  Date orderDate = Date.valueOf(cmbOrder_Date.getSelectedItem().toString());
		
		  try
		  {
		    OrderssDbOops.insert(orderId,customerId,paymentMode,totalAmount, balanceAmount, orderDate, deliveryDate);
		  }
		  catch(Exception ex)
		  {		  
			  JOptionPane.showMessageDialog(null, ex.getMessage());
		  }
		  JOptionPane.showMessageDialog(null, "Saved");
	  }
	  
	

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		OrderssForms orform = new OrderssForms();


	}

}
