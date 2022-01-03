/*
 * Created by JFormDesigner on Mon Dec 20 20:14:49 TRT 2021
 */

package View;

import java.awt.event.*;
import Controller.ExamController.Exam;
import Model.ExamModel;
import View.EditExamFrame;
import View.TeachersHomePage;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.awt.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yasemin
 */
public class CreateExamFrame extends JFrame {
    public String examName;
    public String courseCode;
    public Date dateOfExam;
    public Time timeOfExam;
    public String userName_instructor;
    public int userId_instructor;
    public int examId_instructor;

    public CreateExamFrame(String userName, int userId, int examId) {
        this.userName_instructor = userName;
        this.userId_instructor = userId;
        this.examId_instructor = examId;
        initComponents();
    }

    public void setFormattedFields(){
        //dateField
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        DateFormatter df = new DateFormatter(format);
        DefaultFormatterFactory dateFactory = new DefaultFormatterFactory(df);
        date.setFormatterFactory(dateFactory);
        date.setPreferredSize(new Dimension(100, 20));
        date.setValue(new Date());

        //timeField
        DateFormat time = new SimpleDateFormat("HH:mm:ss");
        DateFormatter tdf = new DateFormatter(time);
        DefaultFormatterFactory timeFactory = new DefaultFormatterFactory(tdf);
        startTime.setFormatterFactory(timeFactory);
        startTime.setPreferredSize(new Dimension(100, 20));
        startTime.setValue(new Date().getTime());

        endTime.setFormatterFactory(timeFactory);
        endTime.setPreferredSize(new Dimension(100, 20));
        endTime.setValue(new Date().getTime());
    }

    private void create(ActionEvent e) {
        ExamModel examModel = new ExamModel();
        Exam exam = new Exam(examModel.getExamIndex()+1,examNameLabel.getText(),100);
        examModel.addExam(exam);
        dispose();
    }

    private void cancel(ActionEvent e) {
        dispose();
        TeachersHomePage page = new TeachersHomePage(getUserId_instructor(),getUserName_instructor(),getExamId_instructor());
        page.setVisible(true);
    }

    public String getUserName_instructor() {
        return userName_instructor;
    }

    public int getUserId_instructor() {
        return userId_instructor;
    }

    public int getExamId_instructor() {
        return examId_instructor;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        date = new JFormattedTextField();
        startTime = new JFormattedTextField();
        endTime = new JFormattedTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        createButton = new JButton();
        examNameLabel = new JTextField();
        courseCodeLabel = new JTextField();
        label6 = new JLabel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setForeground(new Color(0, 176, 195));
            panel1.setBackground(new Color(113, 188, 255));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) )
            ; panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;

            //---- label1 ----
            label1.setText("Start:");
            label1.setForeground(Color.white);
            label1.setFont(new Font("Roboto Thin", Font.PLAIN, 23));

            //---- label2 ----
            label2.setText("End:");
            label2.setForeground(Color.white);
            label2.setFont(new Font("Roboto Thin", Font.PLAIN, 23));

            //---- label3 ----
            label3.setText("Date:");
            label3.setForeground(Color.white);
            label3.setFont(new Font("Roboto Thin", Font.PLAIN, 23));

            //---- date ----
            date.setBackground(Color.white);

            //---- startTime ----
            startTime.setBackground(Color.white);

            //---- endTime ----
            endTime.setBackground(Color.white);

            //---- label4 ----
            label4.setText("Course Code:");
            label4.setForeground(Color.white);
            label4.setFont(new Font("Roboto Thin", Font.PLAIN, 23));

            //---- label5 ----
            label5.setText("Exam Name:");
            label5.setForeground(Color.white);
            label5.setFont(new Font("Roboto Thin", Font.PLAIN, 23));

            //---- createButton ----
            createButton.setText("Create");
            createButton.setBackground(new Color(113, 188, 255));
            createButton.setForeground(Color.white);
            createButton.addActionListener(e -> create(e));

            //---- examNameLabel ----
            examNameLabel.setBackground(Color.white);

            //---- courseCodeLabel ----
            courseCodeLabel.setBackground(Color.white);

            //---- label6 ----
            label6.setText("Create Exam");
            label6.setForeground(Color.white);
            label6.setFont(new Font("Roboto Thin", Font.BOLD, 30));

            //---- button1 ----
            button1.setText("Cancel");
            button1.setBackground(new Color(113, 188, 255));
            button1.setForeground(Color.white);
            button1.addActionListener(e -> cancel(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 383, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(createButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(label6)
                                .addGap(365, 365, 365))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label5)
                                        .addGap(19, 19, 19)
                                        .addComponent(examNameLabel, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(courseCodeLabel)))
                                .addGap(57, 57, 57)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addComponent(label3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(date))
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addComponent(label1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(startTime, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(endTime, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(93, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(label6)
                        .addGap(86, 86, 86)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(examNameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3)
                            .addComponent(date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(label4)
                                        .addComponent(courseCodeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label2)
                                    .addComponent(startTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(createButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(endTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(339, Short.MAX_VALUE))))
            );
            panel1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {courseCodeLabel, date, endTime, examNameLabel, startTime});
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JFormattedTextField date;
    private JFormattedTextField startTime;
    private JFormattedTextField endTime;
    private JLabel label4;
    private JLabel label5;
    private JButton createButton;
    private JTextField examNameLabel;
    private JTextField courseCodeLabel;
    private JLabel label6;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
