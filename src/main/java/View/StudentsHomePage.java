package View;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

import Controller.ExamController.Examination;
import Model.ExamModel;
import View.StudentsQuestion.QuestionsPage;

public class StudentsHomePage extends JFrame {
    public int userId;
    public String userName;
    public ArrayList<Integer> examIds;
    public ExamModel examModel = new ExamModel();

    public StudentsHomePage(int userId, String userName) {

        this.examIds = getExamModel().getUserExamIds(userId);
        this.userId = userId;
        this.userName = userName;
        initComponents();
        setUserNameLabel();
        setExamData();
        date();
        time();
        setIcon();
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

    public void setUserNameLabel( ){
        nameLabel.setText(getUserName());
    }

    public void date(){
        dateLabel.setText("Date : " + new SimpleDateFormat("dd/MM/yyyy",new Locale("tr")).format(new Date()));
    }

    public void time(){
        new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
                timeLabel.setText("Time : " +sdf.format(new Date()));
            }
        }).start();
    }
    
    public void setIcon(){
        BufferedImage img = null;
        BufferedImage img2 = null;
        try {
            img = ImageIO.read(new File("src/main/java/View/Images/ou_logo_ing_white.png"));
            Image ozuLogo = img.getScaledInstance(ozuIconLabel.getWidth(),ozuIconLabel.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(ozuLogo);
            ozuIconLabel.setIcon(imageIcon);
            img2 = ImageIO.read(new File("src/main/java/View/Images/profile-user.png"));
            Image profileLogo = img2.getScaledInstance(profileIcon.getWidth(),profileIcon.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon imageIcon2 = new ImageIcon(profileLogo);
            profileIcon.setIcon(imageIcon2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setExamData(){
        String[][] data = new String[examIds.size()][6];
        ExamModel model = new ExamModel();
        for(int i=0; i<examIds.size();i++)  {
            Examination examination = getExamModel().getExam(examIds.get(i));
            data[i][0] = examination.getName();
            data[i][1] = examination.getDate().toString();
            data[i][2] = examination.getStartTime().toString() + "-" + examination.getEndTime().toString();
            data[i][3] = "Attend";
            data[i][4] = "Review";
            if(model.hasGradedExam(getUserId(),examIds.get(i))){
                data[i][5] = String.valueOf(model.getGrade(getUserId(),examIds.get(i)));
            }
            else{
                data[i][5] = "Not Graded";
            }
        }
        String[] columnNames = {"Exam Name","Date","Time","Status","Review","Grade"};
        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
        tableModel.setDataVector(data,columnNames);
        table1.setModel(tableModel);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table1.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);
        table1.getTableHeader().setFont( new Font( "Roboto" , Font.PLAIN, 13 ));

        ButtonColumn column = new ButtonColumn(table1, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExamModel examModel = new ExamModel();
                Examination newExamination =  examModel.getExam(examIds.get(table1.getSelectedRow()));
                LocalDateTime currentDate = LocalDateTime.now();
                DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String current = sdf.format(new Date());
                Date timeNow = new Date();
                try {
                    timeNow = sdf.parse(current);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                long startTime = newExamination.getStartTime().getTime();
                long endTime = newExamination.getEndTime().getTime();
                long currentTime = timeNow.getTime();

                if(!examModel.hasAttendedExam(getUserId(), newExamination.getId())
                        && newExamination.getDate().toString().equals(date.format(currentDate))
                        && startTime <= currentTime && endTime >= currentTime)
                {
                    QuestionsPage examPage = new QuestionsPage(examIds.get(table1.getSelectedRow()), getUserName(),0);
                    examPage.setVisible(true);
                    dispose();
                }
                else if(!newExamination.getDate().toString().equals(date.format(currentDate))
                        || startTime > currentTime || endTime < currentTime){
                        JOptionPane.showMessageDialog(new JFrame(),"The exam has not started / has ended.","Dialog",JOptionPane.ERROR_MESSAGE);
                }
                else if(examModel.hasAttendedExam(getUserId(), newExamination.getId())){
                    JOptionPane.showMessageDialog(new JFrame(),"You have already attended the exam.","Dialog",JOptionPane.ERROR_MESSAGE);
                }
            }
        }, 3 );

        ButtonColumn column2 = new ButtonColumn(table1, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExamModel examModel = new ExamModel();
                Examination newExamination =  examModel.getExam(examIds.get(table1.getSelectedRow()));
                if(!examModel.hasAttendedExam(getUserId(), newExamination.getId())){
                    JOptionPane.showMessageDialog(new JFrame(),"You have not attended the exam.","Dialog",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    StudentsReviewPage reviewPage = new StudentsReviewPage(getUserId(), getUserName(),examIds.get(table1.getSelectedRow()),0);
                    reviewPage.setVisible(true);
                }

            }
        }, 4 );
    }

    private void Logout(ActionEvent e) {
        LoginView view = new LoginView();
        view.setLocationRelativeTo(this);
        view.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yasemin Orhun
        panel1 = new JPanel();
        nameLabel = new JLabel();
        dateLabel = new JLabel();
        Logout = new JButton();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        timeLabel = new JLabel();
        ozuIconLabel = new JLabel();
        profileIcon = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(103, 137, 171));
            panel1.setPreferredSize(new Dimension(893, 576));
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
            border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER
            ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font
            .BOLD,12),java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order"
            .equals(e.getPropertyName()))throw new RuntimeException();}});

            //---- nameLabel ----
            nameLabel.setText("Name Surname");
            nameLabel.setForeground(Color.white);
            nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            nameLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

            //---- dateLabel ----
            dateLabel.setText("15.12.2021");
            dateLabel.setForeground(Color.white);
            dateLabel.setFont(new Font("Roboto", Font.PLAIN, 13));

            //---- Logout ----
            Logout.setText("Logout");
            Logout.addActionListener(e -> Logout(e));

            //======== scrollPane2 ========
            {
                scrollPane2.setBorder(new EmptyBorder(6, 6, 6, 6));
                scrollPane2.setBackground(new Color(189, 204, 218));

                //---- table1 ----
                table1.setBorder(new EmptyBorder(5, 5, 5, 5));
                table1.setFont(new Font("Roboto Thin", Font.PLAIN, 13));
                table1.setRowHeight(30);
                table1.setSelectionForeground(new Color(204, 204, 204));
                table1.setIntercellSpacing(new Dimension(5, 5));
                scrollPane2.setViewportView(table1);
            }

            //---- timeLabel ----
            timeLabel.setText("Time");
            timeLabel.setForeground(Color.white);
            timeLabel.setFont(new Font("Roboto", Font.PLAIN, 13));

            //---- ozuIconLabel ----
            ozuIconLabel.setText("text");

            //---- profileIcon ----
            profileIcon.setText("text");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 940, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(Logout)
                                        .addGap(342, 342, 342)
                                        .addComponent(ozuIconLabel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(29, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(profileIcon, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 627, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(dateLabel)
                                    .addComponent(timeLabel))
                                .addContainerGap(38, Short.MAX_VALUE))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap(40, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(nameLabel)
                                    .addComponent(profileIcon, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(dateLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(timeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)))
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(ozuIconLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(Logout))
                        .addGap(11, 11, 11))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 991, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yasemin Orhun
    private JPanel panel1;
    private JLabel nameLabel;
    private JLabel dateLabel;
    private JButton Logout;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JLabel timeLabel;
    private JLabel ozuIconLabel;
    private JLabel profileIcon;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

