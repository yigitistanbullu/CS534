/*
 * Created by JFormDesigner on Wed Jan 05 14:13:43 EET 2022
 */

package View.ExamQuestions;

import Model.QuestionModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Zeliha Aydın
 */
public class GapFillingQuestion extends JPanel implements Question {
    public int questionId;
    public int examId;
    public int userType;
    public int userId;
    public String questionNumber;

    public GapFillingQuestion(GapFillingQuestion.Builder builder) {
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

    public void setQuestion(int qId){
        QuestionModel model = new QuestionModel();
        String string = model.getQuestion(questionId);
        String partOne = string.substring(0,string.indexOf(" "));
        String partTwo = string.substring(string.indexOf(" ") + 1);
        partOneLabel.setText(partOne);
        partTwoLabel.setText(partTwo);
        point.setText("(" + String.valueOf(model.getAvailablePoints(getQuestionId())) + ")");
    }

    public String getQuestionNumber() {
        return questionNumber;
    }
    public void removeGrade(){
        gradeField.setVisible(false);
        gradeLabel.setVisible(false);
    }

    public void setNumber(String number){
        label1.setText(number);
    }
    QuestionModel model = new QuestionModel();

    @Override
    public void setComponents(int questionId) {
        QuestionModel model = new QuestionModel();
        String string = model.getQuestion(questionId);
        String partOne = string.substring(0,string.indexOf(" "));
        String partTwo = string.substring(string.indexOf(" ") + 1);
        partOneLabel.setText(partOne);
        partTwoLabel.setText(partTwo);
        point.setText("(" + String.valueOf(model.getAvailablePoints(getQuestionId())) + ")");
        label1.setText(getQuestionNumber());
    }

    @Override
    public void setAnswerForReview(int questionId, int userId) {
        QuestionModel model = new QuestionModel();
        String answer =  model.getUserAnswer(userId,questionId);
        if(answer.equalsIgnoreCase(model.getKeyAnswer(questionId))){
            answerField.setEnabled(false);
            answerField.setText(model.getUserAnswer(userId,questionId) + " (Correct)");
        }else{
            answerField.setText(model.getUserAnswer(userId,questionId) + " (False)");
        }

        gradeField.setText(model.getPointsEarned(getUserId(),getQuestionId()));

        if(userType == 1) {
            save.setText("Save Grade");
            model.setPointsBySystem(getUserId(), getQuestionId());
            gradeField.setText(model.getPointsEarned(getUserId(), getQuestionId()));
        }
    }

    public void save(ActionEvent e) {
        if(userType == 0){
            model.addUserAnswer(answerField.getText(), getUserId(), getQuestionId(),getExamId());
        }
        else{
            double grade = Double.parseDouble(gradeField.getText());
            model.setPointsByInstructor(getUserId(),getQuestionId(),grade);
            gradeField.setText(model.getPointsEarned(getUserId(),getQuestionId()));
        }
    }

    @Override
    public void removeGradeForExamination() {
        gradeField.setEnabled(false);
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

        public GapFillingQuestion.Builder withUserType(int userType) {
            this.userType = userType;
            return this;
        }

        public GapFillingQuestion.Builder withQuestionNumber(String questionNumber) {
            this.questionNumber = questionNumber;
            return this;
        }


        public GapFillingQuestion build() {
            return new GapFillingQuestion(this);
        }
    }

    private void initComponents() {
        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        answerField = new JTextField();
        partOneLabel = new JLabel();
        label1 = new JLabel();
        save = new JButton();
        gradeLabel = new JLabel();
        gradeField = new JTextField();
        point = new JLabel();
        partTwoLabel = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder(LineBorder.createBlackLineBorder());
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
        , 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
         getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- answerField ----
        answerField.setBackground(Color.white);

        //---- partOneLabel ----
        partOneLabel.setText("First part ");
        partOneLabel.setForeground(new Color(51, 51, 51));

        //---- label1 ----
        label1.setText("1");
        label1.setForeground(new Color(103, 137, 171));
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));

        //---- save ----
        save.setText("save");
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

        //---- partTwoLabel ----
        partTwoLabel.setText("Second part");
        partTwoLabel.setForeground(new Color(51, 51, 51));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(partTwoLabel)
                            .addGap(0, 589, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(18, 18, 18)
                                    .addComponent(point, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 437, Short.MAX_VALUE)
                                    .addComponent(gradeLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(partOneLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                                    .addComponent(answerField, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(save)))
                            .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(point)
                        .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(gradeLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(partOneLabel)
                        .addComponent(answerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addComponent(partTwoLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                    .addComponent(save)
                    .addGap(19, 19, 19))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
    private JTextField answerField;
    private JLabel partOneLabel;
    private JLabel label1;
    private JButton save;
    private JLabel gradeLabel;
    private JTextField gradeField;
    private JLabel point;
    private JLabel partTwoLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
