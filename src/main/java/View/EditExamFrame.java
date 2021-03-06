package View;

import javax.swing.border.*;

import Controller.ExamController.Exam;
import Controller.ExamController.Examination;
import Controller.QuestionController.Factory.*;
import Model.ExamModel;
import Model.QuestionModel;
import View.EditQuestions.EditMultipleChoiceQuestionFrame;
import View.EditQuestions.EditQuestionCommand;
import View.EditQuestions.EditTextQuestionFrame;
import View.EditQuestions.EditTrueFalseQuestionFrame;
import View.EditQuestions.EditGapFillingQuestionFrame;
import View.EditQuestions.EditMultipleSelectionQuestionFrame;



import javax.imageio.ImageIO;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

public class EditExamFrame extends JFrame {
    public int userId;
    public int examId;
    public String userName;
    public QuestionModel questionModel = new QuestionModel();


    public EditExamFrame(int userId, String userName, int examId) {
        this.userId = userId;
        this.examId = examId;
        this.userName = userName;
        initComponents();
        editTableAndFrame();
        setIcon();
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

    public QuestionModel getQuestionModel() {
        return questionModel;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public void editTableAndFrame(){
        ExamModel model = new ExamModel();
        Examination examination = model.getExam(getExamId());
        examNameLabel.setText(examination.getName());
        ArrayList<Integer> questionID = getQuestionModel().getQuestionIds(getExamId());

        for(int i = 0; i< questionID.size();i++){
            DefaultTableModel tableModel = (DefaultTableModel) questionsTable.getModel();
            int qID = questionID.get(i);
            tableModel.addRow(new Object[]{Integer.toString(i+1),questionModel.getQuestionType(qID), questionModel.getKeyAnswer(qID),questionModel.getAvailablePoints(qID)});
        }

        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) questionsTable.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);
        questionsTable.getTableHeader().setFont( new Font( "Roboto" , Font.PLAIN, 13 ));
    }

    private void delete(ActionEvent e) {
        QuestionFactory factory;
        ArrayList<Integer> questionID = getQuestionModel().getQuestionIds(getExamId());
        int SelectedQuestionId = questionID.get(questionsTable.getSelectedRow());
        if(getQuestionModel().getQuestionType(SelectedQuestionId).equals("text")){
            factory = new TextQuestionFactory();
            factory.deleteQuestion(SelectedQuestionId);
        }
       else if(getQuestionModel().getQuestionType(SelectedQuestionId).equals("multiple_choice")){
            factory = new MultipleChoiceQuestionFactory();
            factory.deleteQuestion(SelectedQuestionId);
        }
        else if(getQuestionModel().getQuestionType(SelectedQuestionId).equals("true_false")){
            factory = new TrueFalseQuestionFactory();
            factory.deleteQuestion(SelectedQuestionId);
        }
        else if(getQuestionModel().getQuestionType(SelectedQuestionId).equals("multiple_selection")){
            factory = new MultipleSelectionQuestionFactory();
            factory.deleteQuestion(SelectedQuestionId);
        }
        else if(getQuestionModel().getQuestionType(SelectedQuestionId).equals("gap_filling")){
            factory = new GapFillingQuestionFactory();
            factory.deleteQuestion(SelectedQuestionId);
        }
    }

    private void addQuestion(ActionEvent e) {
        if(questionTypeBox.getSelectedItem().equals("Text")){
            EditTextQuestionFrame frame =  new EditTextQuestionFrame(getExamId(),0);
            frame.setVisible(true);
        }
        else if(questionTypeBox.getSelectedItem().equals("Multiple Choice")){
            EditMultipleChoiceQuestionFrame frame =  new EditMultipleChoiceQuestionFrame(getExamId(),0);
            frame.setVisible(true);
        }
        else if(questionTypeBox.getSelectedItem().equals("True False")){
            EditTrueFalseQuestionFrame frame =  new EditTrueFalseQuestionFrame(getExamId(),0);
            frame.setVisible(true);
        }
        else if(questionTypeBox.getSelectedItem().equals("Multiple Selection")){
            EditMultipleSelectionQuestionFrame frame =  new EditMultipleSelectionQuestionFrame(getExamId(),0);
            frame.setVisible(true);
        }
        else if(questionTypeBox.getSelectedItem().equals("Gap Filling")){
            EditGapFillingQuestionFrame frame =  new EditGapFillingQuestionFrame(getExamId(),0);
            frame.setVisible(true);
        }

    }

    private void returnButton(ActionEvent e) {
        TeachersHomePage page = new TeachersHomePage(getUserId(),getUserName());
        page.setVisible(true);
        this.dispose();
    }

    private void refresh(ActionEvent e) {
        EditExamFrame frame = new EditExamFrame(getUserId(),getUserName(),getExamId());
        frame.setVisible(true);
        this.dispose();
    }

    private void edit(ActionEvent e) {
        ArrayList<Integer> questionID = questionModel.getQuestionIds(getExamId());
        int SelectedQuestionId = questionID.get(questionsTable.getSelectedRow());
        if(getQuestionModel().getQuestionType(SelectedQuestionId).equals("text")){
            EditQuestionCommand frame = new EditTextQuestionFrame(getExamId(),SelectedQuestionId);
            frame.edit();
            frame.setVisible(true);
        }
        else if(getQuestionModel().getQuestionType(SelectedQuestionId).equals("multiple_choice")){
            EditQuestionCommand frame = new EditMultipleChoiceQuestionFrame(getExamId(),SelectedQuestionId);
            frame.edit();
            frame.setVisible(true);
        }
        else if(getQuestionModel().getQuestionType(SelectedQuestionId).equals("true_false")){
            EditQuestionCommand frame = new EditTrueFalseQuestionFrame(getExamId(),SelectedQuestionId);
            frame.edit();
            frame.setVisible(true);
        }
        else if(questionModel.getQuestionType(SelectedQuestionId).equals("multiple_selection")){
            EditQuestionCommand frame = new EditMultipleSelectionQuestionFrame(getExamId(),SelectedQuestionId);
            frame.edit();
            frame.setVisible(true);
        }
        else if(questionModel.getQuestionType(SelectedQuestionId).equals("gap_filling")){
            EditQuestionCommand frame = new EditGapFillingQuestionFrame(getExamId(),SelectedQuestionId);
            frame.edit();
            frame.setVisible(true);
        }
    }

    public void setIcon(){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/main/java/View/Images/ou_logo_ing_white.png"));
            Image ozuLogo = img.getScaledInstance(ozuIconLabel.getWidth(),ozuIconLabel.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(ozuLogo);
            ozuIconLabel.setIcon(imageIcon);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Ayd??n
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        questionsTable = new JTable();
        addQuestionButton = new JButton();
        examNameLabel = new JLabel();
        questionTypeBox = new JComboBox<>();
        returnButton = new JButton();
        submitButton2 = new JButton();
        submitButton3 = new JButton();
        submitButton4 = new JButton();
        ozuIconLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(103, 137, 171));
            panel1.setPreferredSize(new Dimension(991, 561));
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
            EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing
            .border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),
            java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener()
            {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))
            throw new RuntimeException();}});

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(new Color(189, 204, 218));
                scrollPane1.setForeground(Color.white);
                scrollPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

                //---- questionsTable ----
                questionsTable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "Question # ", "Type", "Key Answer", "Points"
                    }
                ));
                questionsTable.setRowHeight(25);
                scrollPane1.setViewportView(questionsTable);
            }

            //---- addQuestionButton ----
            addQuestionButton.setText("+");
            addQuestionButton.setBackground(new Color(103, 137, 171));
            addQuestionButton.setForeground(Color.darkGray);
            addQuestionButton.setFont(addQuestionButton.getFont().deriveFont(addQuestionButton.getFont().getStyle() | Font.BOLD));
            addQuestionButton.addActionListener(e -> addQuestion(e));

            //---- examNameLabel ----
            examNameLabel.setText("Exam Name");
            examNameLabel.setForeground(Color.white);
            examNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            examNameLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

            //---- questionTypeBox ----
            questionTypeBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "Text",
                "True False",
                "Multiple Choice",
                "Multiple Selection",
                "Gap Filling"
            }));

            //---- returnButton ----
            returnButton.setText("Return");
            returnButton.setBackground(new Color(103, 137, 171));
            returnButton.setForeground(Color.darkGray);
            returnButton.addActionListener(e -> returnButton(e));

            //---- submitButton2 ----
            submitButton2.setText("Edit");
            submitButton2.setBackground(new Color(103, 137, 171));
            submitButton2.setForeground(Color.darkGray);
            submitButton2.addActionListener(e -> edit(e));

            //---- submitButton3 ----
            submitButton3.setText("Delete");
            submitButton3.setBackground(new Color(103, 137, 171));
            submitButton3.setForeground(Color.darkGray);
            submitButton3.addActionListener(e -> delete(e));

            //---- submitButton4 ----
            submitButton4.setText("Refresh");
            submitButton4.setBackground(new Color(103, 137, 171));
            submitButton4.setForeground(Color.darkGray);
            submitButton4.addActionListener(e -> refresh(e));

            //---- ozuIconLabel ----
            ozuIconLabel.setText("text");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(examNameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(764, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(submitButton4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 627, Short.MAX_VALUE)
                                        .addComponent(questionTypeBox, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addQuestionButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(scrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(submitButton2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(submitButton3)
                                        .addGap(232, 232, 232)
                                        .addComponent(ozuIconLabel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                                        .addComponent(returnButton)))
                                .addGap(37, 37, 37))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(examNameLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(submitButton4)
                            .addComponent(addQuestionButton)
                            .addComponent(questionTypeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(returnButton)
                            .addComponent(submitButton3)
                            .addComponent(submitButton2)
                            .addComponent(ozuIconLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 966, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Zeliha Ayd??n
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable questionsTable;
    private JButton addQuestionButton;
    private JLabel examNameLabel;
    private JComboBox<String> questionTypeBox;
    private JButton returnButton;
    private JButton submitButton2;
    private JButton submitButton3;
    private JButton submitButton4;
    private JLabel ozuIconLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
