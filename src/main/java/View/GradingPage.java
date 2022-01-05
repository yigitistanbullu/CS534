/*
 * Created by JFormDesigner on Mon Jan 03 21:44:20 TRT 2022
 */

package View;

import javax.swing.border.*;
import Controller.ExamController.Examination;
import Model.AuthorizationModel;
import Model.ExamModel;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableCellRenderer;
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
        setIcon();
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

    public int getInstructorId() {
        return instructorId;
    }

    public AuthorizationModel getAuthorizationModel() {
        return authorizationModel;
    }

    private void back(ActionEvent e) {
       TeachersHomePage frame = new TeachersHomePage(getInstructorId(),getInstructorName());
       frame.setVisible(true);
       this.dispose();
    }

    public void setIcon(){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/main/java/View/Images/ou_logo_ing_white.png"));
            Image ozuLogo = img.getScaledInstance(ozuIconLabel.getWidth(),ozuIconLabel.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(ozuLogo);
            ozuIconLabel.setIcon(imageIcon);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void grade(ActionEvent e) {
        int id = userIds.get(table1.getSelectedRow());
        StudentsReviewPage reviewPage = new StudentsReviewPage(id, AuthorizationModel.getName(id),getExamId(),1);
        reviewPage.setVisible(true);
    }

    public void setUserTable(){
        ExamModel model = new ExamModel();
        Examination newExamination = model.getExam(getExamId());
        instructorNameLabel.setText(newExamination.getName());
        String[][] data = new String[userIds.size()][3];
        for(int i=0; i<userIds.size(); i++)  {
            data[i][0] = getAuthorizationModel().getName(userIds.get(i));
            if(model.hasAttendedExam(userIds.get(i),getExamId())){
                data[i][1] = "Attended";
            }
            else{
                data[i][1] = "Has Not Attended";
            }
            if(model.hasGradedExam(userIds.get(i),getExamId())){
                data[i][2] = String.valueOf(model.getGrade(userIds.get(i),getExamId()));
            }
            else{
                data[i][2] = "Not Graded";
            }

        }
        String[] columnNames = {"Student Name","Attendance","Grade"};
        DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
        tableModel.setDataVector(data,columnNames);
        table1.setModel(tableModel);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table1.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);
        table1.getTableHeader().setFont( new Font( "Roboto" , Font.PLAIN, 13 ));
    }

    private void refresh(ActionEvent e) {
        GradingPage frame = new GradingPage(getExamId(),getInstructorName(),getInstructorId());
        frame.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yasemin Orhun
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        instructorNameLabel = new JLabel();
        gradeButton = new JButton();
        backButton = new JButton();
        ozuIconLabel = new JLabel();
        refreshButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(103, 137, 171));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) )
            ; panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(new Color(189, 204, 218));
                scrollPane1.setForeground(Color.white);
                scrollPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

                //---- table1 ----
                table1.setRowHeight(30);
                scrollPane1.setViewportView(table1);
            }

            //---- instructorNameLabel ----
            instructorNameLabel.setText("Exam Name");
            instructorNameLabel.setForeground(Color.white);
            instructorNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            instructorNameLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

            //---- gradeButton ----
            gradeButton.setText("Grade Student");
            gradeButton.addActionListener(e -> grade(e));

            //---- backButton ----
            backButton.setText("Back");
            backButton.addActionListener(e -> back(e));

            //---- ozuIconLabel ----
            ozuIconLabel.setText("text");

            //---- refreshButton ----
            refreshButton.setText("Refresh");
            refreshButton.setBackground(Color.white);
            refreshButton.addActionListener(e -> refresh(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(31, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(ozuIconLabel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addGap(281, 281, 281)
                                .addComponent(gradeButton))
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(instructorNameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(refreshButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(backButton))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 940, GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(instructorNameLabel)
                            .addComponent(backButton)
                            .addComponent(refreshButton))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(gradeButton)
                            .addComponent(ozuIconLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
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
    // Generated using JFormDesigner Evaluation license - Yasemin Orhun
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel instructorNameLabel;
    private JButton gradeButton;
    private JButton backButton;
    private JLabel ozuIconLabel;
    private JButton refreshButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
