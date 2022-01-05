/*
 * Created by JFormDesigner on Fri Dec 17 10:29:26 EET 2021
 */

package View;

import Controller.ExamController.Examination;
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


public class StudentsReviewPage extends JFrame {
    public String studentName;
    public int examId;
    public int studentId;
    public int userType;

    public StudentsReviewPage(int studentId, String studentName, int examId, int userType) {
        this.studentName = studentName;
        this.examId = examId;
        this.studentId = studentId;
        this.userType =userType;
        initComponents();
        nameLabelPropertyChange();
        setExamName();
        addQuestion(examId);
    }

    public int getUserType() {
        return userType;
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
        Examination examination = model.getExam(getExamId());
        nameLabel2.setText(examination.getName());
    }

    private void doneButtonOnClicked(ActionEvent e) {
        if(userType == 0){
            this.dispose();
        }
        else{
            ExamModel model = new ExamModel();
            model.setGraded(getExamId(),getStudentId());
            model.setExamGrade(getExamId(),getStudentId());
            this.dispose();
        }
    }

    public void addQuestion(int examId ){
        QuestionModel questionModel = new QuestionModel();
        ArrayList<Integer> questionID = questionModel.getQuestionIds(examId);
        panel2.setLayout(new GridLayout(questionID.size(), 1));
        for(int i = 0; i< questionID.size();i++){
            if(questionModel.getQuestionType(questionID.get(i)).equals( "text")){
                TextQuestion question = new TextQuestion(questionID.get(i), examId,getUserType(),getStudentId());
                question.setNumber(String.valueOf(i+1));
                question.setAnswerForReview(questionID.get(i),getStudentId());
                if(userType == 0){
                    question.removeGradeFieldForStudent();
                }                panel2.add(question);
            }

            else if(questionModel.getQuestionType(questionID.get(i)).equals("multiple_choice")) {
                MultipleQuestion question = new MultipleQuestion(questionID.get(i), examId,getUserType(),getStudentId());
                question.setNumber(String.valueOf(i+1));
                question.setAnswerForReview(questionID.get(i),getStudentId());
                if(userType == 0){
                    question.disableGradeFieldForStudent();
                }
                panel2.add(question);
            }

            else if(questionModel.getQuestionType(questionID.get(i)).equals("true_false")){
                TrueFalseQuestion question = new TrueFalseQuestion(questionID.get(i), examId,getUserType(),getStudentId());
                question.setNumber(String.valueOf(i+1));
                question.setAnswerForReview(questionID.get(i),getStudentId());
                if(userType == 0){
                    question.removeGradeFieldForStudent();
                }
                panel2.add(question);
            }

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yasemin Orhun
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
            panel1.setBackground(new Color(103, 137, 171));
            panel1.setPreferredSize(new Dimension(863, 576));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- nameLabel ----
            nameLabel.setText("Student Name");
            nameLabel.setForeground(Color.white);
            nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            nameLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
            nameLabel.setBackground(Color.white);

            //---- nameLabel2 ----
            nameLabel2.setText("CS434 Midterm 1");
            nameLabel2.setForeground(Color.white);
            nameLabel2.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel2.setFont(new Font("Roboto", Font.PLAIN, 18));
            nameLabel2.setHorizontalTextPosition(SwingConstants.RIGHT);
            nameLabel2.setBackground(Color.white);

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
            doneButton.setBackground(Color.white);
            doneButton.addActionListener(e -> doneButtonOnClicked(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addGap(147, 147, 147)
                                .addComponent(nameLabel2, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(369, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(scrollPane1)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(doneButton)))
                                .addGap(29, 29, 29))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(nameLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doneButton)
                        .addGap(27, 27, 27))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
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
    private JLabel nameLabel;
    private JLabel nameLabel2;
    private JScrollPane scrollPane1;
    private JPanel panel2;
    private JButton doneButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
