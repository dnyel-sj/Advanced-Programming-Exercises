package view;

import controller.*;

import javax.swing.*;
import java.awt.event.*;

public class CompanyView {
    private JFrame jFrame;
    private JDialog jDialog;

    public CompanyView() {
        jFrame = new JFrame("Company");
        jFrame.setSize(350, 400);
        JLabel lblWelcome = new JLabel("Welcome");
        lblWelcome.setBounds(140, 5, 70, 50);
        lblWelcome.setVisible(true);
        JButton btnLogin = new JButton("1");
        btnLogin.setBounds(30, 100, 45, 35);
        btnLogin.setVisible(true);
        JLabel lblLogin = new JLabel("Employees Login");
        lblLogin.setBounds(85, 90, 150, 50);
        lblLogin.setVisible(true);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        JButton btnSignUp = new JButton("2");
        btnSignUp.setBounds(30, 190, 45, 35);
        btnSignUp.setVisible(true);
        JLabel lblSignUp = new JLabel("Employment");
        lblSignUp.setBounds(85, 180, 70, 50);
        lblSignUp.setVisible(true);
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employment();
            }
        });
        jFrame.add(lblWelcome);
        jFrame.add(btnLogin);
        jFrame.add(lblLogin);
        jFrame.add(btnSignUp);
        jFrame.add(lblSignUp);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    public void login() {
        jDialog = new JDialog();
        jDialog.setTitle("Login");
        jDialog.setSize(350, 400);
        JLabel lblUsername = new JLabel("Enter username:");
        lblUsername.setBounds(15, 80, 100, 30);
        lblUsername.setVisible(true);
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(115, 85, 180, 25);
        txtUsername.setVisible(true);
        JLabel lblPassword = new JLabel("Enter password:");
        lblPassword.setBounds(15, 160, 100, 30);
        lblPassword.setVisible(true);
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(115, 165, 180, 25);
        txtPassword.setVisible(true);
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(130, 260, 70, 45);
        btnLogin.setVisible(true);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(UserAccountCont.getInstance().select(txtUsername.getText(), txtPassword.getText())) {
                        answer("Login successfully");
                        jDialog.dispose();
                    }
                    else
                        answer("Invalid username or password");
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });
        jDialog.add(lblUsername);
        jDialog.add(txtUsername);
        jDialog.add(lblPassword);
        jDialog.add(txtPassword);
        jDialog.add(btnLogin);
        jDialog.setLocationRelativeTo(jFrame);
        jDialog.setLayout(null);
        jDialog.setVisible(true);
    }

    public void employment() {
        jDialog = new JDialog();
        jDialog.setTitle("Employment Form");
        jDialog.setSize(500, 600);
        JLabel lblName = new JLabel("Enter name:");
        lblName.setBounds(15, 50, 140, 30);
        lblName.setVisible(true);
        JTextField txtName = new JTextField();
        txtName.setBounds(160, 55, 180, 25);
        txtName.setVisible(true);
        JLabel lblFatherName = new JLabel("Enter father name:");
        lblFatherName.setBounds(15, 100, 140, 30);
        lblFatherName.setVisible(true);
        JTextField txtFatherName = new JTextField();
        txtFatherName.setBounds(160, 105, 180, 25);
        txtFatherName.setVisible(true);
        JLabel lblId = new JLabel("Enter id:");
        lblId.setBounds(15, 150, 140, 30);
        lblId.setVisible(true);
        JTextField txtId = new JTextField();
        txtId.setBounds(160, 155, 180, 25);
        txtId.setVisible(true);
        JLabel lblEducationLevel = new JLabel("Enter education level:");
        lblEducationLevel.setBounds(15, 200, 140, 30);
        lblEducationLevel.setVisible(true);
        JTextField txtEducationLevel = new JTextField();
        txtEducationLevel.setBounds(160, 205, 180, 25);
        txtEducationLevel.setVisible(true);
        JLabel lblStudyField = new JLabel("Enter study field:");
        lblStudyField.setBounds(15, 250, 140, 30);
        lblStudyField.setVisible(true);
        JTextField txtStudyField = new JTextField();
        txtStudyField.setBounds(160, 255, 180, 25);
        txtStudyField.setVisible(true);
        JLabel lblPhoneNumber = new JLabel("Enter phone number:");
        lblPhoneNumber.setBounds(15, 300, 140, 30);
        lblPhoneNumber.setVisible(true);
        JTextField txtPhoneNumber = new JTextField();
        txtPhoneNumber.setBounds(160, 305, 180, 25);
        txtPhoneNumber.setVisible(true);
        JLabel lblPreviousJob = new JLabel("Enter previous job:");
        lblPreviousJob.setBounds(15, 350, 140, 30);
        lblPreviousJob.setVisible(true);
        JTextField txtPreviousJob = new JTextField();
        txtPreviousJob.setBounds(160, 355, 180, 25);
        txtPreviousJob.setVisible(true);
        JLabel lblWorkExperience = new JLabel("Enter work experience:");
        lblWorkExperience.setBounds(15, 400, 140, 30);
        lblWorkExperience.setVisible(true);
        JTextField txtWorkExperience = new JTextField();
        txtWorkExperience.setBounds(160, 405, 180, 25);
        txtWorkExperience.setVisible(true);
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(200, 480, 90, 50);
        btnSubmit.setVisible(true);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtName.getText().equals("") || txtFatherName.getText().equals("") || txtId.getText().equals("") || txtEducationLevel.getText().equals("") ||
                        txtStudyField.getText().equals("") || txtPhoneNumber.getText().equals("") || txtPreviousJob.getText().equals("") || txtWorkExperience.getText().equals(""))
                    answer("Invalid Information");
                else {
                    try {
                        EmploymentCont.getInstance().insert(txtName.getText(), txtFatherName.getText(), txtId.getText(), txtEducationLevel.getText(), txtStudyField.getText(), txtPhoneNumber.getText(), txtPreviousJob.getText(), Integer.parseInt(txtWorkExperience.getText()));
                        answer("Submit successfully");
                        jDialog.dispose();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                }
            }
        });
        jDialog.add(lblName);
        jDialog.add(txtName);
        jDialog.add(lblFatherName);
        jDialog.add(txtFatherName);
        jDialog.add(lblId);
        jDialog.add(txtId);
        jDialog.add(lblEducationLevel);
        jDialog.add(txtEducationLevel);
        jDialog.add(lblStudyField);
        jDialog.add(txtStudyField);
        jDialog.add(lblPhoneNumber);
        jDialog.add(txtPhoneNumber);
        jDialog.add(lblPreviousJob);
        jDialog.add(txtPreviousJob);
        jDialog.add(lblWorkExperience);
        jDialog.add(txtWorkExperience);
        jDialog.add(btnSubmit);
        jDialog.setLocationRelativeTo(jFrame);
        jDialog.setLayout(null);
        jDialog.setVisible(true);
    }

    public void answer(String answer) {
        JDialog jDialog1 = new JDialog();
        jDialog1.setTitle("Answer");
        jDialog1.setSize(220, 100);
        JLabel lblAnswer = new JLabel();
        lblAnswer.setText(answer);
        lblAnswer.setBounds(5, 10, 200, 40);
        lblAnswer.setVisible(true);
        jDialog1.add(lblAnswer);
        jDialog1.setLocationRelativeTo(jFrame);
        jDialog1.setLayout(null);
        jDialog1.setVisible(true);
    }
}
