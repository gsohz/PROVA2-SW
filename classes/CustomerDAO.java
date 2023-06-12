/*
 * Gabriel Ferreira de Souza
 * Guilherme Ferreira Santos
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public CustomerDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertCustomer(Customer customer) throws SQLException {
        String sql;
        Integer id = customer.getId();
        Integer idSalesman = customer.getIdSalesman();
        if(id == null && idSalesman == null) {
            sql = "INSERT INTO customer (name, city, grade) VALUES (?, ?, ?)";
        } else if (id != null && idSalesman == null) {
            sql = "INSERT INTO customer (id_customer, name, city, grade) VALUES (?, ?, ?, ?)";
        } else if (id == null && idSalesman != null) {
            sql = "INSERT INTO customer (name, city, grade, id_salesman) VALUES (?, ?, ?, ?)";
        } else if (id != null && idSalesman != null) {
            sql = "INSERT INTO customer (id_customer, name, city, grade, id_salesman) VALUES (?, ?, ?, ?, ?)";
        }
            connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        if(id == null && idSalesman == null){
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getCity());
            statement.setFloat(3, customer.getGrade());
        } else if (id != null && idSalesman == null) {
            statement.setInt(1, customer.getId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getCity());
            statement.setFloat(4, customer.getGrade());
        } else if (id == null && idSalesman != null){
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getCity());
            statement.setFloat(3, customer.getGrade());
            statement.setFloat(4, customer.getIdSalesman());
        } else if(id != null && idSalesman != null){
            statement.setInt(1, customer.getId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getCity());
            statement.setFloat(4, customer.getGrade());
            statement.setFloat(5, customer.getIdSalesman());
        }
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Customer> listAllCustomers() throws SQLException {
        List<Customer> listCustomer = new ArrayList<>();
         
        String sql = "SELECT * FROM customer";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id_customer");
            String name = resultSet.getString("name");
            String city = resultSet.getString("city");
            int grade = resultSet.getInt("grade");
            int id_salesman = resultSet.getInt("id_salesman");
             
            Customer customer = new Customer(id, name, city, grade, id_salesman);
            listCustomer.add(customer);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listCustomer;
    }
     
    public boolean deleteCustomer(Customer customer) throws SQLException {
        String sql = "DELETE FROM customer where id_customer = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, customer.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateCustomer(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET name = ?, city = ?, grade = ?, id_salesman = ?";
        sql += " WHERE id_customer = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getCity());
        statement.setFloat(3, customer.getGrade());
        statement.setInt(4, customer.getIdSalesman());
        statement.setInt(5, customer.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Customer getCustomer(int id) throws SQLException {
        Customer customer = null;
        String sql = "SELECT * FROM customer WHERE id_customer = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String city = resultSet.getString("city");
            int grade = resultSet.getInt("grade");
            int id_salesman = resultSet.getInt("id_salesman");
             
            customer = new Customer(id, name, city, grade, id_salesman);
        }
         
        resultSet.close();
        statement.close();
         
        return customer;
    }
}
