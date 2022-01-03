package View;
import Controller.UserController.Password;
import Controller.UserController.User;
import Model.AuthorizationModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Dec 15 18:36:24 EET 2021
 */

public class RegisterView extends JFrame {
    public RegisterView() {
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
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        surnameFiled = new JTextField();
        nameField = new JTextField();
        registerText = new JLabel();
        emailFiled = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        passwordField = new JPasswordField();
        label6 = new JLabel();
        studentIDField = new JTextField();
        teacherCheckbox = new JCheckBox();
        studentCheckbox = new JCheckBox();
        registerButton2 = new JButton();
        registerButton = new JButton();
        label1 = new JLabel();
        ozuIconLabel = new JLabel();

        //======== this ========
        setBackground(new Color(102, 102, 102));
        setForeground(new Color(182, 142, 185));
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(103, 137, 171));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label2 ----
            label2.setText("Name");
            label2.setBackground(Color.white);
            label2.setForeground(Color.white);
            label2.setFont(new Font("Roboto", Font.PLAIN, 14));

            //---- label3 ----
            label3.setText("Surname");
            label3.setBackground(Color.white);
            label3.setForeground(Color.white);
            label3.setFont(new Font("Roboto", Font.PLAIN, 14));

            //---- registerText ----
            registerText.setText("Register");
            registerText.setForeground(Color.white);
            registerText.setFont(new Font("Roboto", Font.PLAIN, 48));
            registerText.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label4 ----
            label4.setText("Email");
            label4.setBackground(Color.white);
            label4.setForeground(Color.white);
            label4.setFont(new Font("Roboto", Font.PLAIN, 14));

            //---- label5 ----
            label5.setText("Password");
            label5.setBackground(Color.white);
            label5.setForeground(Color.white);
            label5.setFont(new Font("Roboto", Font.PLAIN, 14));

            //---- label6 ----
            label6.setText("Student ID");
            label6.setBackground(Color.white);
            label6.setForeground(Color.white);
            label6.setFont(new Font("Roboto", Font.PLAIN, 14));

            //---- teacherCheckbox ----
            teacherCheckbox.setText("Teacher");
            teacherCheckbox.setForeground(Color.white);
            teacherCheckbox.setFont(new Font("Roboto", Font.PLAIN, 14));
            teacherCheckbox.addActionListener(e -> teacher(e));

            //---- studentCheckbox ----
            studentCheckbox.setText("Student");
            studentCheckbox.setForeground(Color.white);
            studentCheckbox.setFont(new Font("Roboto", Font.PLAIN, 14));
            studentCheckbox.addActionListener(e -> {
			chkstudent(e);
			student(e);
		});

            //---- registerButton2 ----
            registerButton2.setText("Cancel");
            registerButton2.setFont(new Font("Roboto", Font.PLAIN, 14));
            registerButton2.addActionListener(e -> login(e));

            //---- registerButton ----
            registerButton.setText("Register");
            registerButton.setFont(new Font("Roboto", Font.PLAIN, 14));
            registerButton.addActionListener(e -> register(e));

            //---- label1 ----
            label1.setText("CS434 Exam Portal");
            label1.setBackground(Color.white);
            label1.setForeground(Color.white);

            //---- ozuIconLabel ----
            ozuIconLabel.setText("text");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(732, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addContainerGap(284, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label3)
                                    .addComponent(surnameFiled, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(0, 284, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label6)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(studentIDField, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(emailFiled, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                            .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                            .addComponent(label5))
                                        .addComponent(label4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))))
                        .addGap(266, 266, 266))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(325, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(teacherCheckbox)
                                .addGap(101, 101, 101)
                                .addComponent(studentCheckbox)
                                .addGap(322, 322, 322))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(registerButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(registerButton2)
                                .addGap(360, 360, 360))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(ozuIconLabel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                .addGap(375, 375, 375))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(registerText, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                .addGap(316, 316, 316))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(label1)
                        .addGap(26, 26, 26)
                        .addComponent(registerText)
                        .addGap(31, 31, 31)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(label2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(surnameFiled, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailFiled, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(label5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(label6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(teacherCheckbox)
                            .addComponent(studentCheckbox))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(registerButton2)
                            .addComponent(registerButton))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(ozuIconLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
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
    // Generated using JFormDesigner Evaluation license - yasemin
    private JPanel panel1;
    private JLabel label2;
    private JLabel label3;
    private JTextField surnameFiled;
    private JTextField nameField;
    private JLabel registerText;
    private JTextField emailFiled;
    private JLabel label4;
    private JLabel label5;
    private JPasswordField passwordField;
    private JLabel label6;
    private JTextField studentIDField;
    private JCheckBox teacherCheckbox;
    private JCheckBox studentCheckbox;
    private JButton registerButton2;
    private JButton registerButton;
    private JLabel label1;
    private JLabel ozuIconLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
