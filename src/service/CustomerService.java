package service;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerService implements ICustomerService {
    private String url = "jdbc:mysql://localhost:3306/customer";
    private String user = "root";
    private String pass = "password";
    public static final String SELECT_ALL_CUSTOMER = "select * from customer";
    public static final String SAVE_CUSTOMER = "insert into customer  values(?, ? ,?, ?);";


    public Connection getConnection() {
        Connection connection = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public ArrayList<Customer> getCustomerList() {
        Connection connection = getConnection();
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet customerList = preparedStatement.executeQuery();
            while (customerList.next()) {
                String id = customerList.getString("id");
                String name = customerList.getString("name");
                String email = customerList.getString("email");
                String address = customerList.getString("address");
                customers.add(new Customer(id, name, email, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }

    public boolean saveCustomer(Customer customer) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CUSTOMER);
            preparedStatement.setString(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getAddress());
            return preparedStatement.executeUpdate() > 0 ? true : false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
