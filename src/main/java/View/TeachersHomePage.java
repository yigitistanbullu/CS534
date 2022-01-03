package View;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import Controller.ExamController.Exam;
import Model.AuthorizationModel;
import Model.ExamModel;
import com.mysql.cj.result.Row;
/*
 * Created by JFormDesigner on Wed Dec 15 19:40:10 EET 2021
 */


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

    public ArrayList<Integer> getExamIds() {
        return examIds;
    }

    public ExamModel getExamModel() {
        return examModel;
    }

    public void setExamData(){
        String[][] data = new String[examIds.size()][3];
        for(int i=0; i<examIds.size();i++)  {
            Exam exam = getExamModel().getExam(examIds.get(i));
            data[i][0] = exam.getName();
            data[i][1] = "Date";
            data[i][2] = "Time";
        }
        String[] columnNames = {"Exam Name","Date", "Time"};
        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
        tableModel.setDataVector(data,columnNames);
        table1.setModel(tableModel);
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
        // Generated using JFormDesigner Evaluation license - yasemin
        panel1 = new JPanel();
        nameLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        createExamButton = new JButton();
        Logout = new JButton();
        dateLabel = new JLabel();
        timeLabel = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(103, 137, 171));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
            swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border
            . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
            ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder
            ( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
            .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
            ( ); }} );

            //---- nameLabel ----
            nameLabel.setText("Instructor");
            nameLabel.setForeground(Color.white);
            nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            nameLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 18));

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(Color.white);
                scrollPane1.setForeground(Color.white);

                //---- table1 ----
                table1.setBorder(new LineBorder(Color.lightGray));
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

            //---- button1 ----
            button1.setText("Edit Exam");
            button1.addActionListener(e -> editExam(e));

            //---- button2 ----
            button2.setText("Grade Exam");
            button2.addActionListener(e -> grade(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(createExamButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 579, Short.MAX_VALUE)
                                .addComponent(button2)
                                .addGap(18, 18, 18)
                                .addComponent(button1))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Logout))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 660, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(timeLabel)
                                    .addComponent(dateLabel))
                                .addGap(9, 9, 9)))
                        .addGap(28, 28, 28))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addGap(12, 12, 12)
                                .addComponent(Logout)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(timeLabel)
                                .addGap(27, 27, 27)))
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1)
                            .addComponent(button2)
                            .addComponent(createExamButton))
                        .addGap(14, 14, 14))
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
    private JLabel nameLabel;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton createExamButton;
    private JButton Logout;
    private JLabel dateLabel;
    private JLabel timeLabel;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
