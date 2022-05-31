package com.kiau;

import java.sql.*;

public class User implements AutoCloseable {
    private String name;
    private String username;
    private String password;
    private String email;
    private Connection connection;
    private PreparedStatement preparedStatement;

    public User() {

    }

    public User(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public void connection() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mahdikhosravani", "java123");
        connection.setAutoCommit(false);
    }

    public void insert() throws Exception {
        preparedStatement = connection.prepareStatement("insert into userinformation(name,username,password,email) values (?,?,?,?)");
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,username);
        preparedStatement.setString(3,password);
        preparedStatement.setString(4,email);
        preparedStatement.executeUpdate();
        System.out.println("insert successfully");
    }

    public void select() throws Exception {
        Thread.sleep(30000);
        preparedStatement = connection.prepareStatement("select * from userinformation");
        ResultSet resultSet = preparedStatement.executeQuery();
        int i = 1;
        while(resultSet.next()) {
            System.out.println(i + "th user information:");
            System.out.println("name is: " + resultSet.getString("name"));
            System.out.println("username is: " + resultSet.getString("username"));
            System.out.println("password is: " + resultSet.getString("password"));
            System.out.println("email is: " + resultSet.getString("email"));
            i++;
        }
    }

    public void commit() throws Exception {
        connection.commit();
    }
    public void rollback() throws Exception {
        connection.rollback();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
