package View.ExamQuestions;

import java.awt.event.*;
import Model.QuestionModel;

import java.awt.*;
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
    public String questionNumber;

    public TrueFalseQuestion (Builder builder) {
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

    public void setComponents(int qId ){
        QuestionModel model = new QuestionModel();
        questionLabel.setText(model.getQuestion(qId));
        point.setText("(" + String.valueOf(model.getAvailablePoints(getQuestionId())) + ")");
        label1.setText(getQuestionNumber());
    }

    private void save(ActionEvent e) {
        QuestionModel model = new QuestionModel();
        if(userType == 0) {
            if (trueCheck.isSelected()) {
                model.addUserAnswer("True", getUserId(), getQuestionId(),getExamId());

            } else if (falseCheck.isSelected()) {
                model.addUserAnswer("False", getUserId(), getQuestionId(),getExamId());

            }
        }
        else{
            double grade = Double.parseDouble(gradeField.getText());
            model.setPointsByInstructor(getUserId(),getQuestionId(),grade);
            gradeField.setText(model.getPointsEarned(getUserId(),getQuestionId()));
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
    public void removeGradeFieldForStudent(){
        gradeField.setEnabled(false);
    }

    public void removeGrade(){
        gradeField.setVisible(false);
        gradeLabel.setVisible(false);
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


        public TrueFalseQuestion build() {
            return new TrueFalseQuestion(this);
        }
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
        point = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder(LineBorder.createBlackLineBorder());
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
        . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax. swing .border . TitledBorder
        . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dialo\u0067", java .
        awt . Font. BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) )
        ;  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
        ) { if( "borde\u0072" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
        ;

        //---- trueCheck ----
        trueCheck.setText("True");
        trueCheck.setBackground(Color.white);

        //---- falseCheck ----
        falseCheck.setText("False");
        falseCheck.setBackground(Color.white);

        //---- questionLabel ----
        questionLabel.setText("question");
        questionLabel.setFont(questionLabel.getFont().deriveFont(questionLabel.getFont().getStyle() | Font.BOLD));

        //---- label1 ----
        label1.setText("1");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));

        //---- save ----
        save.setText("save");
        save.addActionListener(e -> save(e));

        //---- gradeLabel ----
        gradeLabel.setText("Grade:");

        //---- point ----
        point.setText("Points");
        point.setFont(point.getFont().deriveFont(point.getFont().getStyle() | Font.BOLD, point.getFont().getSize() - 3f));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(point, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gradeLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(trueCheck, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addComponent(falseCheck, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                            .addGap(469, 469, 469)
                            .addComponent(save))
                        .addComponent(questionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(19, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(gradeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(gradeLabel)
                        .addComponent(point)
                        .addComponent(label1))
                    .addGap(8, 8, 8)
                    .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(trueCheck)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(save)
                        .addComponent(falseCheck))
                    .addContainerGap(29, Short.MAX_VALUE))
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
    private JLabel point;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
