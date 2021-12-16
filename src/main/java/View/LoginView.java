package View;
import java.awt.*;
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

    private void initComponents() {
        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yasemin
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
            panel1.setBackground(new Color(182, 142, 185));
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
            EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border.TitledBorder.CENTER,javax.swing
            .border.TitledBorder.BOTTOM,new java.awt.Font("Dialo\u0067",java.awt.Font.BOLD,12),
            java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener()
            {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("borde\u0072".equals(e.getPropertyName()))
            throw new RuntimeException();}});

            //---- loginText ----
            loginText.setText("Login");
            loginText.setFont(new Font("Roboto Thin", Font.PLAIN, 48));
            loginText.setForeground(Color.white);

            //---- emailField ----
            emailField.setBackground(Color.white);

            //---- loginButton ----
            loginButton.setText("Login");
            loginButton.setBackground(new Color(182, 142, 185));
            loginButton.setForeground(Color.white);
            loginButton.setFont(new Font("Roboto Light", Font.BOLD, 16));

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
            registerButton.setBackground(new Color(182, 142, 185));
            registerButton.setForeground(Color.white);
            registerButton.setFont(new Font("Roboto Light", Font.BOLD, 16));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2)
                        .addContainerGap(507, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(226, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(loginText))
                            .addComponent(emailLabel)
                            .addComponent(passLabel)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(emailField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(registerButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(loginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(207, 207, 207))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginText)
                        .addGap(41, 41, 41)
                        .addComponent(emailLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(passLabel)
                        .addGap(18, 18, 18)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registerButton)
                        .addContainerGap(30, Short.MAX_VALUE))
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
    // Generated using JFormDesigner Evaluation license - yasemin
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
