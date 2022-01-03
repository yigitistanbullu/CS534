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
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
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
            panel1.setBackground(new Color(113, 188, 255));
            panel1.setForeground(Color.white);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
            ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
            .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
            propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
            ;} } );

            //---- nameLabel ----
            nameLabel.setText("Zeliha Ayd\u0131n S018460");
            nameLabel.setForeground(Color.white);
            nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            nameLabel.setFont(new Font("Roboto Thin", Font.BOLD, 18));
            nameLabel.setBackground(new Color(113, 188, 255));
            nameLabel.setIcon(new ImageIcon("/Users/zel/Desktop/School/CS534/src/main/java/View/Images/preview.png"));

            //---- dateLabel ----
            dateLabel.setText("15.12.2021");
            dateLabel.setForeground(Color.white);
            dateLabel.setFont(new Font("Roboto", Font.PLAIN, 13));

            //---- Logout ----
            Logout.setText("Logout");
            Logout.setForeground(Color.white);
            Logout.setBackground(new Color(113, 188, 255));
            Logout.addActionListener(e -> Logout(e));

            //======== scrollPane2 ========
            {

                //---- table1 ----
                table1.setBackground(Color.white);
                table1.setForeground(new Color(51, 51, 51));
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
                                .addGap(30, 30, 30)
                                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 460, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(timeLabel)
                                        .addGap(53, 53, 53))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addComponent(dateLabel)
                                        .addGap(33, 33, 33))))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(Logout, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 873, GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(dateLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timeLabel))
                            .addComponent(nameLabel))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(Logout, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
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
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
    private JPanel panel1;
    private JLabel nameLabel;
    private JLabel dateLabel;
    private JButton Logout;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JLabel timeLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

