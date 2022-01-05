package View.ExamQuestions;

import java.awt.event.*;
import javax.swing.border.*;

import Model.QuestionModel;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Dec 15 20:21:28 EET 2021
 */



public class TextQuestion extends JPanel implements Question{

    public int questionId;
    public int examId;
    public int userType;
    public int userId;
    public String questionNumber;

    public TextQuestion (Builder builder) {
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

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setComponents(int qId){
        QuestionModel model = new QuestionModel();
        questionLabel.setText(model.getQuestion(qId));
        point.setText("(" + String.valueOf(model.getAvailablePoints(getQuestionId())) + ")");
        label1.setText(getQuestionNumber());

    }

    public void removeGrade(){
        gradeField.setVisible(false);
        gradeLabel.setVisible(false);
    }

    public void removeGradeFieldForStudent(){
        gradeField.setEnabled(false);
    }

    private void save(ActionEvent e) {
        QuestionModel model = new QuestionModel();
        if(userType == 0){
            model.addUserAnswer(answerField.getText(), getUserId(), getQuestionId(),getExamId());
        }
        else{
            double grade = Double.parseDouble(gradeField.getText());
            model.setPointsByInstructor(getUserId(),getQuestionId(),grade);
            gradeField.setText(model.getPointsEarned(getUserId(),getQuestionId()));
        }
    }

    public void setAnswerForReview(int questionId, int userId){
        QuestionModel model = new QuestionModel();
        String answer =  model.getUserAnswer(userId,questionId);
        answerField.setEnabled(false);
        answerField.setText(answer);
        gradeField.setText(model.getPointsEarned(getUserId(),getQuestionId()));
        if(userType == 1){
            save.setText("Save Grade");
        }
        else{
            save.setVisible(false);
        }
    }

    @Override
    public void removeGradeForExamination() {
        gradeField.setVisible(false);
        gradeLabel.setVisible(false);
    }

    @Override
    public void disableGradeFieldForStudent() {
        gradeField.setEnabled(false);
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

        public Builder withUserType(int userType) {
            this.userType = userType;
            return this;
        }

        public Builder withQuestionNumber(String questionNumber) {
            this.questionNumber = questionNumber;
            return this;
        }


        public TextQuestion build() {
            return new TextQuestion(this);
        }
    }

    private void initComponents() {
        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        questionLabel = new JLabel();
        answerField = new JTextField();
        enterAnswer = new JLabel();
        label1 = new JLabel();
        save = new JButton();
        gradeLabel = new JLabel();
        gradeField = new JTextField();
        point = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder(LineBorder.createBlackLineBorder());
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
        0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
        .BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.
        red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
        beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}});

        //---- questionLabel ----
        questionLabel.setText("question");
        questionLabel.setForeground(new Color(51, 51, 51));

        //---- answerField ----
        answerField.setBackground(Color.white);

        //---- enterAnswer ----
        enterAnswer.setText("Enter answer here");
        enterAnswer.setForeground(Color.lightGray);

        //---- label1 ----
        label1.setText("1");
        label1.setForeground(new Color(103, 137, 171));
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));

        //---- save ----
        save.setText("save");
        save.setForeground(new Color(103, 137, 171));
        save.setBackground(Color.white);
        save.addActionListener(e -> save(e));

        //---- gradeLabel ----
        gradeLabel.setText("Grade:");

        //---- gradeField ----
        gradeField.setBackground(Color.white);
        gradeField.setForeground(Color.red);

        //---- point ----
        point.setText("Points");
        point.setFont(point.getFont().deriveFont(point.getFont().getStyle() | Font.BOLD, point.getFont().getSize() - 3f));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(587, Short.MAX_VALUE)
                            .addComponent(save))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(answerField, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(enterAnswer)
                                        .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 35, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(point, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 422, Short.MAX_VALUE)
                                    .addComponent(gradeLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)))))
                    .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(point)
                                .addComponent(label1))
                            .addGap(19, 19, 19))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(gradeLabel))
                            .addGap(18, 18, 18)))
                    .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(enterAnswer)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(answerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                    .addComponent(save)
                    .addGap(19, 19, 19))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
    private JLabel questionLabel;
    private JTextField answerField;
    private JLabel enterAnswer;
    private JLabel label1;
    private JButton save;
    private JLabel gradeLabel;
    private JTextField gradeField;
    private JLabel point;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
