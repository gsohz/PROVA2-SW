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

public class SalesmanDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public SalesmanDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

    public boolean insertSalesman(Salesman salesman) throws SQLException {
        String sql = "INSERT INTO salesman (id_salesman, name, city, comission) VALUES (?, ?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, salesman.getId());
        statement.setString(2, salesman.getName());
        statement.setString(3, salesman.getCity());
        statement.setFloat(4, salesman.getComission());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Salesman> listAllSalesmans() throws SQLException {
        List<Salesman> listSalesman = new ArrayList<>();
         
        String sql = "SELECT * FROM salesman";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id_salesman");
            String name = resultSet.getString("name");
            String city = resultSet.getString("city");
            float comission = resultSet.getFloat("comission");
             
            Salesman salesman = new Salesman(id, name, city, comission);
            listSalesman.add(salesman);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listSalesman;
    }
     
    public boolean deleteSalesman(Salesman salesman) throws SQLException {
        String sql = "DELETE FROM salesman where id_salesman = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, salesman.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateSalesman(Salesman salesman) throws SQLException {
        String sql = "UPDATE salesman SET name = ?, city = ?, comission = ?";
        sql += " WHERE id_salesman = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, salesman.getName());
        statement.setString(2, salesman.getCity());
        statement.setFloat(3, salesman.getComission());
        statement.setInt(4, salesman.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Salesman getSalesman(int id) throws SQLException {
        Salesman salesman = null;
        String sql = "SELECT * FROM salesman WHERE id_salesman = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String city = resultSet.getString("city");
            float comission = resultSet.getFloat("comission");
             
            salesman = new Salesman(id, name, city, comission);
        }
         
        resultSet.close();
        statement.close();
         
        return salesman;
    }
}
