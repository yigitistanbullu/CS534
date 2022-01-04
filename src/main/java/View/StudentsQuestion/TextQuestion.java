package View.StudentsQuestion;

import java.awt.event.*;
import javax.swing.border.*;
import Controller.ExamController.Exam;
import Model.ExamModel;
import Model.QuestionModel;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Dec 15 20:21:28 EET 2021
 */



public class TextQuestion extends JPanel {

    public int questionId;
    public int examId;

    public TextQuestion(int id, int examId) {
        this.questionId =id;
        this.examId =examId;
        initComponents();
        setQuestion(id);
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public ExamModel examModel = new ExamModel();

    public void setQuestion(int qId){
        QuestionModel model = new QuestionModel();
        questionLabel.setText(model.getQuestion(qId));
    }

    public void removeGrade(){
        gradeField.setVisible(false);
        gradeLabel.setVisible(false);
    }

    public void setNumber(String number){
        label1.setText(number);
    }

    private void save(ActionEvent e) {
        QuestionModel model = new QuestionModel();
        model.setSelectedAnswer(getExamId(),getQuestionId(),answerField.getText());
    }

    public void setAnswerForReview(int questionId){
        QuestionModel model = new QuestionModel();
        String answer =  model.getSelectedAnswer(questionId);
        answerField.setEnabled(false);
        answerField.setText(answer);
    }

    public void removeSave(){
        save.setVisible(false);
        gradeField.setEnabled(false);
    }

    private void initComponents() {
        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yasemin
        questionLabel = new JLabel();
        answerField = new JTextField();
        enterAnswer = new JLabel();
        label1 = new JLabel();
        save = new JButton();
        gradeLabel = new JLabel();
        gradeField = new JTextField();

        //======== this ========
        setBackground(Color.white);
        setBorder(LineBorder.createBlackLineBorder());
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
        .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax
        . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,
        12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans
        .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e.
        getPropertyName () ) )throw new RuntimeException( ) ;} } );

        //---- questionLabel ----
        questionLabel.setText("question");

        //---- answerField ----
        answerField.setBackground(Color.white);

        //---- enterAnswer ----
        enterAnswer.setText("Enter answer here");

        //---- label1 ----
        label1.setText("1");

        //---- save ----
        save.setText("save");
        save.addActionListener(e -> save(e));

        //---- gradeLabel ----
        gradeLabel.setText("Grade:");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label1, GroupLayout.Alignment.LEADING)
                                .addComponent(questionLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
                                .addComponent(enterAnswer, GroupLayout.Alignment.LEADING))
                            .addContainerGap(38, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(answerField, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(gradeLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                    .addGap(423, 423, 423)
                                    .addComponent(save)))
                            .addGap(0, 32, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(enterAnswer)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(answerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(save)
                        .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(gradeLabel))
                    .addContainerGap(21, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - yasemin
    private JLabel questionLabel;
    private JTextField answerField;
    private JLabel enterAnswer;
    private JLabel label1;
    private JButton save;
    private JLabel gradeLabel;
    private JTextField gradeField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
