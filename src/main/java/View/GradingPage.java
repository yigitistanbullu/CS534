/*
 * Created by JFormDesigner on Mon Jan 03 21:44:20 TRT 2022
 */

package View;

import Model.AuthorizationModel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author yasemin
 */
public class GradingPage extends JFrame {
    public int examId;
    public String instructorName;
    public int instructorId;
    public ArrayList<Integer> userIds = new ArrayList<>();
    AuthorizationModel authorizationModel = new AuthorizationModel();
    
    public GradingPage(int examId, String instructorName, int instructorId) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.examId = examId;
        this.userIds = getAuthorizationModel().getUserIds();
        initComponents();
        setUserTable();
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public ArrayList<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(ArrayList<Integer> userIds) {
        this.userIds = userIds;
    }

    public AuthorizationModel getAuthorizationModel() {
        return authorizationModel;
    }

    public void setAuthorizationModel(AuthorizationModel authorizationModel) {
        this.authorizationModel = authorizationModel;
    }

    private void back(ActionEvent e) {
        // TODO add your code here
    }

    private void grade(ActionEvent e) {
        int id = userIds.get(table1.getSelectedRow());

    }

    public void setUserTable(){
        String[][] data = new String[userIds.size()][2];
        for(int i=0; i<userIds.size(); i++)  {
            data[i][0] = getAuthorizationModel().getName(userIds.get(i));
            data[i][1] = "Has Attended";
        }
        String[] columnNames = {"User Name","Attendance"};
        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
        tableModel.setDataVector(data,columnNames);
        table1.setModel(tableModel);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yasemin
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        instructorNameLabel = new JLabel();
        gradeButton = new JButton();
        backButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(182, 142, 185));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(Color.white);
                scrollPane1.setForeground(Color.white);
                scrollPane1.setViewportView(table1);
            }

            //---- instructorNameLabel ----
            instructorNameLabel.setText("Instructor Name");
            instructorNameLabel.setForeground(Color.white);
            instructorNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            instructorNameLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 18));

            //---- gradeButton ----
            gradeButton.setText("Grade Student");
            gradeButton.addActionListener(e -> grade(e));

            //---- backButton ----
            backButton.setText("Back");
            backButton.addActionListener(e -> back(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(gradeButton)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(instructorNameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                .addGap(347, 347, 347)
                                .addComponent(backButton))
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 604, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(51, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(instructorNameLabel)
                            .addComponent(backButton))
                        .addGap(26, 26, 26)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gradeButton)
                        .addContainerGap(41, Short.MAX_VALUE))
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
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel instructorNameLabel;
    private JButton gradeButton;
    private JButton backButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
