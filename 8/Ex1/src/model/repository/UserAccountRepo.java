package model.repository;

import model.entity.*;

import java.util.*;
import java.sql.*;

public class UserAccountRepo implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserAccountRepo() throws Exception {
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mahdikhosravani", "java123");
        connection.setAutoCommit (false);
    }

    public List<UserAccountEnti> select() throws Exception {
        preparedStatement = connection.prepareStatement ("select * from employee");
        ResultSet resultSet = preparedStatement.executeQuery ();
        List<UserAccountEnti> userAccountEntiList = new ArrayList<>();
        while(resultSet.next ()) {
            UserAccountEnti userAccountEnti = new UserAccountEnti();
            userAccountEnti.setName(resultSet.getString("name"));
            userAccountEnti.setUsername(resultSet.getString("username"));
            userAccountEnti.setPassword(resultSet.getString("password"));
            userAccountEnti.setEmail(resultSet.getString("email"));
            userAccountEntiList.add(userAccountEnti);
        }
        return userAccountEntiList;
    }

    public void commit() throws Exception{
        connection.commit ();
    }
    public void rollback() throws Exception{
        connection.rollback ();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close ();
        connection.close ();
    }
}
