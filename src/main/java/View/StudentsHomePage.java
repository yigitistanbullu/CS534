package View;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

import Controller.ExamController.Exam;
import Model.ExamModel;
import Model.QuestionModel;
import View.StudentsQuestion.QuestionsPage;
/*
 * Created by JFormDesigner on Wed Dec 15 19:07:28 EET 2021
 */



/**
 * @author Zeliha Aydın
 */
public class StudentsHomePage extends JFrame {
    public int userId;
    public String userName;
    public int examId;

    public StudentsHomePage(int userId, String userName, int examId) {
        this.examId = examId;
        this.userId = userId;
        this.userName = userName;
        initComponents();
        setUserNameLabel();
        setExamData();
        date();
        time();
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getExamId() {
        return examId;
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
    

    public void setExamData(){
        ExamModel model = new ExamModel();
        Exam exam = model.getExam(getExamId());
        String[][] data = {{exam.getName(),"Attend","Review",Double.toString(exam.getGrade())}};
        String[] columnNames = {"Exam Name","Status","","Grade"};
        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
        tableModel.setDataVector(data,columnNames);
        table1.setModel(tableModel);
        ButtonColumn column = new ButtonColumn(table1, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExamModel examModel = new ExamModel();
                Exam newExam =  examModel.getExam(getExamId());
                QuestionsPage examPage = new QuestionsPage(getExamId(), getUserName());
                examPage.setVisible(true);
                dispose();

            }
        }, 1 );
        ButtonColumn column2 = new ButtonColumn(table1, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentsReviewPage reviewPage = new StudentsReviewPage(getUserId(), getUserName(),getExamId());
                reviewPage.setVisible(true);
                dispose();

            }
        }, 2 );
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
        // Generated using JFormDesigner Evaluation license - yasemin
        panel1 = new JPanel();
        nameLabel = new JLabel();
        dateLabel = new JLabel();
        Logout = new JButton();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        timeLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(182, 142, 185));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

            //---- nameLabel ----
            nameLabel.setText("Zeliha Ayd\u0131n S018460");
            nameLabel.setForeground(Color.white);
            nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            nameLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 18));

            //---- dateLabel ----
            dateLabel.setText("15.12.2021");
            dateLabel.setForeground(Color.white);
            dateLabel.setFont(new Font("Roboto", Font.PLAIN, 13));

            //---- Logout ----
            Logout.setText("Logout");
            Logout.addActionListener(e -> Logout(e));

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(table1);
            }

            //---- timeLabel ----
            timeLabel.setText("Time");
            timeLabel.setForeground(Color.white);
            timeLabel.setFont(new Font("Roboto", Font.PLAIN, 13));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap(529, Short.MAX_VALUE)
                                .addComponent(Logout))
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(dateLabel)
                                            .addComponent(timeLabel))
                                        .addGap(8, 8, 8)))))
                        .addGap(26, 26, 26))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(nameLabel))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(dateLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timeLabel)))
                        .addGap(26, 26, 26)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Logout)
                        .addContainerGap(14, Short.MAX_VALUE))
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
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - yasemin
    private JPanel panel1;
    private JLabel nameLabel;
    private JLabel dateLabel;
    private JButton Logout;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JLabel timeLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

