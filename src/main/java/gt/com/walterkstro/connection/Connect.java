/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.walterkstro.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author walter
 */
public class Connect {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ctrl_customers?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "";
    private static final int MAX_CONNECTIONS = 5;
    
    public static DataSource getDataSource() {
        BasicDataSource pool = new BasicDataSource();
        pool.setUrl(Connect.JDBC_URL);
        pool.setUsername(Connect.JDBC_USERNAME);
        pool.setPassword(Connect.JDBC_PASSWORD);
        pool.setInitialSize(Connect.MAX_CONNECTIONS);
        pool.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return pool;
    }
    
    public static Connection getConnect() throws SQLException{       
        return Connect.getDataSource().getConnection();
    }
    
    public static void close(ResultSet result) throws SQLException{
        result.close();
    }
    public static void close(Statement statement) throws SQLException {
        statement.close();
    }
    public static void close(PreparedStatement statement) throws SQLException {
        statement.close();
    }
    public static void close(Connection connection) throws SQLException{
        connection.close();
    }
}
