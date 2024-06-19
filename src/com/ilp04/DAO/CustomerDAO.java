package com.ilp04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ilp04.entity.Customer;


public class CustomerDAO {
	
	public Connection getConnection() {
	//get COnnection
	String connectionURL="jdbc:mysql://localhost:3306/bankdb?useSSL=false";
	String userName ="root";
	String password="experion@123";
	Connection connection = null;
	
	try {
		connection = DriverManager.getConnection(connectionURL,userName,password);
	}
	catch(SQLException e){
		e.printStackTrace();
		
	}
	//close connection
	//get all the customer details
	return connection;
	}
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Customer> getAllCustomers(Connection connection) {
		Statement statement;
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customer");
				while(resultSet.next()) {
					int customercode = resultSet.getInt("customer_code");
	                String firstName = resultSet.getString("customer_firstname");
	                String lastName = resultSet.getString("customer_lastname");
	                String address = resultSet.getString("address");
	                long phonenumber = resultSet.getLong("phonenumber");
	                long aadhar_no= resultSet.getLong("aadhar_no");
	                Customer customer = new Customer(customercode,firstName,lastName,address,phonenumber,aadhar_no);
					customerList.add(customer);
				}
				

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerList;
	}
    public int insertIntoCustomer(Customer customer) {
		int i=0;
		CustomerDAO customerDAO = new CustomerDAO();
		Connection con = customerDAO.getConnection();
		try{
		PreparedStatement stmt=con.prepareStatement("insert into customer(customer_firstname,customer_lastname,address,phonenumber,aadhar_no) values(?,?,?,?,?)");

		stmt.setString(1,customer.getCustomerFirstname());
		stmt.setString(2,customer.getCustomerLastname());
		stmt.setString(3, customer.getAddress());
		stmt.setLong(4, customer.getPhoneNumber());
		stmt.setLong(5, customer.getAadharNo());

		i = stmt.executeUpdate();
		
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return i;
        // TODO Auto-generated method stub
        
    }
	
}