/*
 * Created by JFormDesigner on Wed Jan 05 14:02:06 EET 2022
 */

package View.ExamQuestions;

import Model.QuestionModel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Zeliha Aydın
 */
public class MultipleSelection extends JPanel {
    public int questionId;
    public int examId;
    public int userType;
    public int userId;
    public String questionNumber;

    public MultipleSelection(MultipleSelection.Builder builder) {
        this.questionId =builder.questionId;
        this.examId =builder.examId;
        this.userType = builder.userType;
        this.userId = builder.userId;
        this.questionNumber = builder.questionNumber;
        initComponents();
        setComponents(builder.questionId);
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
    public void setComponents(int qId){
        QuestionModel model = new QuestionModel();
        question.setText(model.getQuestion(qId));
        ArrayList<String> answers = model.getQuestionAnswers(qId);
        aAnswer.setText(answers.get(0));
        bAnswer.setText(answers.get(1));
        cAnswer.setText(answers.get(2));
        point.setText("(" + String.valueOf(model.getAvailablePoints(getQuestionId())) + ")");
        label1.setText(getQuestionNumber());

    }

    public void setAnswerOptions(int qId){
        QuestionModel model = new QuestionModel();
        ArrayList<String> answers = model.getQuestionAnswers(qId);
        aAnswer.setText(answers.get(0));
        bAnswer.setText(answers.get(1));
        cAnswer.setText(answers.get(2));
        point.setText("(" + String.valueOf(model.getAvailablePoints(getQuestionId())) + ")");
    }

    public void setAnswerForReview(int questionId, int userId){
        QuestionModel model = new QuestionModel();
        String answer =  model.getUserAnswer(userId,questionId);
        System.out.println(answer);
        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);
        if(answer.equals(aAnswer.getText())){
            checkBox1.setSelected(true);
        }
        if(answer.equals(bAnswer.getText())){
            checkBox2.setSelected(true);
        }
        if(answer.equals(cAnswer.getText())){
            checkBox3.setSelected(true);
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
    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setNumber(String number){
        label1.setText(number);
    }

    private void save(ActionEvent e) {
        QuestionModel model = new QuestionModel();

        if(userType == 0) {
            String answer = "";
            if (checkBox1.isSelected()) {
                answer += aAnswer.getText();
            }else if (checkBox2.isSelected()) {
                answer += bAnswer.getText();
            }else if (checkBox3.isSelected()) {
                answer+= cAnswer.getText();
            }
            model.addUserAnswer(answer, getUserId(), getQuestionId(),getExamId());
        }
        else{
            double grade = Double.parseDouble(gradeField.getText());
            model.setPointsByInstructor(getUserId(),getQuestionId(),grade);
            gradeField.setText(model.getPointsEarned(getUserId(),getQuestionId()));
        }
    }
    public static class Builder{
        public int questionId;
        public int examId;
        public int userType;
        public int userId;
        public String questionNumber;


        public Builder(int id, int examId, int userId) {
            this.questionId =id;
            this.examId =examId;
            this.userId = userId;

        }

        public MultipleSelection.Builder withUserType(int userType) {
            this.userType = userType;
            return this;
        }

        public MultipleSelection.Builder withQuestionNumber(String questionNumber) {
            this.questionNumber = questionNumber;
            return this;
        }

        public MultipleSelection build() {
            return new MultipleSelection(this);
        }
    }


        private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        question = new JLabel();
        aAnswer = new JLabel();
        bAnswer = new JLabel();
        cAnswer = new JLabel();
        label1 = new JLabel();
        save = new JButton();
        gradeLabel = new JLabel();
        gradeField = new JTextField();
        point = new JLabel();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();

        //======== this ========
        setBackground(Color.white);
        setBorder(LineBorder.createBlackLineBorder());
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
        javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax
        . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
        .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
        PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .
        equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- question ----
        question.setText("question");

        //---- aAnswer ----
        aAnswer.setText("answer");

        //---- bAnswer ----
        bAnswer.setText("answer");

        //---- cAnswer ----
        cAnswer.setText("answer");

        //---- label1 ----
        label1.setText("1");

        //---- save ----
        save.setText("save");
        save.addActionListener(e -> save(e));

        //---- gradeLabel ----
        gradeLabel.setText("Grade:");

        //---- point ----
        point.setText("Points");
        point.setFont(point.getFont().deriveFont(point.getFont().getStyle() | Font.BOLD, point.getFont().getSize() - 3f));

        //---- checkBox1 ----
        checkBox1.setText("1");

        //---- checkBox2 ----
        checkBox2.setText("2");

        //---- checkBox3 ----
        checkBox3.setText("3");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(gradeLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 533, Short.MAX_VALUE)
                            .addComponent(save))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(point, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                .addComponent(question, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(checkBox1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(aAnswer, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(checkBox2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bAnswer, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(checkBox3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cAnswer, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 126, Short.MAX_VALUE)))
                    .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(point))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(question, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(aAnswer, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkBox1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(checkBox2)
                        .addComponent(bAnswer, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                    .addGap(3, 3, 3)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(checkBox3)
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
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
    private JLabel question;
    private JLabel aAnswer;
    private JLabel bAnswer;
    private JLabel cAnswer;
    private JLabel label1;
    private JButton save;
    private JLabel gradeLabel;
    private JTextField gradeField;
    private JLabel point;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
