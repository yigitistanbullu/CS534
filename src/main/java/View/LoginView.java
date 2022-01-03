package View;
import Controller.UserController.User;
import Model.AuthorizationModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Dec 15 18:57:59 EET 2021
 */



/**
 * @author Zeliha Aydın
 */
public class LoginView extends JFrame {
    public LoginView() {
        initComponents();
    }
    private void login(ActionEvent e) {
        if(AuthorizationModel.logIn(emailField.getText(),passwordField.getText())){
            if(AuthorizationModel.getUserType(emailField.getText(),passwordField.getText()) == 0){
                this.dispose();
                StudentsHomePage studentsHomePage = new StudentsHomePage(AuthorizationModel.getUserId(emailField.getText(),passwordField.getText()),AuthorizationModel.getName(AuthorizationModel.getUserId(emailField.getText(),passwordField.getText())),AuthorizationModel.getUserExamId(emailField.getText(),passwordField.getText()));
                studentsHomePage.setVisible(true);
            }
            else if(AuthorizationModel.getUserType(emailField.getText(),passwordField.getText()) == 1){
                this.dispose();
                TeachersHomePage teachersHomePage = new TeachersHomePage(AuthorizationModel.getUserId(emailField.getText(),passwordField.getText()),AuthorizationModel.getName(AuthorizationModel.getUserId(emailField.getText(),passwordField.getText())),AuthorizationModel.getUserExamId(emailField.getText(),passwordField.getText()));
                teachersHomePage.setVisible(true);
            }
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(),"Your E-mail or Password is Wrong.","Dialog",JOptionPane.ERROR_MESSAGE);
            emailField.setText("");
            passwordField.setText("");
        }
    }

    private void register(ActionEvent e) {
        this.dispose();
        RegisterView registerView = new RegisterView();
        registerView.setLocationRelativeTo(null);
        registerView.setVisible(true);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        panel1 = new JPanel();
        loginText = new JLabel();
        emailField = new JTextField();
        loginButton = new JButton();
        emailLabel = new JLabel();
        passLabel = new JLabel();
        label2 = new JLabel();
        passwordField = new JPasswordField();
        registerButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(113, 188, 255));
            panel1.setForeground(Color.white);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
            . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing
            .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
            Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
            ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
            public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName (
            ) ) )throw new RuntimeException( ) ;} } );

            //---- loginText ----
            loginText.setText("Login");
            loginText.setFont(new Font("Roboto Thin", Font.BOLD, 48));
            loginText.setForeground(Color.white);

            //---- emailField ----
            emailField.setBackground(Color.white);

            //---- loginButton ----
            loginButton.setText("Login");
            loginButton.setBackground(new Color(113, 188, 255));
            loginButton.setForeground(Color.white);
            loginButton.setFont(new Font("Roboto Light", Font.BOLD, 16));
            loginButton.addActionListener(e -> login(e));

            //---- emailLabel ----
            emailLabel.setText("Email");
            emailLabel.setForeground(Color.white);

            //---- passLabel ----
            passLabel.setText("Password");
            passLabel.setForeground(Color.white);

            //---- label2 ----
            label2.setText("CS434 Exam Portal");
            label2.setForeground(Color.white);

            //---- passwordField ----
            passwordField.setBackground(Color.white);

            //---- registerButton ----
            registerButton.setText("Register");
            registerButton.setBackground(new Color(113, 188, 255));
            registerButton.setForeground(Color.white);
            registerButton.setFont(new Font("Roboto Light", Font.BOLD, 16));
            registerButton.addActionListener(e -> register(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label2)
                                .addContainerGap(789, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGap(0, 275, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                            .addComponent(loginText)
                                            .addGap(413, 413, 413))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                            .addComponent(emailLabel)
                                            .addGap(600, 600, 600)))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(passLabel)
                                            .addComponent(emailField, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                            .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                                        .addContainerGap())))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 425, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2)
                        .addGap(79, 79, 79)
                        .addComponent(loginText)
                        .addGap(20, 20, 20)
                        .addComponent(emailLabel)
                        .addGap(11, 11, 11)
                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(passLabel)
                        .addGap(18, 18, 18)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(138, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JLabel loginText;
    private JTextField emailField;
    private JButton loginButton;
    private JLabel emailLabel;
    private JLabel passLabel;
    private JLabel label2;
    private JPasswordField passwordField;
    private JButton registerButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
