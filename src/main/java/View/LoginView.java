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

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(182, 142, 185));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
            new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn"
            , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 )
            , java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

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

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2)
                        .addContainerGap(509, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(226, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(loginText))
                            .addComponent(emailField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(emailLabel)
                            .addComponent(passLabel)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(loginButton))
                            .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
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
                        .addComponent(loginButton)
                        .addContainerGap(65, Short.MAX_VALUE))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
