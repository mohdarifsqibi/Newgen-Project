package forms;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Datebase.OrderdetailssDbOops;
import Datebase.OrderssDbOops;

public class OrderdetailssForms  extends JFrame implements ActionListener 
{
	JLabel lblOrder_Id , lblProduct_Id, lblQtySold, lblSalesPrice;
	JTextField txtQtySold,  txtSalesPrice;
    JComboBox cmbOrder_Id,cmbProduct_Id;
	JButton btnSave;
	
	  public OrderdetailssForms() throws Exception
	  {
		  lblOrder_Id = new JLabel("Order Id");
		  lblProduct_Id= new JLabel("Product Id");
		  lblQtySold= new JLabel("QtySold");
		  lblSalesPrice= new JLabel("Price");
		
		  
		  
		  
		  txtQtySold = new JTextField(20);
		  txtSalesPrice = new JTextField(20);
		  
		  cmbOrder_Id = new JComboBox();  
		  cmbProduct_Id = new JComboBox();  
		  
		 cmbProduct_Id.addItem(1);
		
 
		  
	
		  
		  
		 
		  
		  btnSave = new JButton("Save");
		  btnSave.addActionListener(this);
		  

		  this.loadControls();
		  
		  ResultSet rs = OrderdetailssDbOops.select();
	
		  
		  while(rs.next())
		  {
			  cmbOrder_Id.addItem(rs.getInt(1));
		  }
			
		
			  
		  
	
	
	
	
		  
		  
	  }
		  
		  void loadControls()
		  {
			  
			  this.getContentPane().add(lblOrder_Id);
			  this.getContentPane().add(cmbOrder_Id);
			  this.getContentPane().add(lblProduct_Id);
			  this.getContentPane().add(cmbProduct_Id);  
			  this.getContentPane().add(lblQtySold);
			  this.getContentPane().add(txtQtySold);
			  this.getContentPane().add(lblSalesPrice);
			  this.getContentPane().add(txtSalesPrice);
			  this.getContentPane().add(btnSave);
			  this.setSize(300,200);
			  this.setLayout(new FlowLayout());
			  this.setVisible(true);
			  
		  }
		  
		  public void actionPerformed(ActionEvent e) 
		  {
			 
			  int orderId = Integer.parseInt(cmbOrder_Id.getSelectedItem().toString());
			  int productId = Integer.parseInt(cmbProduct_Id.getSelectedItem().toString());
			  float qtySold = Float.parseFloat(txtQtySold.getText());
			  int salesPrice = Integer.parseInt(txtSalesPrice.getText());
			 
			
			  try
			  {
			   OrderdetailssDbOops.insert(orderId, productId, qtySold, salesPrice);
			  }
			  catch(Exception ex)
			  {		  
				  JOptionPane.showMessageDialog(null, ex.getMessage());
			  }
			  JOptionPane.showMessageDialog(null, "Saved");
		  }
		  
	 
		  
	  

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		OrderdetailssForms dform = new OrderdetailssForms();

	}

}
