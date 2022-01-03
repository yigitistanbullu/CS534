/*
 * Created by JFormDesigner on Mon Dec 20 20:14:49 TRT 2021
 */

package View;

import java.awt.event.*;
import Controller.ExamController.Exam;
import Model.AuthorizationModel;
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
import java.util.ArrayList;
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

    public CreateExamFrame(String userName, int userId) {
        this.userName_instructor = userName;
        this.userId_instructor = userId;
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
        examModel.addExam(examNameLabel.getText(),100);
        Exam exam = examModel.getExam(examModel.getExamIdFromName(examNameLabel.getText()));
        AuthorizationModel model = new AuthorizationModel();
        ArrayList<Integer> ids = model.getUserIds();
        for(Integer id : ids){
            examModel.addUserExam(exam,id);
        }
        examModel.addUserExam(exam,getUserId_instructor());
        TeachersHomePage frame = new TeachersHomePage(getUserId_instructor(),getUserName_instructor());
        frame.setVisible(true);
        dispose();
    }

    private void cancel(ActionEvent e) {
        dispose();
        TeachersHomePage page = new TeachersHomePage(getUserId_instructor(),getUserName_instructor());
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
        // Generated using JFormDesigner Evaluation license - yasemin
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
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setText("Start:");

            //---- label2 ----
            label2.setText("End:");

            //---- label3 ----
            label3.setText("Date:");

            //---- label4 ----
            label4.setText("Course Code:");

            //---- label5 ----
            label5.setText("Exam Name:");

            //---- createButton ----
            createButton.setText("Create");
            createButton.addActionListener(e -> create(e));

            //---- label6 ----
            label6.setText("Create Exam");

            //---- button1 ----
            button1.setText("Cancel");
            button1.addActionListener(e -> cancel(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(label1)
                                            .addComponent(label3))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(startTime, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(label2)
                                                .addGap(91, 91, 91))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(date, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(endTime, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(createButton)))
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                                .addGroup(panel1Layout.createParallelGroup()
                                                    .addComponent(label4)
                                                    .addComponent(label5))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panel1Layout.createParallelGroup()
                                                    .addComponent(examNameLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(courseCodeLabel, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(button1)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(label6)))
                        .addGap(30, 30, 30))
            );
            panel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {courseCodeLabel, examNameLabel});
            panel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {endTime, startTime});
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label6)
                        .addGap(19, 19, 19)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(examNameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(courseCodeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(startTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2)
                            .addComponent(endTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(createButton)
                            .addComponent(button1))
                        .addContainerGap(20, Short.MAX_VALUE))
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
    // Generated using JFormDesigner Evaluation license - yasemin
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
