package View;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

import Controller.ExamController.Exam;
import Model.AuthorizationModel;
import Model.ExamModel;
import com.mysql.cj.result.Row;
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
        String[][] data = {{exam.getName(),"Date", "Time"}};
        String[] columnNames = {"Exam Name","Date", "Time"};
        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
        tableModel.setDataVector(data,columnNames);
        table1.setModel(tableModel);

    }

    private void createExam(ActionEvent e) {
        CreateExamFrame frame = new CreateExamFrame(getUserName(),getUserId(),getExamId());
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
        int indexSelectedRow = table1.getSelectedRow();
        EditExamFrame frame = new EditExamFrame(getUserId(),getUserName(),getExamId());
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
            panel1.setBackground(new Color(182, 142, 185));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) )
            ; panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;

            //---- nameLabel ----
            nameLabel.setText("Instructor Name");
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

            //---- button1 ----
            button1.setText("Edit Exam");
            button1.addActionListener(e -> editExam(e));

            //---- button2 ----
            button2.setText("Grade Exam");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(Logout)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 393, Short.MAX_VALUE)
                                .addComponent(createExamButton))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGap(0, 392, Short.MAX_VALUE)
                                .addComponent(button2)
                                .addGap(18, 18, 18)
                                .addComponent(button1))
                            .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(timeLabel)
                                    .addComponent(dateLabel))))
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
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(Logout)
                            .addComponent(createExamButton))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1)
                            .addComponent(button2))
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
