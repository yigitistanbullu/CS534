package View.StudentsQuestion;

import Controller.ExamController.Exam;
import Model.ExamModel;
import Model.QuestionModel;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Dec 15 20:21:28 EET 2021
 */



/**
 * @author Zeliha Aydın
 */
public class TextQuestion extends JPanel {
    public TextQuestion(String id) {
        initComponents();
    }

    public ExamModel examModel = new ExamModel();

    public void setQuestion(Exam exam){

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yasemin
        submitButton = new JButton();
        questionLabel = new JLabel();
        answer = new JTextField();
        enterAnswer = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
        swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border
        .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog"
        ,java.awt.Font.BOLD,12),java.awt.Color.red), getBorder
        ())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
        .beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException
        ();}});

        //---- submitButton ----
        submitButton.setText("Submit");

        //---- questionLabel ----
        questionLabel.setText("question");

        //---- answer ----
        answer.setBackground(Color.white);

        //---- enterAnswer ----
        enterAnswer.setText("Enter answer here");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup()
                            .addComponent(enterAnswer)
                            .addComponent(answer, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
                            .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE))
                        .addComponent(submitButton))
                    .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(questionLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addComponent(enterAnswer)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(answer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(submitButton)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - yasemin
    private JButton submitButton;
    private JLabel questionLabel;
    private JTextField answer;
    private JLabel enterAnswer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
