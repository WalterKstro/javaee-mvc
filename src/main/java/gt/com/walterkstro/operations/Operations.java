/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.walterkstro.operations;

import static gt.com.walterkstro.connection.Connect.getConnect;
import static gt.com.walterkstro.connection.Connect.close;
import gt.com.walterkstro.model.Customer;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author walter
 */
public class Operations {

    private static final String TABLE = "customers";
    private static final String QUERY_SELECT = MessageFormat.format("SELECT Customer_ID,Customer_FirstN,Customer_LastN,Customer_Email,Customer_Tel,Customer_Balance FROM {0}", Operations.TABLE);
    private static final String QUERY_FIND_ID = MessageFormat.format("SELECT Customer_ID,Customer_FirstN,Customer_LastN,Customer_Email,Customer_Tel,Customer_Balance FROM {0} WHERE Customer_ID = ?", Operations.TABLE);
    private static final String QUERY_INSERT = MessageFormat.format("INSERT INTO {0} (Customer_FirstN,Customer_LastN,Customer_Email,Customer_Tel,Customer_Balance) VALUES (?,?,?,?,?)", Operations.TABLE);
    private static final String QUERY_DELETE = MessageFormat.format("DELETE FROM {0} WHERE Customer_ID = ?", Operations.TABLE);
    private static final String QUERY_UPATE = MessageFormat.format("UPDATE {0} SET Customer_FirstN=?,Customer_LastN=?,Customer_Email=?,Customer_Tel=?,Customer_Balance=? WHERE Customer_ID = ?", Operations.TABLE);
    private static final String QUERY_TOTAL_BALANCE = MessageFormat.format("SELECT SUM(Customer_Balance) AS TOTAL FROM {0}", Operations.TABLE);

    public static String getTotalBalance() {
        var totalBalance = "0.00";
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        try {
            var conexion = getConnect();
            var statement = conexion.prepareStatement(Operations.QUERY_TOTAL_BALANCE);
            var result = statement.executeQuery();
            result.next();
            totalBalance = defaultFormat.format(result.getDouble(1));
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error in get total balance:  = " + ex.getMessage());
        }
        return totalBalance;
    }

    public static List<Customer> SELECT() {
        List<Customer> list = new ArrayList<>();
        try {
            var conexion = getConnect();
            var statement = conexion.prepareStatement(Operations.QUERY_SELECT);
            var results = statement.executeQuery();
            while (results.next()) {
                list.add(
                        new Customer(
                                results.getInt(1),
                                results.getString(2),
                                results.getString(3),
                                results.getString(4),
                                results.getString(5),
                                results.getDouble(6)
                        )
                );
            };
            close(results);
            close(statement);
            close(conexion);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error on list results:  = " + ex.getMessage());
        }
        return list;
    }

    public static Customer FIND(Customer customer) {
        try {
            var conexion = getConnect();
            var statement = conexion.prepareStatement(Operations.QUERY_FIND_ID);
            statement.setInt(1, customer.getCustomerID());
            var result = statement.executeQuery();
            /*Posicionarnos en el primer registro, es opcional*/
            result.next();
            customer.setCustomerID(result.getInt(1));
            customer.setCustomerFirstName(result.getString(2));
            customer.setCustomerLastName(result.getString(3));
            customer.setCustomerEmail(result.getString(4));
            customer.setCustomerPhone(result.getString(5));
            customer.setCustomerBalance(result.getDouble(6));

            close(result);
            close(statement);
            close(conexion);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error in find customer:  = " + ex.getMessage());
        }
        return customer;
    }

    public static int INSERT(Customer customer) {
        var rowAffected = 0;
        try {
            var conexion = getConnect();
            var statement = conexion.prepareStatement(Operations.QUERY_INSERT);
            statement.setString(1, customer.getCustomerFirstName());
            statement.setString(2, customer.getCustomerLastName());
            statement.setString(3, customer.getCustomerEmail());
            statement.setString(4, customer.getCustomerPhone());
            statement.setDouble(5, customer.getCustomerBalance());
            rowAffected = statement.executeUpdate();

            close(statement);
            close(conexion);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Error in insert a customer = " + e.getMessage());
        }
        return rowAffected;
    }

    public static int DELETE(Customer customer) {
        var rowAffected = 0;
        try {
            var conexion = getConnect();
            var statement = conexion.prepareStatement(Operations.QUERY_DELETE);
            statement.setInt(1, customer.getCustomerID());
            rowAffected = statement.executeUpdate();

            close(statement);
            close(conexion);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Error in delete one customer = " + e.getMessage());
        }
        return rowAffected;
    }

    public static int UPDATED(Customer customer) {
        var rowAffected = 0;
        try {
            var conexion = getConnect();
            var statement = conexion.prepareStatement(Operations.QUERY_UPATE);
            statement.setString(1, customer.getCustomerFirstName());
            statement.setString(2, customer.getCustomerLastName());
            statement.setString(3, customer.getCustomerEmail());
            statement.setString(4, customer.getCustomerPhone());
            statement.setDouble(5, customer.getCustomerBalance());
            statement.setDouble(6, customer.getCustomerID());

            rowAffected = statement.executeUpdate();

            close(statement);
            close(conexion);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Error on updated one customer = " + e.getMessage());
        }
        return rowAffected;
    }
}
