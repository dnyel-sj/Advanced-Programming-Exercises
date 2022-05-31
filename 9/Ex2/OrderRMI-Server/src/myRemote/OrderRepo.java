package myRemote;

import java.sql.*;

public class OrderRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public OrderRepo() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mahdikhosravani", "java123");
    }

    public void insert(Order order) throws Exception {
        preparedStatement = connection.prepareStatement("insert into orders(customerName,foodName,price,trackingCode) values (?,?,?,?)");
        preparedStatement.setString(1,order.getCustomerName());
        preparedStatement.setString(2,order.getFoodName());
        preparedStatement.setLong(3,order.getPrice());
        preparedStatement.setLong(4,order.getPaymentTrackingCode());
        preparedStatement.executeUpdate();
    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
