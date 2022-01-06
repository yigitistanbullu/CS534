package View.ExamQuestions;

import java.awt.event.*;
import Model.QuestionModel;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Wed Dec 15 20:23:44 EET 2021
 */


public class MultipleQuestion extends JPanel implements Question{

    public int questionId;
    public int examId;
    public int userType;
    public int userId;
    public String questionNumber;

    public MultipleQuestion (Builder builder) {
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
        question.setText(model.getQuestion(qId));
        ArrayList<String> answers = model.getQuestionAnswers(qId);
        aAnswer.setText(answers.get(0));
        bAnswer.setText(answers.get(1));
        cAnswer.setText(answers.get(2));
        point.setText("(" + String.valueOf(model.getAvailablePoints(getQuestionId())) + ")");
        label1.setText(getQuestionNumber());
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
    }

    public void setAnswerForReview(int questionId, int userId){
        QuestionModel model = new QuestionModel();
        String answer =  model.getUserAnswer(userId,questionId);
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
            save.setText("Save Grade");
            model.setPointsBySystem(getUserId(), getQuestionId());
            gradeField.setText(model.getPointsEarned(getUserId(), getQuestionId()));
        }
        else{
            save.setVisible(false);
        }
    }

    public void disableGradeFieldForStudent(){
        gradeField.setEnabled(false);
    }

    public void removeGradeForExamination(){
        gradeField.setVisible(false);
        gradeLabel.setVisible(false);
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


        public MultipleQuestion build() {
            return new MultipleQuestion(this);
        }
    }

    private void initComponents() {
        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
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
        point = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder(LineBorder.createBlackLineBorder());
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;

        //---- question ----
        question.setText("question");
        question.setFont(question.getFont().deriveFont(question.getFont().getStyle() | Font.BOLD));
        question.setForeground(new Color(51, 51, 51));

        //---- aAnswer ----
        aAnswer.setText("answer");
        aAnswer.setForeground(new Color(51, 51, 51));

        //---- bAnswer ----
        bAnswer.setText("answer");
        bAnswer.setForeground(new Color(51, 51, 51));

        //---- cAnswer ----
        cAnswer.setText("answer");
        cAnswer.setForeground(new Color(51, 51, 51));

        //---- radioButton1 ----
        radioButton1.setText("a.");
        radioButton1.setBackground(Color.white);
        radioButton1.setForeground(new Color(51, 51, 51));
        radioButton1.setFont(radioButton1.getFont().deriveFont(radioButton1.getFont().getStyle() | Font.BOLD));

        //---- radioButton2 ----
        radioButton2.setText("b.");
        radioButton2.setBackground(Color.white);
        radioButton2.setForeground(new Color(51, 51, 51));
        radioButton2.setFont(radioButton2.getFont().deriveFont(radioButton2.getFont().getStyle() | Font.BOLD));

        //---- radioButton3 ----
        radioButton3.setText("c.");
        radioButton3.setBackground(Color.white);
        radioButton3.setForeground(new Color(51, 51, 51));
        radioButton3.setFont(radioButton3.getFont().deriveFont(radioButton3.getFont().getStyle() | Font.BOLD));

        //---- label1 ----
        label1.setText("1");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));
        label1.setForeground(new Color(103, 137, 171));

        //---- save ----
        save.setText("Save");
        save.setBackground(Color.white);
        save.setForeground(new Color(103, 137, 171));
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
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 560, Short.MAX_VALUE)
                                    .addComponent(save))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(point, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 426, Short.MAX_VALUE)
                                    .addComponent(gradeLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createParallelGroup()
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radioButton1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(aAnswer, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(radioButton3)
                                            .addComponent(radioButton2))
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup()
                                            .addComponent(bAnswer, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cAnswer, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))))
                                .addComponent(question, GroupLayout.PREFERRED_SIZE, 593, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(gradeLabel))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                            .addComponent(point)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(question, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButton1)
                        .addComponent(aAnswer, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButton2)
                        .addComponent(bAnswer, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                    .addGap(3, 3, 3)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButton3)
                        .addComponent(cAnswer, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(save)
                    .addGap(19, 19, 19))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
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
    private JLabel point;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}