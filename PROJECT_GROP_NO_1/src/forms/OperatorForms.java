package forms;

import Datebase.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


import java.sql.*;






public class OperatorForms extends JFrame implements ActionListener 
{
	JLabel lblOperator_Id , lblOperator_Name, lblUser_Phonenumber, lblPassword;
	JTextField txtOperator_Id, txtOperator_Name, txtUser_Phonenumber,txtPassword;
	JButton btnSave;
	
	  public OperatorForms() throws Exception
	  {
		  lblOperator_Id= new JLabel("Operator_Id");
		  lblOperator_Name= new JLabel("Operator_Name");
		  lblUser_Phonenumber= new JLabel("User_Phonenumber");
		  lblPassword= new JLabel("User_Password");
		  
		  
		  txtOperator_Id = new JTextField(20);
		  txtOperator_Name = new JTextField(20);
		  txtUser_Phonenumber = new JTextField(20);
		  txtPassword = new JTextField(20);
		  
		  
		 
		  
		  btnSave = new JButton("Save");
		  btnSave.addActionListener(this);
		  
		  this.loadControls();

}
	  public void actionPerformed(ActionEvent e) 
	  {
		  String  operatorId = txtOperator_Id.getText();
		  String operatorName = txtOperator_Name.getText();
		  String userPhonenumber = txtUser_Phonenumber.getText();
		  String UserPassword = txtPassword.getText();
		  try
		  {
			  OperatorDbOops.insert(operatorId, operatorName, userPhonenumber, UserPassword);
			  
		  }
		  catch(Exception ex) {
			  JOptionPane.showMessageDialog(null, ex.getMessage());
		  }
		  JOptionPane.showConfirmDialog(null, "Saved");
	  }
	  void loadControls()
	  {
		  this.getContentPane().add(lblOperator_Id);
		  this.getContentPane().add(txtOperator_Id);
		  this.getContentPane().add(lblOperator_Name);
		  this.getContentPane().add(txtOperator_Name);
		  this.getContentPane().add(lblUser_Phonenumber);
		  this.getContentPane().add(txtUser_Phonenumber);
		  this.getContentPane().add(lblPassword);
		  this.getContentPane().add(txtPassword);
		  this.getContentPane().add(btnSave);
		  this.setSize(300, 200);
		  this.setLayout(new FlowLayout());
		  this.setVisible(true);
		  
		  
	  }

public static void main(String[] args) throws Exception 
{
   OperatorForms opform =new OperatorForms();

}

}
