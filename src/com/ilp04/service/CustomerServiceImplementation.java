package com.ilp04.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ilp04.DAO.CustomerDAO;
import com.ilp04.entity.Customer;

public class CustomerServiceImplementation implements CustomerService {

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customerList = new ArrayList<Customer>();
		CustomerDAO customerDAO = new CustomerDAO();
		Connection connection = customerDAO.getConnection();
		customerList = customerDAO.getAllCustomers(connection);
		return customerList;
	}

	@Override
	public int insertIntoCustomer(Customer customer) {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAO();
		int i = customerDAO.insertIntoCustomer(customer);
		return i;
	}

    @Override
    public int updateCustomer(int customerCode, String newValue, String fieldName) {
        int result = 0;
        CustomerDAO customerDAO = new CustomerDAO();
        Connection connection = customerDAO.getConnection();
        try {
            String sql = "UPDATE customer SET " + fieldName + " = ? WHERE customer_code = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            if (fieldName.equals("phonenumber") || fieldName.equals("aadharno")) {
                statement.setLong(1, Long.parseLong(newValue));
            } else {
                statement.setString(1, newValue);
            }
            statement.setInt(2, customerCode);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            customerDAO.closeConnection(connection);
        }
        return result;
        // TODO Auto-generated method stub
        
    }


}

	

