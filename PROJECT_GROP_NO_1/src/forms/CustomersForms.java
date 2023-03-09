package forms;
import Datebase.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class CustomersForms extends JFrame implements ActionListener 
{
	JLabel lblCustomerId , lblCustomerName, lblHomeAddress, lblCity,lblMobileno;
	JTextField txtCustomerId, txtCustomerName, txtHomeAddress,txtCity,txtMobileno;
	JButton btnSave;
	
	  public CustomersForms() throws Exception
	  {
		  lblCustomerId= new JLabel("CustomerId");
		  lblCustomerName= new JLabel("CustomerName");
		  lblHomeAddress= new JLabel("HomeAddress");
		  lblCity= new JLabel("City");
		  lblMobileno= new JLabel("Mobileno");
		  
		  
		  txtCustomerId = new JTextField(20);
		  txtCustomerName = new JTextField(20);
		  txtHomeAddress = new JTextField(20);
		  txtCity = new JTextField(20);
		  txtMobileno = new JTextField(20);
		  
		 
		  
		  btnSave = new JButton("Save");
		  btnSave.addActionListener(this);
		  
		  this.loadControls();
	
}
	  public void actionPerformed(ActionEvent e) 
	  {
		  int customerId = Integer.parseInt(txtCustomerId.getText());
		  String customerName = txtCustomerName.getText();
		  String homeaddress = txtHomeAddress.getText();
		  String city = txtCity.getText();
		  String mobileno = txtMobileno.getText();
		  try
		  {
		     CustomersDbOops.insert(customerId, customerName, homeaddress, city, mobileno);
			  
		  }
		  catch(Exception ex) {
			  JOptionPane.showMessageDialog(null, ex.getMessage());
		  }
		  JOptionPane.showConfirmDialog(null, "Saved");
	  }
	  void loadControls()
	  {
		  this.getContentPane().add(lblCustomerId);
		  this.getContentPane().add(txtCustomerId);
		  this.getContentPane().add(lblCustomerName);
		  this.getContentPane().add(txtCustomerName);
		  this.getContentPane().add(lblHomeAddress);
		  this.getContentPane().add(txtHomeAddress);
		  this.getContentPane().add(lblCity);
		  this.getContentPane().add(txtCity);
		  this.getContentPane().add(lblMobileno);
		  this.getContentPane().add(txtMobileno);
		  this.getContentPane().add(btnSave);
		  this.setSize(300, 200);
		  this.setLayout(new FlowLayout());
		  this.setVisible(true);
		  
		  
	  }
	  public static void main(String[] args) throws Exception 
	  {
	     CustomersForms cform =new CustomersForms();

	  }
}



	