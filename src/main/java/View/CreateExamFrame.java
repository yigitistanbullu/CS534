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
    public Time startTime;
    public Time endTime;
    public String userName_instructor;
    public int userId_instructor;
    public int examId_instructor;

    public CreateExamFrame(String userName, int userId) {
        this.userName_instructor = userName;
        this.userId_instructor = userId;
        initComponents();
    }

    private void create(ActionEvent e) {
        ExamModel examModel = new ExamModel();
        System.out.println(startTimeLabel.getText());
        System.out.println(endTimeLabel.getText());
        System.out.println(dateLabel.getText());
        examModel.addExam(examNameLabel.getText(),100,Time.valueOf(startTimeLabel.getText()), Time.valueOf(endTimeLabel.getText()), java.sql.Date.valueOf(dateLabel.getText()));
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

    public Date getDateOfExam() {
        return dateOfExam;
    }

    public void setDateOfExam(Date dateOfExam) {
        this.dateOfExam = dateOfExam;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yasemin Orhun
        panel1 = new JPanel();
        startTimeLabel = new JTextField();
        endTimeLabel = new JTextField();
        dateLabel = new JTextField();
        examNameLabel = new JTextField();
        createButton = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label5 = new JLabel();
        button1 = new JButton();
        label6 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
            border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER
            ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font
            . BOLD ,12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r"
            .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
            panel1.setLayout(new FlowLayout());
        }

        //---- startTimeLabel ----
        startTimeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        startTimeLabel.setText("HH:mm:ss");

        //---- endTimeLabel ----
        endTimeLabel.setText("HH:mm:ss");

        //---- dateLabel ----
        dateLabel.setText("yyyy-MM-dd");

        //---- createButton ----
        createButton.setText("Create");
        createButton.addActionListener(e -> create(e));

        //---- label1 ----
        label1.setText("Start Time:");

        //---- label2 ----
        label2.setText("End Time:");

        //---- label3 ----
        label3.setText("Date:");

        //---- label5 ----
        label5.setText("Exam Name:");

        //---- button1 ----
        button1.setText("Cancel");
        button1.addActionListener(e -> cancel(e));

        //---- label6 ----
        label6.setText("Create Exam");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(35, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label3)
                                .addComponent(label2)
                                .addComponent(label5)
                                .addComponent(label1))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup()
                                    .addComponent(startTimeLabel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(endTimeLabel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                                .addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                .addComponent(examNameLabel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(49, 49, 49)
                            .addComponent(createButton)))
                    .addGap(84, 84, 84))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(122, 122, 122)
                    .addComponent(label6)
                    .addContainerGap(138, Short.MAX_VALUE))
        );
        contentPaneLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {dateLabel, endTimeLabel, examNameLabel, startTimeLabel});
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(label6)
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(examNameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(startTimeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(endTimeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(createButton)
                        .addComponent(button1))
                    .addGap(32, 32, 32))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yasemin Orhun
    private JPanel panel1;
    private JTextField startTimeLabel;
    private JTextField endTimeLabel;
    private JTextField dateLabel;
    private JTextField examNameLabel;
    private JButton createButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label5;
    private JButton button1;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
