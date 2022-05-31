package view;

import controller.*;

import javax.swing.*;
import java.awt.event.*;

public class UserAccountView {
    private JFrame jFrame;
    private JDialog jDialog;

    public UserAccountView() {
        jFrame = new JFrame("Users sign in");
        jFrame.setSize(350, 400);
        JLabel lblWelcome = new JLabel("Welcome");
        lblWelcome.setBounds(140, 5, 70, 50);
        lblWelcome.setVisible(true);
        JButton btnLogin = new JButton("1");
        btnLogin.setBounds(30, 100, 45, 35);
        btnLogin.setVisible(true);
        JLabel lblLogin = new JLabel("Login");
        lblLogin.setBounds(85, 90, 70, 50);
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
        JLabel lblSignUp = new JLabel("Sign Up");
        lblSignUp.setBounds(85, 180, 70, 50);
        lblSignUp.setVisible(true);
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUp();
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
                        update(txtUsername.getText());
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

    public void signUp() {
        jDialog = new JDialog();
        jDialog.setTitle("Sign Up");
        jDialog.setSize(350, 400);
        JLabel lblName = new JLabel("Enter name:");
        lblName.setBounds(15, 30, 120, 30);
        lblName.setVisible(true);
        JTextField txtName = new JTextField();
        txtName.setBounds(115, 35, 180, 25);
        txtName.setVisible(true);
        JLabel lblUsername = new JLabel("Enter username:");
        lblUsername.setBounds(15, 80, 100, 30);
        lblUsername.setVisible(true);
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(115, 85, 180, 25);
        txtUsername.setVisible(true);
        JLabel lblPassword = new JLabel("Enter password:");
        lblPassword.setBounds(15, 130, 100, 30);
        lblPassword.setVisible(true);
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(115, 135, 180, 25);
        txtPassword.setVisible(true);
        JLabel lblEmail = new JLabel("Enter email:");
        lblEmail.setBounds(15, 180, 120, 30);
        lblEmail.setVisible(true);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(115, 185, 180, 25);
        txtEmail.setVisible(true);
        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(120, 260, 90, 45);
        btnSignUp.setVisible(true);
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtName.getText().equals("") || txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtEmail.getText().equals(""))
                    answer("Invalid Information");
                else {
                    try {
                        UserAccountCont.getInstance().insert(txtName.getText(), txtUsername.getText(), txtPassword.getText(), txtEmail.getText());
                        answer("Sign up successfully");
                        jDialog.dispose();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                }
            }
        });
        jDialog.add(lblName);
        jDialog.add(txtName);
        jDialog.add(lblUsername);
        jDialog.add(txtUsername);
        jDialog.add(lblPassword);
        jDialog.add(txtPassword);
        jDialog.add(lblEmail);
        jDialog.add(txtEmail);
        jDialog.add(btnSignUp);
        jDialog.setLocationRelativeTo(jFrame);
        jDialog.setLayout(null);
        jDialog.setVisible(true);
    }

    public void update(String username) {
        JDialog jDialog1 = new JDialog();
        jDialog.dispose();
        jDialog1.setTitle("Update Information");
        jDialog1.setSize(350, 400);
        JLabel lblName = new JLabel("Enter new name:");
        lblName.setBounds(10, 30, 140, 30);
        lblName.setVisible(true);
        JTextField txtName = new JTextField();
        txtName.setBounds(140, 35, 180, 25);
        txtName.setVisible(true);
        JLabel lblPassword = new JLabel("Enter new password:");
        lblPassword.setBounds(10, 90, 120, 30);
        lblPassword.setVisible(true);
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(140, 95, 180, 25);
        txtPassword.setVisible(true);
        JLabel lblEmail = new JLabel("Enter new email:");
        lblEmail.setBounds(10, 150, 140, 30);
        lblEmail.setVisible(true);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(140, 155, 180, 25);
        txtEmail.setVisible(true);
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(120, 250, 90, 45);
        btnUpdate.setVisible(true);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txtName.getText().equals("") || txtPassword.getText().equals("") || txtEmail.getText().equals(""))
                    answer("Invalid Information");
                else {
                    try {
                        UserAccountCont.getInstance().update(txtName.getText(), username, txtPassword.getText(), txtEmail.getText());
                        answer("Update successfully");
                        jDialog1.dispose();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                }
            }
        });
        jDialog1.add(lblName);
        jDialog1.add(txtName);
        jDialog1.add(lblPassword);
        jDialog1.add(txtPassword);
        jDialog1.add(lblEmail);
        jDialog1.add(txtEmail);
        jDialog1.add(btnUpdate);
        jDialog1.setLocationRelativeTo(jFrame);
        jDialog1.setLayout(null);
        jDialog1.setVisible(true);
    }

    public void answer(String answer) {
        JDialog jDialog2 = new JDialog();
        jDialog2.setTitle("Answer");
        jDialog2.setSize(220, 100);
        JLabel lblAnswer = new JLabel();
        lblAnswer.setText(answer);
        lblAnswer.setBounds(5, 10, 200, 40);
        lblAnswer.setVisible(true);
        jDialog2.add(lblAnswer);
        jDialog2.setLocationRelativeTo(jFrame);
        jDialog2.setLayout(null);
        jDialog2.setVisible(true);
    }
}
