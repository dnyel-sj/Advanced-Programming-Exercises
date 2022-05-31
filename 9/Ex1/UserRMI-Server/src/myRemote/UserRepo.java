package myRemote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserRepo() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mahdikhosravani", "java123");
    }

    public void insert(User user) throws Exception {
        preparedStatement = connection.prepareStatement("insert into user_Account(name,username,password,email) values (?,?,?,?)");
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getUsername());
        preparedStatement.setString(3,user.getPassword());
        preparedStatement.setString(4,user.getEmail());
        preparedStatement.executeUpdate();
    }

    public void update(User user) throws Exception{
        preparedStatement = connection.prepareStatement("update user_Account set username = ?, password = ? where name = ?");
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3,user.getName());
        preparedStatement.executeUpdate();
    }

    public List<User> select() throws Exception {
        preparedStatement = connection.prepareStatement("select * from user_Account");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<>();
        while(resultSet.next()) {
            User user = new User();
            user.setName(resultSet.getString("name"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            userList.add(user);
        }
        return userList;
    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
