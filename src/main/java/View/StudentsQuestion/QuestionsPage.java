package View.StudentsQuestion;

import java.awt.event.*;
import Controller.ExamController.Exam;
import Model.ExamModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Dec 15 20:52:11 EET 2021
 */



/**
 * @author Zeliha Aydın
 */
public class QuestionsPage extends JFrame {

    public Exam exam;
    public String name;
    ArrayList<String> questions = new ArrayList<>();

    public QuestionsPage(Exam exam, String name) {
        this.exam = exam;
        this.name = name;
        initComponents();

    }
    public void time(){
        new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
                time.setText("Time : " +sdf.format(new Date()));
            }
        }).start();
    }
    
    public void setExamName(){
        examName.setText(this.exam.getName());
    }

    public void setUserName(){
        userName.setText(this.name);
    }

    private void questionsShown(ComponentEvent e) {

        
    }

    private void initComponents() {
        setVisible(true);
        time();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yasemin
        panel1 = new JPanel();
        userName = new JLabel();
        examName = new JLabel();
        questionScrollPane = new JScrollPane();
        panel2 = new JPanel();
        panel3 = new JPanel();
        submitButton = new JButton();
        time = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder (
            0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder
            . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .
            red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java .
            beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //---- userName ----
            userName.setText("Zeliha Ayd\u0131n");
            userName.setForeground(Color.darkGray);
            userName.setHorizontalAlignment(SwingConstants.LEFT);
            userName.setFont(new Font("Roboto Thin", Font.PLAIN, 18));

            //---- examName ----
            examName.setText("CS434 Midterm 1");
            examName.setForeground(Color.darkGray);
            examName.setHorizontalAlignment(SwingConstants.CENTER);
            examName.setFont(new Font("Roboto Thin", Font.PLAIN, 18));
            examName.setHorizontalTextPosition(SwingConstants.RIGHT);

            //======== questionScrollPane ========
            {
                questionScrollPane.setBackground(Color.white);
                questionScrollPane.setForeground(Color.white);

                //======== panel2 ========
                {
                    panel2.addComponentListener(new ComponentAdapter() {
                        @Override
                        public void componentShown(ComponentEvent e) {
                            questionsShown(e);
                        }
                    });

                    //======== panel3 ========
                    {
                        panel3.setBackground(Color.white);

                        GroupLayout panel3Layout = new GroupLayout(panel3);
                        panel3.setLayout(panel3Layout);
                        panel3Layout.setHorizontalGroup(
                            panel3Layout.createParallelGroup()
                                .addGap(0, 615, Short.MAX_VALUE)
                        );
                        panel3Layout.setVerticalGroup(
                            panel3Layout.createParallelGroup()
                                .addGap(0, 49, Short.MAX_VALUE)
                        );
                    }

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(289, Short.MAX_VALUE))
                    );
                }
                questionScrollPane.setViewportView(panel2);
            }

            //---- submitButton ----
            submitButton.setText("Submit");
            submitButton.setBackground(Color.white);

            //---- time ----
            time.setText("23:45");
            time.setForeground(Color.darkGray);
            time.setHorizontalAlignment(SwingConstants.RIGHT);
            time.setFont(new Font("Roboto Thin", Font.PLAIN, 18));
            time.setHorizontalTextPosition(SwingConstants.RIGHT);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(userName, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(examName, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(time, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(questionScrollPane)
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(submitButton)))))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(userName)
                            .addComponent(examName)
                            .addComponent(time))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionScrollPane, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton)
                        .addContainerGap())
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
    private JLabel userName;
    private JLabel examName;
    private JScrollPane questionScrollPane;
    private JPanel panel2;
    private JPanel panel3;
    private JButton submitButton;
    private JLabel time;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
