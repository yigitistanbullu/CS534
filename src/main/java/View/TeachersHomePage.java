package View;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventListener;
import java.util.Locale;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

import Controller.ExamController.Exam;
import Model.AuthorizationModel;
import Model.ExamModel;
import View.StudentsQuestion.QuestionsPage;
import View.TeachersQuestion.QuestionsPageInstructor;
import View.TeacherGradingPage;
/*
 * Created by JFormDesigner on Wed Dec 15 19:40:10 EET 2021
 */



/**
 * @author Zeliha Aydın
 */
public class TeachersHomePage extends JFrame {
    public int userId;
    public int examId;
    public String userName;


    public TeachersHomePage(int userId, String userName, int examId) {
        initComponents();
        this.userId = userId;
        this.examId = examId;
        this.userName = userName;
        date();
        time();
        setNameLabel();
        setExamData();
    }

    public int getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public int getExamId() {
        return examId;
    }
    public void setExamData(){
        ExamModel model = new ExamModel();
        Exam exam = model.getExam(getExamId());
        String[][] data = {{exam.getName(),"Edit","Review"}};
        String[] columnNames = {"Exam Name","",""};
        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
        tableModel.setDataVector(data,columnNames);
        table1.setModel(tableModel);
        ButtonColumn column = new ButtonColumn(table1, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        }, 1 );
        ButtonColumn column2 = new ButtonColumn(table1, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherGradingPage review = new TeacherGradingPage(getExamId(), getUserName());
                review.setVisible(true);
                review.setLocationRelativeTo(null);
                dispose();
            }
        }, 2 );
    }

    private void createExam(ActionEvent e) {
        dispose();
        QuestionsPageInstructor exam = new QuestionsPageInstructor();
        exam.setVisible(true);
        exam.setLocationRelativeTo(null);
    }

    private void setNameLabel() {
        AuthorizationModel model = new AuthorizationModel();
        nameLabel.setText(model.getName(getUserId()));
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
    private void Logout(ActionEvent e) {
        LoginView view = new LoginView();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        dispose();
    }
    

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yasemin
        panel1 = new JPanel();
        nameLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        createExamButton = new JButton();
        Logout = new JButton();
        dateLabel = new JLabel();
        timeLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(182, 142, 185));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
            new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , ""
            , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 )
            , java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

            //---- nameLabel ----
            nameLabel.setText("Emre Kaplan");
            nameLabel.setForeground(Color.white);
            nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            nameLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 18));

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(Color.white);
                scrollPane1.setForeground(Color.white);
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

            //---- timeLabel ----
            timeLabel.setText("Time");
            timeLabel.setForeground(Color.white);
            timeLabel.setFont(new Font("Roboto", Font.PLAIN, 13));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Logout))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(createExamButton, GroupLayout.Alignment.TRAILING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createParallelGroup()
                                        .addComponent(timeLabel)
                                        .addComponent(dateLabel)))))
                        .addGap(28, 28, 28))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(nameLabel)
                                .addGap(20, 20, 20))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(dateLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(timeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(createExamButton)
                            .addComponent(Logout))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211))
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
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - yasemin
    private JPanel panel1;
    private JLabel nameLabel;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton createExamButton;
    private JButton Logout;
    private JLabel dateLabel;
    private JLabel timeLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
