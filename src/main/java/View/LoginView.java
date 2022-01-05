package View;
import Controller.UserController.User;
import Model.AuthorizationModel;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout;

public class LoginView extends JFrame {
    public LoginView() {
        initComponents();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/main/java/View/Images/ou_logo_ing_white.png"));
            Image ozuLogo = img.getScaledInstance(ozuIconLabel.getWidth(),ozuIconLabel.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(ozuLogo);
            ozuIconLabel.setIcon(imageIcon);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void login(ActionEvent e) {
        if(AuthorizationModel.logIn(emailField.getText(),passwordField.getText())){
            if(AuthorizationModel.getUserType(emailField.getText(),passwordField.getText()) == 0){
                this.dispose();
                StudentsHomePage studentsHomePage = new StudentsHomePage(AuthorizationModel.getUserId(emailField.getText(),passwordField.getText()),AuthorizationModel.getName(AuthorizationModel.getUserId(emailField.getText(),passwordField.getText())));
                studentsHomePage.setVisible(true);
            }
            else if(AuthorizationModel.getUserType(emailField.getText(),passwordField.getText()) == 1){
                this.dispose();
                TeachersHomePage teachersHomePage = new TeachersHomePage(AuthorizationModel.getUserId(emailField.getText(),passwordField.getText()),AuthorizationModel.getName(AuthorizationModel.getUserId(emailField.getText(),passwordField.getText())));
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
        ozuIconLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(103, 137, 171));
            panel1.setMinimumSize(new Dimension(893, 576));
            panel1.setPreferredSize(new Dimension(893, 576));
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
            javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax
            . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
            . awt .Font ( "Dialo\u0067", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .
            PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "borde\u0072" .
            equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //---- loginText ----
            loginText.setText("Login");
            loginText.setFont(new Font("Roboto", Font.PLAIN, 48));
            loginText.setForeground(Color.white);

            //---- emailField ----
            emailField.setBackground(Color.white);

            //---- loginButton ----
            loginButton.setText("Login");
            loginButton.setFont(new Font("Roboto Light", Font.PLAIN, 14));
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
            registerButton.setFont(new Font("Roboto Light", Font.PLAIN, 14));
            registerButton.addActionListener(e -> register(e));

            //---- ozuIconLabel ----
            ozuIconLabel.setText("text");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(label2)
                        .addContainerGap(829, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(390, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(emailLabel)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(emailField)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(registerButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(passLabel))
                                .addGap(373, 373, 373))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(loginText)
                                .addGap(414, 414, 414))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(ozuIconLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addGap(408, 408, 408))))
            );
            panel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {loginButton, registerButton});
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(label2)
                        .addGap(62, 62, 62)
                        .addComponent(loginText)
                        .addGap(30, 30, 30)
                        .addComponent(emailLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(passLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registerButton)
                        .addGap(52, 52, 52)
                        .addComponent(ozuIconLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(56, Short.MAX_VALUE))
            );
            panel1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {loginButton, registerButton});
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
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
    private JLabel ozuIconLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
