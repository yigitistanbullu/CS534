package View;

import javax.swing.border.*;
import Controller.ExamController.Exam;
import Model.ExamModel;
import Model.QuestionModel;
import View.EditQuestion.EditMultipleChoiceQuestionFrame;
import View.EditQuestion.EditTextQuestionFrame;

import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

public class EditExamFrame extends JFrame {
    public int userId;
    public int examId;
    public String userName;

    public EditExamFrame(int userId, String userName, int examId) {
        this.userId = userId;
        this.examId = examId;
        this.userName = userName;
        initComponents();
        editTableAndFrame();
    }

    private void addQuestion(ActionEvent e) {
        if(questionTypeBox.getSelectedItem().equals("Text")){
            EditTextQuestionFrame frame =  new EditTextQuestionFrame(getExamId());
            frame.setVisible(true);
        }
        else if(questionTypeBox.getSelectedItem().equals("Multiple Choice")){
            EditMultipleChoiceQuestionFrame frame =  new EditMultipleChoiceQuestionFrame(getExamId());
            frame.setVisible(true);
        }
        else if(questionTypeBox.getSelectedItem().equals("True False")){
            EditTextQuestionFrame frame =  new EditTextQuestionFrame(getExamId());
            frame.setVisible(true);
        }
    }

    public void editTableAndFrame(){
        ExamModel model = new ExamModel();
        Exam exam = model.getExam(getExamId());
        examNameLabel.setText(exam.getName());

        QuestionModel questionModel = new QuestionModel();
        ArrayList<Integer> questionID = questionModel.getQuestionIds(getExamId());

        for(int i = 0; i< questionID.size();i++){
            DefaultTableModel tableModel = (DefaultTableModel) questionsTable.getModel();
            int qID = questionID.get(i);
            tableModel.addRow(new Object[]{Integer.toString(qID),questionModel.getQuestionType(qID), questionModel.getKeyAnswer(qID),questionModel.getAvailablePoints(qID)});
        }

    }

    private void submit(ActionEvent e) {

    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }


    private void returnButton(ActionEvent e) {
        TeachersHomePage page = new TeachersHomePage(getUserId(),getUserName(),getExamId());
        page.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        questionsTable = new JTable();
        submitButton = new JButton();
        addQuestionButton = new JButton();
        examNameLabel = new JLabel();
        questionTypeBox = new JComboBox<>();
        returnButton = new JButton();
        submitButton2 = new JButton();
        submitButton3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(113, 188, 255));
            panel1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(Color.white);
                scrollPane1.setForeground(Color.white);

                //---- questionsTable ----
                questionsTable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "Question # ", "Type", "Key Answer", "Points"
                    }
                ));
                questionsTable.setForeground(new Color(51, 51, 51));
                questionsTable.setBackground(Color.white);
                scrollPane1.setViewportView(questionsTable);
            }

            //---- submitButton ----
            submitButton.setText("Save");
            submitButton.setBackground(new Color(113, 188, 255));
            submitButton.setForeground(Color.white);
            submitButton.addActionListener(e -> submit(e));

            //---- addQuestionButton ----
            addQuestionButton.setText("+");
            addQuestionButton.setBackground(new Color(113, 188, 255));
            addQuestionButton.setForeground(Color.white);
            addQuestionButton.setFont(addQuestionButton.getFont().deriveFont(addQuestionButton.getFont().getStyle() | Font.BOLD));
            addQuestionButton.addActionListener(e -> addQuestion(e));

            //---- examNameLabel ----
            examNameLabel.setText("Exam Name");
            examNameLabel.setForeground(Color.white);
            examNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            examNameLabel.setFont(new Font("Roboto Thin", Font.BOLD, 20));

            //---- questionTypeBox ----
            questionTypeBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "Text",
                "True False",
                "Multiple Choice"
            }));
            questionTypeBox.setBackground(Color.white);

            //---- returnButton ----
            returnButton.setText("Cancel");
            returnButton.setBackground(new Color(113, 188, 255));
            returnButton.setForeground(Color.white);
            returnButton.addActionListener(e -> returnButton(e));

            //---- submitButton2 ----
            submitButton2.setText("Edit");
            submitButton2.setBackground(new Color(113, 188, 255));
            submitButton2.setForeground(Color.white);
            submitButton2.addActionListener(e -> submit(e));

            //---- submitButton3 ----
            submitButton3.setText("Delete");
            submitButton3.setBackground(new Color(113, 188, 255));
            submitButton3.setForeground(Color.white);
            submitButton3.addActionListener(e -> submit(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(returnButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                                .addComponent(examNameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)
                                .addComponent(questionTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addQuestionButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(submitButton2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(submitButton3)
                                        .addGap(623, 623, 623)
                                        .addComponent(submitButton))
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 863, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(21, Short.MAX_VALUE))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(examNameLabel)
                            .addComponent(returnButton)
                            .addComponent(addQuestionButton)
                            .addComponent(questionTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(submitButton3, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                .addComponent(submitButton, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                            .addComponent(submitButton2, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
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
    private JScrollPane scrollPane1;
    private JTable questionsTable;
    private JButton submitButton;
    private JButton addQuestionButton;
    private JLabel examNameLabel;
    private JComboBox<String> questionTypeBox;
    private JButton returnButton;
    private JButton submitButton2;
    private JButton submitButton3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
