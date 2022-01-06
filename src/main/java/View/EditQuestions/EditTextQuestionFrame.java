/*
 * Created by JFormDesigner on Tue Dec 21 15:02:25 TRT 2021
 */

package View.EditQuestions;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import Controller.QuestionController.Factory.QuestionFactory;
import Controller.QuestionController.Factory.TextQuestionFactory;
import Model.QuestionModel;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author yasemin
 */
public class EditTextQuestionFrame extends JFrame implements EditQuestionCommand {
    public int examId;
    public int questionId;
    public String question;
    public String keyAnswer;
    public double points;
    public QuestionFactory factory = new TextQuestionFactory();
    public String type;
    
    public EditTextQuestionFrame(int examId, int questionId) {
        this.questionId = questionId;
        this.examId = examId;
        initComponents();
    }

    public int getQuestionId() {
        return questionId;
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

    public QuestionFactory getFactory() {
        return factory;
    }

    public void setFactory(QuestionFactory factory) {
        this.factory = factory;
    }

    public void createQuestion(){
        ArrayList<String> availableAnswers = new ArrayList<>();
        availableAnswers.add("This is a text question.");
        getFactory().addQuestion(getQuestion(),getPoints(),getExamId(),getKeyAnswer(),availableAnswers);
    }

    public void edit(){
        QuestionModel questionModel = new QuestionModel();
        questionLabel.setText(questionModel.getQuestion(getQuestionId()));
        keyAnswerLabel.setText(questionModel.getKeyAnswer(getQuestionId()));
        pointsLabel.setText(questionModel.getAvailablePoints(getQuestionId()));
    }

    public void updateQuestion(){
        ArrayList<String> availableAnswers = new ArrayList<>();
        availableAnswers.add("This is a text question.");
        getFactory().updateQuestion(getQuestionId(),getQuestion(),getPoints(),getExamId(),getKeyAnswer(),availableAnswers);
    }
    
    private void addQuestion(ActionEvent e) {
        setQuestion(questionLabel.getText());
        setKeyAnswer(keyAnswerLabel.getText());
        setPoints(Double.parseDouble(pointsLabel.getText()));
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
        keyAnswerLabel = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        questionLabel = new JTextField();
        label5 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(103, 137, 171));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

            //---- label1 ----
            label1.setText(" Text Question");
            label1.setForeground(Color.white);

            //---- pointsLabel ----
            pointsLabel.setText("Points");
            pointsLabel.setBackground(Color.white);
            pointsLabel.setForeground(Color.red);

            //---- keyAnswerLabel ----
            keyAnswerLabel.setText("Key Answer");
            keyAnswerLabel.setBackground(Color.white);
            keyAnswerLabel.setForeground(new Color(51, 51, 51));

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
            questionLabel.setBackground(Color.white);
            questionLabel.setForeground(new Color(51, 51, 51));

            //---- label5 ----
            label5.setText("Enter question here:");
            label5.setForeground(Color.white);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(265, 265, 265)
                                .addComponent(label1))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label5, GroupLayout.Alignment.LEADING))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                                .addComponent(button2)
                                                .addGap(396, 396, 396))
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                .addComponent(keyAnswerLabel, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22)))
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(pointsLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(36, Short.MAX_VALUE))
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
                        .addGap(30, 30, 30)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(keyAnswerLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button2)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(54, Short.MAX_VALUE))
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
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
    private JPanel panel1;
    private JLabel label1;
    private JTextField pointsLabel;
    private JTextField keyAnswerLabel;
    private JButton button1;
    private JButton button2;
    private JTextField questionLabel;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
