/*
 * Created by JFormDesigner on Tue Dec 21 15:03:58 TRT 2021
 */

package View.EditQuestions;

import java.awt.*;
import java.awt.event.*;

import Controller.QuestionController.Factory.QuestionFactory;
import Controller.QuestionController.Factory.TrueFalseQuestionFactory;
import Model.QuestionModel;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.util.ArrayList;

/**
 * @author yasemin
 */
public class EditTrueFalseQuestionFrame extends JFrame implements EditQuestionCommand {
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

    public void createQuestion(){
        getFactory().addQuestion(getQuestion(),getPoints(),getExamId(),getKeyAnswer(),getAvailableAnswers());
    }

    private void cancel(ActionEvent e) {
        dispose();
    }

    public void updateQuestion(){
        getFactory().updateQuestion(getQuestionId(),getQuestion(),getPoints(),getExamId(),getKeyAnswer(),getAvailableAnswers());
    }

    public void edit(){
        QuestionModel questionModel = new QuestionModel();
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
        // Generated using JFormDesigner Evaluation license - Zeliha Ayd??n
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
            panel1.setBackground(new Color(103, 137, 171));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
            . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing
            . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
            Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
            ) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
            public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName (
            ) )) throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setText("True False Question");
            label1.setForeground(Color.white);
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));

            //---- pointsLabel ----
            pointsLabel.setText("Points");
            pointsLabel.setForeground(Color.red);
            pointsLabel.setBackground(Color.white);

            //---- button1 ----
            button1.setText("Add");
            button1.setBackground(new Color(103, 137, 171));
            button1.setForeground(Color.darkGray);
            button1.addActionListener(e -> addQuestion(e));

            //---- button2 ----
            button2.setText("Cancel");
            button2.setBackground(new Color(103, 137, 171));
            button2.setForeground(Color.darkGray);
            button2.addActionListener(e -> cancel(e));

            //---- questionLabel ----
            questionLabel.setText("Question");
            questionLabel.setForeground(Color.darkGray);
            questionLabel.setBackground(Color.white);

            //---- label5 ----
            label5.setText("Enter question here:");
            label5.setForeground(Color.white);

            //---- keyAnswerBox ----
            keyAnswerBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "True",
                "False"
            }));
            keyAnswerBox.setForeground(Color.darkGray);
            keyAnswerBox.setBackground(Color.white);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label5, GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(button2)
                                    .addGap(394, 394, 394)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addComponent(keyAnswerBox, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                        .addGap(323, 323, 323)
                                        .addComponent(pointsLabel))
                                    .addComponent(questionLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(249, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addGap(249, 249, 249))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(label1)
                        .addGap(18, 18, 18)
                        .addComponent(label5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(keyAnswerBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button2)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(28, Short.MAX_VALUE))
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
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Zeliha Ayd??n
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
