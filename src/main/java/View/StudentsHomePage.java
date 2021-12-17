package View;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.GroupLayout;

import Controller.ExamController.Exam;
import Model.AuthorizationModel;
import Model.ExamModel;
import Model.QuestionModel;
import View.StudentGradesPage;
import View.StudentsQuestion.MultipleQuestion;
import View.StudentsQuestion.QuestionsPage;
import View.StudentsQuestion.TextQuestion;
import View.StudentsQuestion.TrueFalseQuestion;
/*
 * Created by JFormDesigner on Wed Dec 15 19:07:28 EET 2021
 */



/**
 * @author Zeliha Aydın
 */
public class StudentsHomePage extends JFrame {
    public int id;
    public String name = "";
    AuthorizationModel model = new AuthorizationModel();
    Exam exam = new Exam(id,name,0.0);

    public StudentsHomePage(int id, String name) {
        this.id = id;
        this.name = name;
        initComponents();
        date();
        nameLabelPropertyChange();
        addQuestion(exam);
    }

    private void nameLabelPropertyChange() {
        nameLabel.setText(model.getName(id));
    }
    public void date(){
        dateLabel.setText("Date : " + new SimpleDateFormat("dd/MM/yyyy",new Locale("tr")).format(new Date()));
    }

    private void GradesButton(ActionEvent e) {
        StudentGradesPage grades = new StudentGradesPage(id,name);
        grades.setVisible(true);
        grades.setLocationRelativeTo(null);
        this.dispose();
    }

    private void attendButton(ActionEvent e) {
        QuestionsPage examPage = new QuestionsPage(exam, name);
        examPage.setVisible(true);
        examPage.setLocationRelativeTo(null);
        this.dispose();
    }

    private void reviewButton(ActionEvent e) {
        StudentsReviewPage reviewPage = new StudentsReviewPage(id,name);
        reviewPage.setVisible(true);
        reviewPage.setLocationRelativeTo(null);
        this.dispose();
    }
    public void addQuestion(Exam exam){
        ExamModel questionModel = new ExamModel();

        ArrayList<Integer> questionID = questionModel.getExamIds(exam.getId());
        System.out.println(questionID);
        panel2.setLayout(new GridLayout(questionID.size(), 1));
        for(int i = 0; i< questionID.size();i++){
                StudentGradePanel question = new StudentGradePanel(questionID.get(i));
                panel2.add(question);
        }
    }


    private void initComponents() {

        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        panel1 = new JPanel();
        nameLabel = new JLabel();
        dateLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        panel2 = new JPanel();
        panel3 = new JPanel();
        examLabel = new JLabel();
        attendButton = new JButton();
        reviewButton = new JButton();
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(182, 142, 185));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
            . swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing
            . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
            Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
            ) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
            public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName (
            ) )) throw new RuntimeException( ); }} );

            //---- nameLabel ----
            nameLabel.setText("Zeliha Ayd\u0131n S018460");
            nameLabel.setForeground(Color.white);
            nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            nameLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 18));

            //---- dateLabel ----
            dateLabel.setText("15.12.2021");
            dateLabel.setForeground(Color.white);
            dateLabel.setFont(new Font("Roboto Light", Font.PLAIN, 18));

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
                        attendButton.setText("Attend");
                        attendButton.setBackground(Color.white);
                        attendButton.addActionListener(e -> attendButton(e));

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
                                .addGap(15, 15, 15)
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(230, Short.MAX_VALUE))
                    );
                }
                scrollPane1.setViewportView(panel2);
            }

            //---- label1 ----
            label1.setText("Exams");
            label1.setForeground(Color.white);

            //---- button1 ----
            button1.setText("Grades");
            button1.setBackground(new Color(182, 142, 185));
            button1.setForeground(Color.darkGray);
            button1.setOpaque(false);
            button1.addActionListener(e -> GradesButton(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label1)
                                .addGap(18, 18, 18)
                                .addComponent(button1)
                                .addContainerGap(469, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
                                        .addComponent(dateLabel)))
                                .addGap(26, 26, 26))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(dateLabel))
                        .addGap(19, 19, 19)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(button1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
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
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
    private JPanel panel1;
    private JLabel nameLabel;
    private JLabel dateLabel;
    private JScrollPane scrollPane1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel examLabel;
    private JButton attendButton;
    private JButton reviewButton;
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
