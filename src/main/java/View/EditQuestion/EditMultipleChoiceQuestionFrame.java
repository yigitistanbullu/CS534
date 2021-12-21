/*
 * Created by JFormDesigner on Tue Dec 21 13:20:24 TRT 2021
 */

package View.EditQuestion;

import Controller.QuestionController.Factory.MultipleChoiceQuestionFactory;
import Controller.QuestionController.Factory.QuestionFactory;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author yasemin
 */
public class EditMultipleChoiceQuestionFrame extends JFrame {
    public int examId;
    public String question;
    public String keyAnswer;
    public double points;
    public ArrayList<String> availableAnswers = new ArrayList<>();
    public String type;

    public EditMultipleChoiceQuestionFrame(int examId) {
        this.examId = examId;
        initComponents();
    }

    public void createQuestion(int examId,String question, int questionId, double points, String keyAnswer,ArrayList<String> availableAnswers){
        QuestionFactory factory = new MultipleChoiceQuestionFactory();
        factory.addQuestion(0,getQuestion(),getPoints(),getExamId(),getKeyAnswer(),getAvailableAnswers());
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


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yasemin
        panel1 = new JPanel();
        label1 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        textField4 = new JTextField();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setText("Multiple Choice Question");

            //---- textField2 ----
            textField2.setText("Points");

            //---- textField3 ----
            textField3.setText("Key Answer");

            //---- button1 ----
            button1.setText("Add");

            //---- button2 ----
            button2.setText("Cancel");

            //---- label2 ----
            label2.setText("A.");

            //---- label3 ----
            label3.setText("C.");

            //---- label4 ----
            label4.setText("B.");

            //---- label5 ----
            label5.setText("Enter question here:");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(33, 33, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88))
                            .addComponent(button2, GroupLayout.Alignment.LEADING))
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
                                            .addComponent(textField7, GroupLayout.Alignment.TRAILING)
                                            .addComponent(textField6)
                                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5, GroupLayout.Alignment.LEADING)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(label1)))
                        .addContainerGap(42, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(label1)
                        .addGap(18, 18, 18)
                        .addComponent(label5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3))
                        .addGap(27, 27, 27)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button2)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
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
    // Generated using JFormDesigner Evaluation license - yasemin
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
