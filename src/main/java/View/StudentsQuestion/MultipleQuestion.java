package View.StudentsQuestion;

import java.awt.event.*;
import Model.QuestionModel;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Wed Dec 15 20:23:44 EET 2021
 */


public class MultipleQuestion extends JPanel {

    public int questionId;
    public int examId;
    public int userType;
    public int userId;

    public MultipleQuestion (int id, int examId, int userType, int userId) {
        this.questionId =id;
        this.examId =examId;
        this.userType = userType;
        this.userId = userId;
        initComponents();
        setQuestion(id);
        setAnswerOptions(id);
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

    public int getUserId() {
        return userId;
    }

    public void setQuestion(int qId ){
        QuestionModel model = new QuestionModel();
        question.setText(model.getQuestion(qId));
    }

    public void setAnswerOptions(int qId){
        QuestionModel model = new QuestionModel();
        ArrayList<String> answers = model.getQuestionAnswers(qId);
        aAnswer.setText(answers.get(0));
        bAnswer.setText(answers.get(1));
        cAnswer.setText(answers.get(2));
    }

    public void setAnswerForReview(int questionId, int userId){
        QuestionModel model = new QuestionModel();
        String answer =  model.getUserAnswer(userId,questionId);
        System.out.println(answer);
        radioButton1.setEnabled(false);
        radioButton2.setEnabled(false);
        radioButton3.setEnabled(false);
        if(answer.equals(aAnswer.getText())){
            radioButton1.setSelected(true);
        }
        else if(answer.equals(bAnswer.getText())){
            radioButton2.setSelected(true);
        }
        else if(answer.equals(cAnswer.getText())){
            radioButton3.setSelected(true);
        }

        gradeField.setText(model.getPointsEarned(getUserId(),getQuestionId()));

        if(userType == 1) {
            model.setPointsBySystem(getUserId(), getQuestionId());
            gradeField.setText(model.getPointsEarned(getUserId(), getQuestionId()));
        }
    }

    public void disableGradeFieldForStudent(){
        gradeField.setEnabled(false);
    }

    public void removeGradeForExamination(){
        gradeField.setVisible(false);
        gradeLabel.setVisible(false);
    }

    public void setNumber(String number){
        label1.setText(number);
    }

    private void save(ActionEvent e) {
        QuestionModel model = new QuestionModel();

        if(userType == 0) {
            if (radioButton1.isSelected()) {
                model.addUserAnswer(aAnswer.getText(), getUserId(), getQuestionId(),getExamId());
            } else if (radioButton2.isSelected()) {
                model.addUserAnswer(bAnswer.getText(), getUserId(), getQuestionId(),getExamId());
            } else if (radioButton3.isSelected()) {
                model.addUserAnswer(cAnswer.getText(), getUserId(), getQuestionId(),getExamId());
            }
        }
        else{
            double grade = Double.parseDouble(gradeField.getText());
            model.setPointsByInstructor(getUserId(),getQuestionId(),grade);
            gradeField.setText(model.getPointsEarned(getUserId(),getQuestionId()));
        }
    }

    private void initComponents() {
        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yasemin Orhun
        question = new JLabel();
        aAnswer = new JLabel();
        bAnswer = new JLabel();
        cAnswer = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        label1 = new JLabel();
        save = new JButton();
        gradeLabel = new JLabel();
        gradeField = new JTextField();

        //======== this ========
        setBackground(Color.white);
        setBorder(LineBorder.createBlackLineBorder());
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0
        ,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
        ,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red),
         getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
        ){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}});

        //---- question ----
        question.setText("question");

        //---- aAnswer ----
        aAnswer.setText("answer");

        //---- bAnswer ----
        bAnswer.setText("answer");

        //---- cAnswer ----
        cAnswer.setText("answer");

        //---- radioButton1 ----
        radioButton1.setText("a.");
        radioButton1.setBackground(Color.white);

        //---- radioButton2 ----
        radioButton2.setText("b.");
        radioButton2.setBackground(Color.white);

        //---- radioButton3 ----
        radioButton3.setText("c.");
        radioButton3.setBackground(Color.white);

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
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(radioButton1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(aAnswer, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))
                        .addComponent(question, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(radioButton3)
                                    .addComponent(radioButton2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(gradeLabel)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(cAnswer, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bAnswer, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 533, Short.MAX_VALUE)
                                    .addComponent(save)))))
                    .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(question, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(aAnswer, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addComponent(radioButton1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButton2)
                        .addComponent(bAnswer, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                    .addGap(3, 3, 3)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButton3)
                        .addComponent(cAnswer, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(gradeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(27, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                            .addComponent(save)
                            .addGap(18, 18, 18))))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yasemin Orhun
    private JLabel question;
    private JLabel aAnswer;
    private JLabel bAnswer;
    private JLabel cAnswer;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JLabel label1;
    private JButton save;
    private JLabel gradeLabel;
    private JTextField gradeField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
