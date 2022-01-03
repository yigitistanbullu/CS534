/*
 * Created by JFormDesigner on Fri Dec 17 10:29:26 EET 2021
 */

package View;

import Controller.ExamController.Exam;
import Model.AuthorizationModel;
import Model.ExamModel;
import Model.QuestionModel;
import View.StudentsQuestion.MultipleQuestion;
import View.StudentsQuestion.TextQuestion;
import View.StudentsQuestion.TrueFalseQuestion;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Zeliha Aydın
 */
public class StudentsReviewPage extends JFrame {
    public String studentName;
    public int examId;
    public int studentId;

    public StudentsReviewPage(int studentId, String studentName, int examId) {
        this.studentName = studentName;
        this.examId = examId;
        this.studentId = studentId;
        initComponents();
        nameLabelPropertyChange();
        setExamName();
        addQuestion(examId);
    }

    public int getExamId() {
        return examId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    private void nameLabelPropertyChange() {
        nameLabel.setText(getStudentName());
    }

    private void setExamName(){
        ExamModel model = new ExamModel();
        Exam exam = model.getExam(getExamId());
        nameLabel2.setText(exam.getName());
    }

    private void doneButtonOnClicked(ActionEvent e) {
        StudentsHomePage homePage = new StudentsHomePage(getStudentId(),getStudentName(),1);
        homePage.setVisible(true);
        homePage.setLocationRelativeTo(null);
        this.dispose();
    }

    public void addQuestion(int examId ){
        QuestionModel questionModel = new QuestionModel();
        ArrayList<Integer> questionID = questionModel.getQuestionIds(examId);
        panel2.setLayout(new GridLayout(questionID.size(), 1));
        for(int i = 0; i< questionID.size();i++){
            if(questionModel.getQuestionType(questionID.get(i)).equals( "text")){
                TextQuestion question = new TextQuestion(questionID.get(i), examId);
                question.setNumber(String.valueOf(i+1));
                question.setAnswerForReview(questionID.get(i));
                question.removeSave();
                panel2.add(question);
            }
            else if(questionModel.getQuestionType(questionID.get(i)).equals("multiple_choice")) {
                MultipleQuestion question = new MultipleQuestion(questionID.get(i), examId);
                question.setNumber(String.valueOf(i+1));
                question.setAnswerForReview(questionID.get(i));
                question.removeSave();
                panel2.add(question);

            }
            else if(questionModel.getQuestionType(questionID.get(i)).equals("true_false")){
                TrueFalseQuestion question = new TrueFalseQuestion(questionID.get(i), examId);
                question.setNumber(String.valueOf(i+1));
                question.setAnswerForReview(questionID.get(i));
                question.removeSave();
                panel2.add(question);
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        panel1 = new JPanel();
        nameLabel = new JLabel();
        nameLabel2 = new JLabel();
        scrollPane1 = new JScrollPane();
        panel2 = new JPanel();
        doneButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(113, 188, 255));
            panel1.setForeground(Color.white);
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) )
            ; panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;

            //---- nameLabel ----
            nameLabel.setText("Zeliha Ayd\u0131n");
            nameLabel.setForeground(Color.white);
            nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            nameLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 18));

            //---- nameLabel2 ----
            nameLabel2.setText("CS434 Midterm 1");
            nameLabel2.setForeground(Color.white);
            nameLabel2.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel2.setFont(new Font("Roboto Thin", Font.BOLD, 20));
            nameLabel2.setHorizontalTextPosition(SwingConstants.RIGHT);

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(Color.white);
                scrollPane1.setForeground(Color.white);

                //======== panel2 ========
                {
                    panel2.setLayout(new GridLayout());
                }
                scrollPane1.setViewportView(panel2);
            }

            //---- doneButton ----
            doneButton.setText("Done");
            doneButton.setBackground(new Color(113, 188, 255));
            doneButton.addActionListener(e -> doneButtonOnClicked(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap(815, Short.MAX_VALUE)
                                .addComponent(doneButton))
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                        .addGap(203, 203, 203)
                                        .addComponent(nameLabel2, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)))))
                        .addGap(20, 20, 20))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(nameLabel2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(doneButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
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
    private JLabel nameLabel;
    private JLabel nameLabel2;
    private JScrollPane scrollPane1;
    private JPanel panel2;
    private JButton doneButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
