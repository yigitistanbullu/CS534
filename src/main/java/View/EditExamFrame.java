package View;

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
        // Generated using JFormDesigner Evaluation license - yasemin
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        questionsTable = new JTable();
        submitButton = new JButton();
        addQuestionButton = new JButton();
        examNameLabel = new JLabel();
        questionTypeBox = new JComboBox<>();
        returnButton = new JButton();
        submitButton2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder (
            new javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion"
            , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
            , new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 )
            ,java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
            ;} } );

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
                scrollPane1.setViewportView(questionsTable);
            }

            //---- submitButton ----
            submitButton.setText("Submit");
            submitButton.setBackground(Color.white);
            submitButton.addActionListener(e -> submit(e));

            //---- addQuestionButton ----
            addQuestionButton.setText("Add Question");
            addQuestionButton.setBackground(Color.white);
            addQuestionButton.addActionListener(e -> addQuestion(e));

            //---- examNameLabel ----
            examNameLabel.setText("Exam Name");
            examNameLabel.setForeground(Color.black);
            examNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            examNameLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 18));

            //---- questionTypeBox ----
            questionTypeBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "Text",
                "True False",
                "Multiple Choice"
            }));

            //---- returnButton ----
            returnButton.setText("Return");
            returnButton.setBackground(Color.white);
            returnButton.addActionListener(e -> returnButton(e));

            //---- submitButton2 ----
            submitButton2.setText("Edit");
            submitButton2.setBackground(Color.white);
            submitButton2.addActionListener(e -> submit(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(30, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(questionTypeBox, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(examNameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(returnButton)
                                    .addGap(33, 33, 33))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 614, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(addQuestionButton)
                                            .addGap(36, 36, 36)
                                            .addComponent(submitButton2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(submitButton)))
                                    .addGap(24, 24, 24)))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(examNameLabel)
                            .addComponent(returnButton))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(addQuestionButton)
                            .addComponent(submitButton2)
                            .addComponent(submitButton))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    // Generated using JFormDesigner Evaluation license - yasemin
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable questionsTable;
    private JButton submitButton;
    private JButton addQuestionButton;
    private JLabel examNameLabel;
    private JComboBox<String> questionTypeBox;
    private JButton returnButton;
    private JButton submitButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
