package View;
import Model.AuthorizationModel;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Dec 15 21:06:38 EET 2021
 */



/**
 * @author Zeliha Aydın
 */
public class TeacherGradingPage extends JFrame {
    public int studentId;
    public String name;
    AuthorizationModel model = new AuthorizationModel();
    TeachersHomePage home = new TeachersHomePage(studentId);

    public TeacherGradingPage(int studentId, String name) {
        this.name = name;
        this.studentId = studentId;
        initComponents();
        }

    private void reviewButton(ActionEvent e) {
        frame1.setVisible(true);
        frame1.setLocationRelativeTo(null);
        this.dispose();
    }

    private void setStudentName(){
        studentName.setText(name);
    }
    private void setExamName(){
    }

    private void backbutton(ActionEvent e) {
        home.setVisible(true);
        home.setLocationRelativeTo(null);
        this.dispose();
    }

    private void exitButton(ActionEvent e) {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        frame1.dispose();
    }

    private void initComponents() {
        home.dispose();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        panel1 = new JPanel();
        examName = new JLabel();
        scrollPane1 = new JScrollPane();
        panel2 = new JPanel();
        panel3 = new JPanel();
        studentName = new JLabel();
        reviewButton = new JButton();
        exitButton2 = new JButton();
        frame1 = new JFrame();
        panel4 = new JPanel();
        nameLabel2 = new JLabel();
        dateLabel2 = new JLabel();
        scrollPane2 = new JScrollPane();
        panel5 = new JPanel();
        this2 = new JPanel();
        submitButton = new JButton();
        questionLabel = new JLabel();
        questionNumber = new JLabel();
        answer = new JLabel();
        gradeField = new JTextField();
        label2 = new JLabel();
        exitButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(182, 142, 185));
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
            EmptyBorder(0,0,0,0), "",javax.swing.border.TitledBorder.CENTER,javax.swing
            .border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),
            java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener()
            {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))
            throw new RuntimeException();}});

            //---- examName ----
            examName.setText("CS434 Midterm");
            examName.setForeground(Color.white);
            examName.setFont(new Font("Roboto Light", Font.PLAIN, 18));

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(Color.white);
                scrollPane1.setForeground(Color.white);

                //======== panel2 ========
                {

                    //======== panel3 ========
                    {
                        panel3.setBackground(Color.white);

                        //---- studentName ----
                        studentName.setText("Zeliha Ayd\u0131n S018460");
                        studentName.setForeground(new Color(177, 184, 202));
                        studentName.setFont(new Font("Roboto Light", Font.BOLD, 25));

                        //---- reviewButton ----
                        reviewButton.setText("Review");
                        reviewButton.setBackground(Color.white);
                        reviewButton.addActionListener(e -> reviewButton(e));

                        GroupLayout panel3Layout = new GroupLayout(panel3);
                        panel3.setLayout(panel3Layout);
                        panel3Layout.setHorizontalGroup(
                            panel3Layout.createParallelGroup()
                                .addGroup(panel3Layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(studentName)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                                    .addComponent(reviewButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addGap(70, 70, 70))
                        );
                        panel3Layout.setVerticalGroup(
                            panel3Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                    .addContainerGap(27, Short.MAX_VALUE)
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentName)
                                        .addComponent(reviewButton))
                                    .addGap(22, 22, 22))
                        );
                    }

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(159, Short.MAX_VALUE))
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(250, Short.MAX_VALUE))
                    );
                }
                scrollPane1.setViewportView(panel2);
            }

            //---- exitButton2 ----
            exitButton2.setText("Back");
            exitButton2.addActionListener(e -> backbutton(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap(524, Short.MAX_VALUE)
                                .addComponent(exitButton2))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(examName)))))
                        .addGap(26, 26, 26))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(examName)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton2)
                        .addContainerGap())
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
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== frame1 ========
        {
            var frame1ContentPane = frame1.getContentPane();

            //======== panel4 ========
            {
                panel4.setBackground(new Color(182, 142, 185));
                panel4.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
                . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing
                .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
                Font ( "D\u0069al\u006fg", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
                ) ,panel4. getBorder () ) ); panel4. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
                public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er" .equals ( e. getPropertyName (
                ) ) )throw new RuntimeException( ) ;} } );

                //---- nameLabel2 ----
                nameLabel2.setText("Zeliha Ayd\u0131n S018460");
                nameLabel2.setForeground(Color.white);
                nameLabel2.setHorizontalAlignment(SwingConstants.LEFT);
                nameLabel2.setFont(new Font("Roboto Thin", Font.PLAIN, 18));

                //---- dateLabel2 ----
                dateLabel2.setText("CS434 Midterm");
                dateLabel2.setForeground(Color.white);
                dateLabel2.setFont(new Font("Roboto Light", Font.PLAIN, 18));

                //======== scrollPane2 ========
                {
                    scrollPane2.setBackground(Color.white);
                    scrollPane2.setForeground(Color.white);

                    //======== panel5 ========
                    {

                        //======== this2 ========
                        {
                            this2.setBackground(Color.white);

                            //---- submitButton ----
                            submitButton.setText("Submit");

                            //---- questionLabel ----
                            questionLabel.setText("question");

                            //---- questionNumber ----
                            questionNumber.setText("2.");

                            //---- answer ----
                            answer.setText("text");

                            //---- gradeField ----
                            gradeField.setBackground(Color.white);

                            //---- label2 ----
                            label2.setText("Grade:");

                            GroupLayout this2Layout = new GroupLayout(this2);
                            this2.setLayout(this2Layout);
                            this2Layout.setHorizontalGroup(
                                this2Layout.createParallelGroup()
                                    .addGroup(this2Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(this2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(this2Layout.createSequentialGroup()
                                                .addComponent(label2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(95, 95, 95)
                                                .addComponent(submitButton))
                                            .addGroup(this2Layout.createSequentialGroup()
                                                .addComponent(questionNumber)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(this2Layout.createParallelGroup()
                                                    .addComponent(questionLabel)
                                                    .addComponent(answer, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE))
                                                .addGap(153, 153, 153)))
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                            this2Layout.setVerticalGroup(
                                this2Layout.createParallelGroup()
                                    .addGroup(this2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(this2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(questionLabel)
                                            .addComponent(questionNumber))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(answer, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                        .addGroup(this2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(submitButton)
                                            .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label2))
                                        .addContainerGap())
                            );
                        }

                        GroupLayout panel5Layout = new GroupLayout(panel5);
                        panel5.setLayout(panel5Layout);
                        panel5Layout.setHorizontalGroup(
                            panel5Layout.createParallelGroup()
                                .addGroup(panel5Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(this2, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(96, Short.MAX_VALUE))
                        );
                        panel5Layout.setVerticalGroup(
                            panel5Layout.createParallelGroup()
                                .addGroup(panel5Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(this2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(135, Short.MAX_VALUE))
                        );
                    }
                    scrollPane2.setViewportView(panel5);
                }

                //---- exitButton ----
                exitButton.setText("Exit");
                exitButton.addActionListener(e -> exitButton(e));

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(panel4Layout.createParallelGroup()
                                .addGroup(panel4Layout.createSequentialGroup()
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(26, Short.MAX_VALUE))
                                .addGroup(panel4Layout.createSequentialGroup()
                                    .addComponent(exitButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                                    .addComponent(nameLabel2, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                    .addGap(81, 81, 81)
                                    .addComponent(dateLabel2)
                                    .addGap(26, 26, 26))))
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(dateLabel2)
                                .addComponent(nameLabel2)
                                .addComponent(exitButton))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(9, Short.MAX_VALUE))
                );
            }

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createParallelGroup()
                        .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(0, 628, Short.MAX_VALUE)
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createParallelGroup()
                        .addComponent(panel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(0, 351, Short.MAX_VALUE)
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
    private JPanel panel1;
    private JLabel examName;
    private JScrollPane scrollPane1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel studentName;
    private JButton reviewButton;
    private JButton exitButton2;
    private JFrame frame1;
    private JPanel panel4;
    private JLabel nameLabel2;
    private JLabel dateLabel2;
    private JScrollPane scrollPane2;
    private JPanel panel5;
    private JPanel this2;
    private JButton submitButton;
    private JLabel questionLabel;
    private JLabel questionNumber;
    private JLabel answer;
    private JTextField gradeField;
    private JLabel label2;
    private JButton exitButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
