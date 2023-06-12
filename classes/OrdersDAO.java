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
import java.sql.Date;

public class OrdersDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public OrdersDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

    public boolean insertOrders(Orders orders) throws SQLException {
        String sql = "INSERT INTO orders (id_orders, purch_amt, ord_date, id_customer, id_salesman) VALUES (?, ?, ?, ?, ?)";
        
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);

        
        statement.setInt(1, orders.getId());
        statement.setFloat(2, orders.getPurchAmt());
        statement.setDate(3, orders.getOrdDate());
        statement.setInt(4, orders.getIdCustomer());
        statement.setInt(5, orders.getIdSalesman());
        
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Orders> listAllOrders() throws SQLException {
        List<Orders> listOrders = new ArrayList<>();
         
        String sql = "SELECT * FROM orders";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id_orders");
            float purch_amt = resultSet.getFloat("purch_amt");
            Date ord_date = resultSet.getDate("ord_date");
            int id_customer = resultSet.getInt("id_customer");
            int id_salesman = resultSet.getInt("id_salesman");
             
            Orders orders = new Orders(id, purch_amt, ord_date, id_customer, id_salesman);
            listOrders.add(orders);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listOrders;
    }
     
    public boolean deleteOrders(Orders orders) throws SQLException {
        String sql = "DELETE FROM orders where id_orders = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, orders.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateOrders(Orders orders) throws SQLException {
        String sql = "UPDATE orders SET punch_amt = ?, ord_date = ?, id_customer = ?, id_salesman = ?";
        sql += " WHERE id_orders = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setFloat(1, orders.getPurchAmt());
        statement.setDate(2, orders.getOrdDate());
        statement.setInt(3, orders.getIdCustomer());
        statement.setInt(4, orders.getIdSalesman());
        statement.setInt(5, orders.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Orders getOrders(int id) throws SQLException {
        Orders orders = null;
        String sql = "SELECT * FROM orders WHERE id_orders = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            float purch_amt = resultSet.getFloat("purch_amt");
            Date ord_date = resultSet.getDate("ord_date");
            int id_customer = resultSet.getInt("id_customer");
            int id_salesman = resultSet.getInt("id_salesman");
             
            orders = new Orders(id, purch_amt, ord_date, id_customer, id_salesman);
        }
         
        resultSet.close();
        statement.close();
         
        return orders;
    }
}
