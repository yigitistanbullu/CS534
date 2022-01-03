package View;
import Controller.UserController.Password;
import Controller.UserController.User;
import Model.AuthorizationModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Dec 15 18:36:24 EET 2021
 */

public class RegisterView extends JFrame {
    public RegisterView() {
        initComponents();
    }
    private void register(ActionEvent e) {
        int usertype = 0;
        if(teacherCheckbox.isSelected()){
            usertype = 1;
        }
        else{
            usertype = 0;
        }
        Password password = new Password(passwordField.getText());
        User user = new User(nameField.getText(), surnameFiled.getText(), emailFiled.getText(),password,Integer.parseInt(studentIDField.getText()), usertype) {
            @Override
            public String writeName(String name, String surname) {
                return name + surname;
            }
        };
        AuthorizationModel.addUser(user);
        JOptionPane.showMessageDialog(new JFrame(),"User Created Successfully","Dialog",JOptionPane.WARNING_MESSAGE);
        LoginView loginView = new LoginView();
        loginView.setLocationRelativeTo(this);
        loginView.setVisible(true);
        this.dispose();
    }

    private void login(ActionEvent e) {
        this.dispose();
        LoginView view = new LoginView();
        view.setLocationRelativeTo(this);
        view.setVisible(true);
    }


    private void teacher(ActionEvent e) {
        if (teacherCheckbox.isSelected()){
            studentCheckbox.setSelected(false);
        }
    }


    private void chkstudent(ActionEvent e) {
        if (studentCheckbox.isSelected()){
            teacherCheckbox.setSelected(false);
        }
    }

    private void student(ActionEvent e) {
        // TODO add your code here
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yasemin
        registerText = new JLabel();
        nameField = new JTextField();
        surnameFiled = new JTextField();
        emailFiled = new JTextField();
        studentIDField = new JTextField();
        teacherCheckbox = new JCheckBox();
        studentCheckbox = new JCheckBox();
        registerButton = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        passwordField = new JPasswordField();
        registerButton2 = new JButton();

        //======== this ========
        setBackground(new Color(182, 142, 185));
        setForeground(new Color(182, 142, 185));
        var contentPane = getContentPane();

        //---- registerText ----
        registerText.setText("Register");
        registerText.setForeground(Color.black);
        registerText.setFont(new Font("Roboto Light", Font.PLAIN, 48));
        registerText.setHorizontalAlignment(SwingConstants.CENTER);

        //---- teacherCheckbox ----
        teacherCheckbox.setText("Teacher");
        teacherCheckbox.addActionListener(e -> teacher(e));

        //---- studentCheckbox ----
        studentCheckbox.setText("Student");
        studentCheckbox.addActionListener(e -> {
			chkstudent(e);
			student(e);
		});

        //---- registerButton ----
        registerButton.setText("Register");
        registerButton.addActionListener(e -> register(e));

        //---- label1 ----
        label1.setText("CS434 Exam Portal");

        //---- label2 ----
        label2.setText("Name");

        //---- label3 ----
        label3.setText("Surname");

        //---- label4 ----
        label4.setText("Email");

        //---- label5 ----
        label5.setText("Password");

        //---- label6 ----
        label6.setText("Student ID");

        //---- registerButton2 ----
        registerButton2.setText("Login");
        registerButton2.addActionListener(e -> login(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                    .addGap(97, 97, 97)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(registerButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(registerButton2))
                        .addComponent(label6)
                        .addComponent(label5)
                        .addComponent(label4)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(teacherCheckbox)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentCheckbox))
                        .addComponent(registerText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailFiled)
                        .addComponent(studentIDField)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(99, 99, 99)))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(surnameFiled, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(passwordField))
                    .addContainerGap(233, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(registerText)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(surnameFiled, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(emailFiled, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label5)
                            .addGap(10, 10, 10)
                            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label6)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(studentIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(teacherCheckbox)
                                .addComponent(studentCheckbox))))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(registerButton)
                        .addComponent(registerButton2))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - yasemin
    private JLabel registerText;
    private JTextField nameField;
    private JTextField surnameFiled;
    private JTextField emailFiled;
    private JTextField studentIDField;
    private JCheckBox teacherCheckbox;
    private JCheckBox studentCheckbox;
    private JButton registerButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JPasswordField passwordField;
    private JButton registerButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
