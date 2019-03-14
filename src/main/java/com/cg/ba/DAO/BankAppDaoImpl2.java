package com.cg.ba.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.ba.DTO.TransactionDetails;

public class BankAppDaoImpl2 implements IBankAppDao2 {
	
static int bal1,bal2,bal3;
 int i;
	public int deposit(int accno,int amount) {
	 
		
		try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MYDATABASE","oracle");
			
			Statement statement = connection.createStatement();
			ResultSet resultset= statement.executeQuery("select * from customer_details ");
		 
			 while(resultset.next()) {
				 
				 if(resultset.getInt(1)==accno) {
					 
					 bal1 =resultset.getInt(10);
				 }
					 
			 }
			 
			 bal1+=amount;
			 PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customer_details SET balance=? where account_no=?");	
			 preparedStatement.setInt(1, bal1);
			 preparedStatement.setInt(2, accno);
			  i=preparedStatement.executeUpdate();
			 
				 System.out.println("Error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
	 		return i;
	}

	public int withdrawal(int accno,int amount) {
		
		try {
                           Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MYDATABASE","oracle");
			
			Statement statement = connection.createStatement();
			ResultSet resultset= statement.executeQuery("select * from customer_details ");
		 
			 while(resultset.next()) {
				 
				 if(resultset.getInt(1)==accno) {
					 
					 bal2 =resultset.getInt(10);
				 }
					 
			 }
			 
			 bal2-=amount;
			 PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customer_details SET balance=? where account_no=?");	
			 preparedStatement.setInt(1, bal2);
			 preparedStatement.setInt(2, accno);
			  i=preparedStatement.executeUpdate();
			 
				 System.out.println("Error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		return i;
	}

	public int showBalance( int accno) {
		
		
		try {
                           Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","MYDATABASE","oracle");
			
			Statement statement = connection.createStatement();
			ResultSet resultset= statement.executeQuery("select * from customer_details ");
		 
			 while(resultset.next()) {
				 
				 if(resultset.getInt(1)==accno) {
					 
					 bal3 =resultset.getInt(10);
				 }
					 
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return bal3;
	}

	public int transferFund(TransactionDetails td) {
		
		
		
	 
		return 0;
	}

}
