package model.repository;

import model.entity.*;

import java.sql.*;

public class EmploymentRepo implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public EmploymentRepo() throws Exception {
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mahdikhosravani", "java123");
        connection.setAutoCommit (false);
    }

    public void insert(EmploymentEnti employmentEnti) throws Exception {
        preparedStatement = connection.prepareStatement ("insert into employments(name, fatherName, id, educationLevel, studyField, phoneNumber, previousJob, workExperience) values (?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, employmentEnti.getName());
        preparedStatement.setString(2, employmentEnti.getFatherName());
        preparedStatement.setString(3, employmentEnti.getId());
        preparedStatement.setString(4, employmentEnti.getEducationLevel());
        preparedStatement.setString(5, employmentEnti.getStudyField());
        preparedStatement.setString(6, employmentEnti.getPhoneNumber());
        preparedStatement.setString(7, employmentEnti.getPreviousJob());
        preparedStatement.setInt(8, employmentEnti.getWorkExperience());
        preparedStatement.executeUpdate();
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
