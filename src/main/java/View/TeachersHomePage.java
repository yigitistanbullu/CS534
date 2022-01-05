package View;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controller.ExamController.Examination;
import Model.AuthorizationModel;
import Model.ExamModel;

public class TeachersHomePage extends JFrame {
    public int userId;
    public ArrayList<Integer> examIds;
    public ExamModel examModel = new ExamModel();
    public String userName;


    public TeachersHomePage(int userId, String userName) {
        initComponents();
        this.userId = userId;
        this.examIds = getExamModel().getUserExamIds(userId);
        this.userName = userName;
        date();
        setNameLabel();
        setExamData();
        setIcon();
    }

    public void setIcon(){
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
    public int getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public ExamModel getExamModel() {
        return examModel;
    }

    public void setExamData(){
        String[][] data = new String[examIds.size()][3];
        for(int i=0; i<examIds.size();i++)  {
            Examination examination = getExamModel().getExam(examIds.get(i));
            data[i][0] = examination.getName();
            data[i][1] = examination.getDate().toString();
            data[i][2] = examination.getStartTime().toString() + "-" + examination.getEndTime().toString();
        }
        String[] columnNames = {"Exam Name","Date", "Time"};
        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
        tableModel.setDataVector(data,columnNames);
        table1.setModel(tableModel);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table1.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);
        table1.getTableHeader().setFont( new Font( "Roboto" , Font.PLAIN, 13 ));
    }

    private void createExam(ActionEvent e) {
        CreateExamFrame frame = new CreateExamFrame(getUserName(),getUserId());
        frame.setVisible(true);
        this.dispose();
    }

    private void setNameLabel() {
        AuthorizationModel model = new AuthorizationModel();
        nameLabel.setText(model.getName(getUserId()));
    }
    
    public void date(){
        dateLabel.setText("Date : " + new SimpleDateFormat("dd/MM/yyyy",new Locale("tr")).format(new Date()));
    }

    private void Logout(ActionEvent e) {
        LoginView view = new LoginView();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        dispose();
    }

    private void editExam(ActionEvent e) {
        EditExamFrame frame = new EditExamFrame(getUserId(),getUserName(), examIds.get(table1.getSelectedRow()));
        frame.setVisible(true);
        this.dispose();
    }

    private void grade(ActionEvent e) {
        GradingPage frame = new GradingPage(examIds.get(table1.getSelectedRow()),getUserName(),getUserId());
        frame.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yasemin Orhun
        panel1 = new JPanel();
        nameLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        createExamButton = new JButton();
        Logout = new JButton();
        dateLabel = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        ozuIconLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(103, 137, 171));
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
            new javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion"
            ,javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
            ,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12)
            ,java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException()
            ;}});

            //---- nameLabel ----
            nameLabel.setText("Instructor Name");
            nameLabel.setForeground(Color.white);
            nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            nameLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(new Color(189, 204, 218));
                scrollPane1.setForeground(Color.white);
                scrollPane1.setBorder(new EmptyBorder(6, 6, 6, 6));

                //---- table1 ----
                table1.setBorder(new EmptyBorder(5, 5, 5, 5));
                table1.setFont(new Font("Roboto", Font.PLAIN, 14));
                table1.setRowHeight(30);
                scrollPane1.setViewportView(table1);
            }

            //---- createExamButton ----
            createExamButton.setText("Create Exam");
            createExamButton.addActionListener(e -> createExam(e));

            //---- Logout ----
            Logout.setText("Logout");
            Logout.addActionListener(e -> Logout(e));

            //---- dateLabel ----
            dateLabel.setText("15.12.2021");
            dateLabel.setForeground(Color.white);
            dateLabel.setFont(new Font("Roboto", Font.PLAIN, 13));

            //---- button1 ----
            button1.setText("Edit Exam");
            button1.addActionListener(e -> editExam(e));

            //---- button2 ----
            button2.setText("Grade Exam");
            button2.addActionListener(e -> grade(e));

            //---- ozuIconLabel ----
            ozuIconLabel.setText("text");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(createExamButton, GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateLabel, GroupLayout.Alignment.TRAILING)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 903, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(Logout)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ozuIconLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addGap(171, 171, 171)
                                .addComponent(button2)
                                .addGap(18, 18, 18)
                                .addComponent(button1)))
                        .addGap(28, 28, 28))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createExamButton)
                                .addGap(10, 10, 10))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nameLabel)
                                .addGap(30, 30, 30)))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1)
                            .addComponent(button2)
                            .addComponent(Logout)
                            .addComponent(ozuIconLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yasemin Orhun
    private JPanel panel1;
    private JLabel nameLabel;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton createExamButton;
    private JButton Logout;
    private JLabel dateLabel;
    private JButton button1;
    private JButton button2;
    private JLabel ozuIconLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
