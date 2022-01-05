/*
 * Created by JFormDesigner on Mon Dec 20 20:14:49 TRT 2021
 */

package View;

import java.awt.event.*;

import Controller.ExamController.Exam;
import Controller.ExamController.Examination;
import Model.AuthorizationModel;
import Model.ExamModel;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;

/**
 * @author yasemin
 */
public class CreateExamFrame extends JFrame {
    public String userName_instructor;
    public int userId_instructor;

    public CreateExamFrame(String userName, int userId) {
        this.userName_instructor = userName;
        this.userId_instructor = userId;
        initComponents();
    }

    private void create(ActionEvent e) {
        ExamModel examModel = new ExamModel();
        examModel.addExam(examNameLabel.getText(),100,Time.valueOf(startTimeLabel.getText()), Time.valueOf(endTimeLabel.getText()), java.sql.Date.valueOf(dateLabel.getText()));
        Examination examination = examModel.getExam(examModel.getExamIdFromName(examNameLabel.getText()));
        AuthorizationModel model = new AuthorizationModel();
        ArrayList<Integer> ids = model.getUserIds();
        for(Integer id : ids){
            examModel.addUserExam(examination,id);
        }
        examModel.addUserExam(examination,getUserId_instructor());
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


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
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
        setBackground(new Color(103, 137, 171));
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(103, 137, 171));
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
            border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER
            ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font
            . BOLD ,12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r"
            .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //---- startTimeLabel ----
            startTimeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            startTimeLabel.setText("HH:mm:ss");
            startTimeLabel.setBackground(Color.white);
            startTimeLabel.setForeground(new Color(51, 51, 51));

            //---- endTimeLabel ----
            endTimeLabel.setText("HH:mm:ss");
            endTimeLabel.setBackground(Color.white);
            endTimeLabel.setForeground(new Color(51, 51, 51));

            //---- dateLabel ----
            dateLabel.setText("yyyy-MM-dd");
            dateLabel.setBackground(Color.white);
            dateLabel.setForeground(new Color(51, 51, 51));

            //---- examNameLabel ----
            examNameLabel.setBackground(Color.white);
            examNameLabel.setForeground(new Color(51, 51, 51));

            //---- createButton ----
            createButton.setText("Create");
            createButton.setBackground(new Color(103, 137, 171));
            createButton.setForeground(Color.darkGray);
            createButton.addActionListener(e -> create(e));

            //---- label1 ----
            label1.setText("Start Time:");
            label1.setForeground(Color.white);

            //---- label2 ----
            label2.setText("End Time:");
            label2.setForeground(Color.white);

            //---- label3 ----
            label3.setText("Date:");
            label3.setForeground(Color.white);

            //---- label5 ----
            label5.setText("Exam Name:");
            label5.setForeground(Color.white);

            //---- button1 ----
            button1.setText("Cancel");
            button1.setBackground(new Color(103, 137, 171));
            button1.setForeground(Color.darkGray);
            button1.addActionListener(e -> cancel(e));

            //---- label6 ----
            label6.setText("Create Exam");
            label6.setForeground(Color.white);
            label6.setFont(label6.getFont().deriveFont(20f));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap(203, Short.MAX_VALUE)
                                .addComponent(label6)
                                .addGap(39, 39, 39))
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                        .addComponent(createButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(label5)
                                            .addComponent(label1, GroupLayout.Alignment.LEADING)
                                            .addComponent(label2, GroupLayout.Alignment.LEADING)
                                            .addComponent(label3, GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(startTimeLabel, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                            .addComponent(examNameLabel, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                            .addComponent(endTimeLabel, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                            .addComponent(dateLabel, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))))
                        .addGap(153, 153, 153))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label6)
                        .addGap(56, 56, 56)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(examNameLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(startTimeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(endTimeLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(createButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))
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
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
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
