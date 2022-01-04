package View.StudentsQuestion;

import java.awt.event.*;
import Model.QuestionModel;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Wed Dec 15 20:28:19 EET 2021
 */



public class TrueFalseQuestion extends JPanel {

    public int questionId;
    public int examId;
    public int userType;
    public int userId;

    public TrueFalseQuestion(int id, int examId,int userType,int userId) {
        this.questionId =id;
        this.examId = examId;
        this.userType = userType;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setQuestion(int qId ){
        QuestionModel model = new QuestionModel();
        questionLabel.setText(model.getQuestion(qId));
    }
    
    public void setNumber(String number){
        label1.setText(number);
    }

    private void save(ActionEvent e) {
        if(userType == 0) {
            QuestionModel model = new QuestionModel();
            if (trueCheck.isEnabled()) {
                model.addUserAnswer("True", getUserId(), getQuestionId());

            } else if (falseCheck.isEnabled()) {
                model.addUserAnswer("False", getUserId(), getQuestionId());

            }
        }
        else{
            getGradeForQuestion();
        }
    }

    public void setAnswerForReview(int questionId, int userId){
        QuestionModel model = new QuestionModel();
        String answer =  model.getUserAnswer(userId, questionId);
        System.out.println(answer);
        trueCheck.setEnabled(false);
        falseCheck.setEnabled(false);
        if(answer.equals(trueCheck.getText())){
            trueCheck.setSelected(true);
        }
        else if(answer.equals(falseCheck.getText())) {
            falseCheck.setSelected(true);
        }
    }
    public void removeGradeFieldForStudent(){
        gradeField.setEnabled(false);
    }

    public void removeGrade(){
        gradeField.setVisible(false);
        gradeLabel.setVisible(false);
    }

    public double getGradeForQuestion(){
        return Double.parseDouble(gradeField.getText());
    }

    private void initComponents() {
        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yasemin Orhun
        trueCheck = new JCheckBox();
        falseCheck = new JCheckBox();
        questionLabel = new JLabel();
        label1 = new JLabel();
        save = new JButton();
        gradeLabel = new JLabel();
        gradeField = new JTextField();

        //======== this ========
        setBackground(Color.white);
        setBorder(LineBorder.createBlackLineBorder());
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
        .swing.border.EmptyBorder(0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax.swing
        .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
        Font("D\u0069al\u006fg",java.awt.Font.BOLD,12),java.awt.Color.red
        ), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
        public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062or\u0064er".equals(e.getPropertyName(
        )))throw new RuntimeException();}});

        //---- trueCheck ----
        trueCheck.setText("True");
        trueCheck.setBackground(Color.white);

        //---- falseCheck ----
        falseCheck.setText("False");
        falseCheck.setBackground(Color.white);

        //---- questionLabel ----
        questionLabel.setText("question");

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
                    .addGap(41, 41, 41)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label1)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(falseCheck, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trueCheck, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(gradeLabel)
                                        .addGap(6, 6, 6)
                                        .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(save))
                            .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 589, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(questionLabel)
                    .addGap(18, 18, 18)
                    .addComponent(trueCheck)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(falseCheck)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(gradeLabel))
                                .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(17, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                            .addComponent(save)
                            .addGap(17, 17, 17))))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yasemin Orhun
    private JCheckBox trueCheck;
    private JCheckBox falseCheck;
    private JLabel questionLabel;
    private JLabel label1;
    private JButton save;
    private JLabel gradeLabel;
    private JTextField gradeField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
