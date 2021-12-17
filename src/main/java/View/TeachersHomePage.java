package View;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventListener;
import java.util.Locale;
import javax.swing.*;
import javax.swing.GroupLayout;

import Controller.ExamController.Exam;
import Model.AuthorizationModel;
import View.TeachersQuestion.QuestionsPageInstructor;
import View.TeacherGradingPage;
/*
 * Created by JFormDesigner on Wed Dec 15 19:40:10 EET 2021
 */



/**
 * @author Zeliha Aydın
 */
public class TeachersHomePage extends JFrame {
    AuthorizationModel  model = new AuthorizationModel();
    public int id;
    public int studentId;

    public TeachersHomePage(int id) {
        initComponents();
        this.id = id;
        nameLabelPropertyChange(id);
        date();
    }

    private void thisWindowActivated(WindowEvent e) {
        // TODO add your code here
    }

    private void reviewButton(ActionEvent e) {
        dispose();
        TeacherGradingPage review = new TeacherGradingPage(id, model.getName(id));
        review.setVisible(true);
        review.setLocationRelativeTo(null);
    }

    private void createExam(ActionEvent e) {
        dispose();
        QuestionsPageInstructor exam = new QuestionsPageInstructor();
        exam.setVisible(true);
        exam.setLocationRelativeTo(null);
    }

    private void nameLabelPropertyChange(int userId) {
        nameLabel.setText(model.getName(id));
    }
    public void date() {
        dateLabel.setText("Date : " + new SimpleDateFormat("dd/MM/yyyy", new Locale("tr")).format(new Date()));
    }

    private void nameLabelPropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void dateLabelPropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void Logout(ActionEvent e) {
        LoginView view = new LoginView();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        dispose();
    }


    private void initComponents() {
        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yasemin
        panel1 = new JPanel();
        nameLabel = new JLabel();
        dateLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        panel2 = new JPanel();
        panel3 = new JPanel();
        examLabel = new JLabel();
        attendButton = new JButton();
        reviewButton = new JButton();
        createExamButton = new JButton();
        Logout = new JButton();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                thisWindowActivated(e);
            }
        });
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(182, 142, 185));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

            //---- nameLabel ----
            nameLabel.setText("Emre Kaplan");
            nameLabel.setForeground(Color.white);
            nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            nameLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 18));
            nameLabel.addPropertyChangeListener(e -> nameLabelPropertyChange(e));

            //---- dateLabel ----
            dateLabel.setText("15.12.2021");
            dateLabel.setForeground(Color.white);
            dateLabel.setFont(new Font("Roboto Light", Font.PLAIN, 18));
            dateLabel.addPropertyChangeListener(e -> dateLabelPropertyChange(e));

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(Color.white);
                scrollPane1.setForeground(Color.white);

                //======== panel2 ========
                {

                    //======== panel3 ========
                    {
                        panel3.setBackground(Color.white);

                        //---- examLabel ----
                        examLabel.setText("cs434 Midterm");
                        examLabel.setForeground(new Color(177, 184, 202));
                        examLabel.setFont(new Font("Roboto Light", Font.BOLD, 25));

                        //---- attendButton ----
                        attendButton.setText("Edit");
                        attendButton.setBackground(Color.white);

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
                                    .addComponent(examLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                    .addComponent(attendButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(reviewButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addGap(22, 22, 22))
                        );
                        panel3Layout.setVerticalGroup(
                            panel3Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                    .addContainerGap(27, Short.MAX_VALUE)
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(examLabel)
                                        .addComponent(attendButton)
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
                                .addContainerGap(178, Short.MAX_VALUE))
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(220, Short.MAX_VALUE))
                    );
                }
                scrollPane1.setViewportView(panel2);
            }

            //---- createExamButton ----
            createExamButton.setText("Create Exam");
            createExamButton.addActionListener(e -> createExam(e));

            //---- Logout ----
            Logout.setText("Logout");
            Logout.addActionListener(e -> Logout(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Logout))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(createExamButton)
                                    .addComponent(dateLabel))
                                .addGap(28, 28, 28))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(dateLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(createExamButton)
                            .addComponent(Logout))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
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
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - yasemin
    private JPanel panel1;
    private JLabel nameLabel;
    private JLabel dateLabel;
    private JScrollPane scrollPane1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel examLabel;
    private JButton attendButton;
    private JButton reviewButton;
    private JButton createExamButton;
    private JButton Logout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
