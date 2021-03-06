/*
 * Created by JFormDesigner on Wed Jan 05 14:08:29 EET 2022
 */

package View.EditQuestions;

import java.awt.*;
import Controller.QuestionController.Factory.MultipleSelectionQuestionFactory;
import Controller.QuestionController.Factory.QuestionFactory;
import Model.QuestionModel;
import View.EditQuestions.EditQuestionCommand;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Zeliha Aydın
 */
public class EditMultipleSelectionQuestionFrame extends JFrame implements EditQuestionCommand {
    public int examId;
    public String question;
    public int questionId;
    public String keyAnswer;
    public double points;
    public ArrayList<String> availableAnswers = new ArrayList<>();
    public QuestionFactory factory = new MultipleSelectionQuestionFactory();
    public String type;
    public EditMultipleSelectionQuestionFrame(int examId, int questionId) {

        this.questionId = questionId;
        this.examId = examId;
        initComponents();
    }
    public int getQuestionId() {
        return questionId;
    }

    @Override
    public void edit() {
        QuestionModel questionModel = new QuestionModel();
        ArrayList<String> availableAnswers = questionModel.getQuestionAnswers(getQuestionId());
        questionLabel.setText(questionModel.getQuestion(getQuestionId()));
        keyAnswerLabel.setText(questionModel.getKeyAnswer(getQuestionId()));
        pointsLabel.setText(questionModel.getAvailablePoints(getQuestionId()));
        answer1.setText(availableAnswers.get(0));
        answer2.setText(availableAnswers.get(1));
        answer3.setText(availableAnswers.get(2));
    }

    public void updateQuestion(){
        getFactory().updateQuestion(getQuestionId(),getQuestion(),getPoints(),getExamId(),getKeyAnswer(),getAvailableAnswers());
    }

    public void createQuestion(){
        getFactory().addQuestion(getQuestion(),getPoints(),getExamId(),getKeyAnswer(),getAvailableAnswers());
    }

    public QuestionFactory getFactory() {
        return factory;
    }

    public void setFactory(QuestionFactory factory) {
        this.factory = factory;
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

    private void addQuestion(ActionEvent e) {
        setQuestion(questionLabel.getText());
        setKeyAnswer(keyAnswerLabel.getText());
        setPoints(Double.parseDouble(pointsLabel.getText()));
        ArrayList<String> answers = new ArrayList<>();
        answers.add(answer1.getText());
        answers.add(answer2.getText());
        answers.add(answer3.getText());
        setAvailableAnswers(answers);
        if(questionId==0){
            createQuestion();
        }
        else{
            updateQuestion();
        }
        this.dispose();
    }

    private void cancel(ActionEvent e) {
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        panel1 = new JPanel();
        label1 = new JLabel();
        pointsLabel = new JTextField();
        keyAnswerLabel = new JFormattedTextField();
        addButton = new JButton();
        cancelButton = new JButton();
        questionLabel = new JTextField();
        answer1 = new JTextField();
        answer2 = new JTextField();
        answer3 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        addButton2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(103, 137, 171));
            panel1.setForeground(Color.white);
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
            0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
            . BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
            red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
            beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setText("Multiple Selection Question");
            label1.setForeground(Color.white);
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));

            //---- pointsLabel ----
            pointsLabel.setText("Points");
            pointsLabel.setBackground(Color.white);
            pointsLabel.setForeground(Color.red);

            //---- keyAnswerLabel ----
            keyAnswerLabel.setText("Key Answer");
            keyAnswerLabel.setForeground(Color.darkGray);
            keyAnswerLabel.setBackground(Color.white);

            //---- addButton ----
            addButton.setText("Add");
            addButton.setBackground(new Color(103, 137, 171));
            addButton.setForeground(Color.darkGray);
            addButton.addActionListener(e -> addQuestion(e));

            //---- cancelButton ----
            cancelButton.setText("Cancel");
            cancelButton.setBackground(new Color(103, 137, 171));
            cancelButton.setForeground(Color.darkGray);
            cancelButton.addActionListener(e -> cancel(e));

            //---- questionLabel ----
            questionLabel.setBackground(Color.white);
            questionLabel.setForeground(new Color(51, 51, 51));

            //---- answer1 ----
            answer1.setBackground(Color.white);
            answer1.setForeground(new Color(51, 51, 51));

            //---- answer2 ----
            answer2.setBackground(Color.white);
            answer2.setForeground(new Color(51, 51, 51));

            //---- answer3 ----
            answer3.setBackground(Color.white);
            answer3.setForeground(new Color(51, 51, 51));

            //---- label2 ----
            label2.setText("A.");
            label2.setForeground(Color.white);
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));

            //---- label3 ----
            label3.setText("C.");
            label3.setForeground(Color.white);
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD));

            //---- label4 ----
            label4.setText("B.");
            label4.setForeground(Color.white);
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD));

            //---- label5 ----
            label5.setText("Enter question here:");
            label5.setForeground(Color.white);

            //---- addButton2 ----
            addButton2.setText("Save");
            addButton2.setBackground(new Color(103, 137, 171));
            addButton2.setForeground(Color.darkGray);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(33, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(keyAnswerLabel, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88))
                            .addComponent(cancelButton, GroupLayout.Alignment.LEADING))
                        .addGap(55, 55, 55))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(label2, GroupLayout.Alignment.TRAILING)
                                            .addComponent(label4, GroupLayout.Alignment.TRAILING)
                                            .addComponent(label3, GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(answer3, GroupLayout.Alignment.TRAILING)
                                            .addComponent(answer2)
                                            .addComponent(answer1, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(label5, GroupLayout.Alignment.LEADING)
                                    .addComponent(questionLabel)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(addButton2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(pointsLabel, GroupLayout.Alignment.TRAILING)
                                            .addComponent(addButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(label1)))
                        .addContainerGap(40, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(label1)
                        .addGap(18, 18, 18)
                        .addComponent(label5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(answer1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(answer2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(answer3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3))
                        .addGap(27, 27, 27)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(keyAnswerLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton)
                            .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton2))
                        .addContainerGap(29, Short.MAX_VALUE))
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
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
    private JPanel panel1;
    private JLabel label1;
    private JTextField pointsLabel;
    private JFormattedTextField keyAnswerLabel;
    private JButton addButton;
    private JButton cancelButton;
    private JTextField questionLabel;
    private JTextField answer1;
    private JTextField answer2;
    private JTextField answer3;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JButton addButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
