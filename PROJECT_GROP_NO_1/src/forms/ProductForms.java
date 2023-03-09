package forms;

import Datebase.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class ProductForms extends JFrame implements ActionListener 
{
	JLabel lblProduct_Id , lblProduct_Name, lblPrice, lblOpeningStock;
	JTextField txtProduct_Id, txtProduct_Name, txtPrice,txtOpeningStock;
	JButton btnSave;
	
	  public ProductForms() throws Exception
	  {
		  lblProduct_Id= new JLabel("Product Id");
		  lblProduct_Name= new JLabel("Product Name");
		  lblPrice= new JLabel("Price");
		  lblOpeningStock= new JLabel("Opening Stock");
		  
		  
		  txtProduct_Id = new JTextField(20);
		  txtProduct_Name = new JTextField(20);
		  txtPrice = new JTextField(20);
		  txtOpeningStock = new JTextField(20);
		  
		  
		 
		  
		  btnSave = new JButton("Save");
		  btnSave.addActionListener(this);
		  
		  this.loadControls();
		  
	  }
	  void loadControls()
	  {
		  
		  this.getContentPane().add(lblProduct_Id);
		  this.getContentPane().add(txtProduct_Id);
		  this.getContentPane().add(lblProduct_Name);
		  this.getContentPane().add(txtProduct_Name);
		  this.getContentPane().add(lblPrice);
		  this.getContentPane().add(txtPrice);
		  this.getContentPane().add(lblOpeningStock);
		  this.getContentPane().add(txtOpeningStock);
		  this.getContentPane().add(btnSave);
		  this.setSize(300,200);
		  this.setLayout(new FlowLayout());
		  this.setVisible(true);
		  
	  }
		  
		  public void actionPerformed(ActionEvent e) 
		  {
			  int productid = Integer.parseInt(txtProduct_Id.getText());
			  String productName = txtProduct_Name.getText();
			  int price = Integer.parseInt(txtPrice.getText());
			  int openingStock = Integer.parseInt(txtOpeningStock.getText());
			  
			  try
			  {
				 ProductDbOops.insert(productid, productName, price, openingStock);
				  
			  }
			  catch(Exception ex) {
				  JOptionPane.showMessageDialog(null, ex.getMessage());
			  }
			  JOptionPane.showConfirmDialog(null, "Saved");
		  }




	public static void main(String[] args)  throws Exception {
		
		ProductForms oforms = new ProductForms();

	}

}
