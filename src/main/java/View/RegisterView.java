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



/**
 * @author Zeliha Aydın
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
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        panel1 = new JPanel();
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

        //======== panel1 ========
        {
            panel1.setBackground(new Color(113, 188, 255));
            panel1.setForeground(Color.white);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
            ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
            .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
            propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
            ;} } );

            //---- registerText ----
            registerText.setText("Register");
            registerText.setForeground(Color.white);
            registerText.setFont(new Font("Roboto Light", Font.PLAIN, 48));
            registerText.setHorizontalAlignment(SwingConstants.CENTER);

            //---- nameField ----
            nameField.setBackground(Color.white);

            //---- surnameFiled ----
            surnameFiled.setBackground(Color.white);

            //---- emailFiled ----
            emailFiled.setBackground(Color.white);

            //---- studentIDField ----
            studentIDField.setBackground(Color.white);

            //---- teacherCheckbox ----
            teacherCheckbox.setText("Teacher");
            teacherCheckbox.setBackground(new Color(113, 188, 255));
            teacherCheckbox.setForeground(Color.white);
            teacherCheckbox.addActionListener(e -> teacher(e));

            //---- studentCheckbox ----
            studentCheckbox.setText("Student");
            studentCheckbox.setBackground(new Color(113, 188, 255));
            studentCheckbox.setForeground(Color.white);
            studentCheckbox.addActionListener(e -> {
			chkstudent(e);
			student(e);
		});

            //---- registerButton ----
            registerButton.setText("Register");
            registerButton.setForeground(Color.white);
            registerButton.setBackground(new Color(113, 188, 255));
            registerButton.addActionListener(e -> register(e));

            //---- label1 ----
            label1.setText("CS434 Exam Portal");
            label1.setForeground(Color.white);

            //---- label2 ----
            label2.setText("Name");
            label2.setForeground(Color.white);

            //---- label3 ----
            label3.setText("Surname");
            label3.setForeground(Color.white);

            //---- label4 ----
            label4.setText("Email");
            label4.setForeground(Color.white);

            //---- label5 ----
            label5.setText("Password");
            label5.setForeground(Color.white);

            //---- label6 ----
            label6.setText("Student ID");
            label6.setForeground(Color.white);

            //---- passwordField ----
            passwordField.setBackground(Color.white);

            //---- registerButton2 ----
            registerButton2.setText("Login");
            registerButton2.setForeground(Color.white);
            registerButton2.setBackground(new Color(113, 188, 255));
            registerButton2.addActionListener(e -> login(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(308, 308, 308)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label4)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(label5, GroupLayout.Alignment.LEADING)
                                        .addComponent(studentIDField, GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                            .addComponent(teacherCheckbox)
                                            .addGap(162, 162, 162)
                                            .addComponent(studentCheckbox))
                                        .addComponent(label6, GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordField, GroupLayout.Alignment.LEADING)
                                        .addComponent(emailFiled, GroupLayout.Alignment.LEADING)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label2))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(surnameFiled, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label3)))))))
                        .addContainerGap(296, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 335, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(registerButton2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                .addGap(403, 403, 403))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(registerText, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                .addGap(333, 333, 333))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1)
                        .addGap(19, 19, 19)
                        .addComponent(registerText)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(label3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(surnameFiled, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailFiled, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(studentIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(studentCheckbox)
                            .addComponent(teacherCheckbox))
                        .addGap(22, 22, 22)
                        .addComponent(registerButton2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(66, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
    private JPanel panel1;
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
