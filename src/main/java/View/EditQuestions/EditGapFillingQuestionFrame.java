/*
 * Created by JFormDesigner on Wed Jan 05 14:19:20 EET 2022
 */

package View.EditQuestions;

import java.awt.*;
import Controller.QuestionController.Factory.QuestionFactory;
import Controller.QuestionController.Factory.GapFillingQuestionFactory;
import Model.QuestionModel;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Zeliha Aydın
 */
public class EditGapFillingQuestionFrame extends JFrame implements EditQuestionCommand{
    public int examId;
    public int questionId;
    public String partOne;
    public String partTwo;
    public String keyAnswer;
    public double points;
    public QuestionFactory factory = new GapFillingQuestionFactory();
    public String type;

    public EditGapFillingQuestionFrame(int examId, int questionId)
    {
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

    public String getPartOne() {
        return partOne;
    }

    public String getPartTwo() {
        return partTwo;
    }

    public void setQuestion(String partOne, String partTwo) {
        this.partOne = partOne;
        this.partTwo = partTwo;
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
        availableAnswers.add("This is a gap filling question.");
        getFactory().addQuestionForGapFilling(getPartOne(), getPartTwo(),getPoints(),getExamId(),getKeyAnswer(),availableAnswers);
    }

    @Override
    public void edit() {
        QuestionModel model = new QuestionModel();
        String string = model.getQuestion(questionId);
        String partOne = string.substring(0,string.indexOf(" "));
        String partTwo = string.substring(string.indexOf(" ") + 1);
        questionLabel.setText(partOne);
        questionLabel2.setText(partTwo);
        keyAnswerLabel.setText(model.getKeyAnswer(getQuestionId()));
        pointsLabel.setText(model.getAvailablePoints(getQuestionId()));
    }

    public void updateQuestion(){
        ArrayList<String> availableAnswers = new ArrayList<>();
        availableAnswers.add("This is a gap filling question.");
        getFactory().updateQuestionForGapFilling(getQuestionId(),getPartOne(), getPartTwo(),getPoints(),getExamId(),getKeyAnswer(),availableAnswers);
    }

    private void addQuestion(ActionEvent e) {
        setQuestion(questionLabel.getText(), questionLabel2.getText());
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
        questionLabel2 = new JTextField();
        label6 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(103, 137, 171));
            panel1.setForeground(Color.white);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
            javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax
            . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
            . awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .
            PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .
            equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //---- label1 ----
            label1.setText(" Gap Filling Question");
            label1.setForeground(Color.white);
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));

            //---- pointsLabel ----
            pointsLabel.setText("Points");
            pointsLabel.setBackground(Color.white);
            pointsLabel.setForeground(Color.red);

            //---- keyAnswerLabel ----
            keyAnswerLabel.setText("Key Answer");
            keyAnswerLabel.setBackground(Color.white);
            keyAnswerLabel.setForeground(Color.darkGray);

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
            questionLabel.setForeground(Color.darkGray);

            //---- label5 ----
            label5.setText("First part");
            label5.setForeground(Color.white);

            //---- questionLabel2 ----
            questionLabel2.setBackground(Color.white);
            questionLabel2.setForeground(Color.darkGray);

            //---- label6 ----
            label6.setText("Second Part");
            label6.setForeground(Color.white);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(249, 249, 249)
                                .addComponent(label1))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label5, GroupLayout.Alignment.LEADING)
                                    .addComponent(label6, GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(button2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(questionLabel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                                .addComponent(questionLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGap(59, 59, 59)
                                                    .addComponent(keyAnswerLabel, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGap(218, 218, 218)
                                                    .addComponent(pointsLabel))))))))
                        .addContainerGap(37, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(label1)
                        .addGap(18, 18, 18)
                        .addComponent(label5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyAnswerLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(label6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(questionLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pointsLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2))
                        .addContainerGap(18, Short.MAX_VALUE))
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
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JTextField questionLabel2;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
