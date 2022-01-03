/*
 * Created by JFormDesigner on Tue Dec 21 15:03:58 TRT 2021
 */

package View.EditQuestion;

import java.awt.event.*;
import Controller.QuestionController.Factory.MultipleChoiceQuestionFactory;
import Controller.QuestionController.Factory.QuestionFactory;
import Controller.QuestionController.Factory.TrueFalseQuestionFactory;
import Model.QuestionModel;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.util.ArrayList;

/**
 * @author yasemin
 */
public class EditTrueFalseQuestionFrame extends JFrame {
    public int examId;
    public int questionId;
    public String question;
    public String keyAnswer;
    public double points;
    public ArrayList<String> availableAnswers = new ArrayList<>();
    public QuestionFactory factory = new TrueFalseQuestionFactory();
    public String type;

    public EditTrueFalseQuestionFrame(int examId, int questionId) {
        this.questionId = questionId;
        this.examId = examId;
        initComponents();
        if(questionId!=0){
            editQuestion();
        }
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getKeyAnswer() {
        return keyAnswer;
    }

    public void setKeyAnswer(String keyAnswer) {
        this.keyAnswer = keyAnswer;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public ArrayList<String> getAvailableAnswers() {
        return availableAnswers;
    }

    public void setAvailableAnswers(ArrayList<String> availableAnswers) {
        this.availableAnswers = availableAnswers;
    }

    public QuestionFactory getFactory() {
        return factory;
    }

    public void setFactory(QuestionFactory factory) {
        this.factory = factory;
    }

    public void createQuestion(){
        QuestionModel questionModel =  new QuestionModel();
        getFactory().addQuestion(getQuestion(),getPoints(),getExamId(),getKeyAnswer(),getAvailableAnswers());
    }

    public void updateQuestion(){
        QuestionModel questionModel =  new QuestionModel();
        getFactory().updateQuestion(getQuestionId(),getQuestion(),getPoints(),getExamId(),getKeyAnswer(),getAvailableAnswers());
    }

    public void editQuestion(){
        QuestionModel questionModel = new QuestionModel();
        System.out.println(questionModel.getQuestion(getQuestionId()));
        questionLabel.setText(questionModel.getQuestion(getQuestionId()));
        keyAnswerBox.setSelectedItem(questionModel.getKeyAnswer(getQuestionId()));
        pointsLabel.setText(questionModel.getAvailablePoints(getQuestionId()));
    }

    private void addQuestion(ActionEvent e) {
        setQuestion(questionLabel.getText());
        setKeyAnswer(keyAnswerBox.getSelectedItem().toString());
        setPoints(Double.parseDouble(pointsLabel.getText()));
        ArrayList<String> answers = new ArrayList<>();
        answers.add("True");
        answers.add("False");
        setAvailableAnswers(answers);
        if(questionId==0){
            createQuestion();
        }
        else{
            updateQuestion();
        }
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yasemin
        panel1 = new JPanel();
        label1 = new JLabel();
        pointsLabel = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        questionLabel = new JTextField();
        label5 = new JLabel();
        keyAnswerBox = new JComboBox<>();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setText("True False Question");

            //---- pointsLabel ----
            pointsLabel.setText("Points");

            //---- button1 ----
            button1.setText("Add");
            button1.addActionListener(e -> addQuestion(e));

            //---- button2 ----
            button2.setText("Cancel");

            //---- questionLabel ----
            questionLabel.setText("Question");

            //---- label5 ----
            label5.setText("Enter question here:");

            //---- keyAnswerBox ----
            keyAnswerBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "True",
                "False"
            }));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(label1))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addComponent(button2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(keyAnswerBox, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(questionLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5, GroupLayout.Alignment.LEADING))))
                        .addContainerGap(42, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(label1)
                        .addGap(22, 22, 22)
                        .addComponent(label5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyAnswerBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button2)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - yasemin
    private JPanel panel1;
    private JLabel label1;
    private JTextField pointsLabel;
    private JButton button1;
    private JButton button2;
    private JTextField questionLabel;
    private JLabel label5;
    private JComboBox<String> keyAnswerBox;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
