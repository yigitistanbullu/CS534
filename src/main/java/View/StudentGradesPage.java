package View;
import Controller.ExamController.Exam;
import Model.AuthorizationModel;
import Model.ExamModel;
import Model.QuestionModel;
import View.StudentsQuestion.MultipleQuestion;
import View.StudentsQuestion.TextQuestion;
import View.StudentsQuestion.TrueFalseQuestion;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Dec 15 21:00:32 EET 2021
 */



/**
 * @author Zeliha Aydın
 */
public class StudentGradesPage extends JFrame {
    // exam, user_id,name
    String name = ""; // student name
    int id; //student Id
    AuthorizationModel model = new AuthorizationModel();
    ExamModel examModel = new ExamModel();

    public StudentGradesPage(int id, String name) {
        this.id = id;
        this.name = name;
        initComponents();
        nameLabelPropertyChange();
        addExam(examModel.getExam(model.getExamId(id))); //send examid examname
        date();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void examButton(ActionEvent e) {
        StudentsHomePage home = new StudentsHomePage(id,name);
        home.setVisible(true);
        home.setLocationRelativeTo(null);
        this.dispose();
    }
    private void nameLabelPropertyChange() {
        nameLabel.setText(model.getName(id));
    }
    public void date(){
        dateLabel.setText("Date : " + new SimpleDateFormat("dd/MM/yyyy",new Locale("tr")).format(new Date()));
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }
    public void addExam(Exam exam){
        QuestionModel questionModel = new QuestionModel();
        ExamModel examModel = new ExamModel();

        ArrayList<Integer> questionID = questionModel.getQuestionIds(exam.getId());
        System.out.println(questionID);
        panel2.setLayout(new GridLayout(questionID.size(), 1));
        for(int i = 0; i< questionID.size();i++){
                StudentGradePanel question = new StudentGradePanel(exam.getId());
                panel2.add(question);
        }
    }


    private void initComponents() {
        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        panel1 = new JPanel();
        nameLabel = new JLabel();
        dateLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        panel2 = new JPanel();
        gradesLabel = new JLabel();
        examButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(182, 142, 185));
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
            .border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder
            .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.
            awt.Font.BOLD,12),java.awt.Color.red),panel1. getBorder()))
            ;panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException();}})
            ;

            //---- nameLabel ----
            nameLabel.setText("Zeliha Ayd\u0131n S018460");
            nameLabel.setForeground(Color.white);
            nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            nameLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 18));

            //---- dateLabel ----
            dateLabel.setText("15.12.2021");
            dateLabel.setForeground(Color.white);
            dateLabel.setFont(new Font("Roboto Light", Font.PLAIN, 18));

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(Color.white);
                scrollPane1.setForeground(Color.white);

                //======== panel2 ========
                {
                    panel2.setLayout(new GridLayout());
                }
                scrollPane1.setViewportView(panel2);
            }

            //---- gradesLabel ----
            gradesLabel.setText("Grades");
            gradesLabel.setForeground(Color.white);

            //---- examButton ----
            examButton.setText("Exam");
            examButton.setBackground(new Color(182, 142, 185));
            examButton.addActionListener(e -> {
			button1(e);
			examButton(e);
			examButton(e);
		});

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateLabel)
                                .addGap(26, 26, 26))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(examButton)
                                .addGap(18, 18, 18)
                                .addComponent(gradesLabel)
                                .addContainerGap(460, Short.MAX_VALUE))))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(dateLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(gradesLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                            .addComponent(examButton))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
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
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
    private JPanel panel1;
    private JLabel nameLabel;
    private JLabel dateLabel;
    private JScrollPane scrollPane1;
    private JPanel panel2;
    private JLabel gradesLabel;
    private JButton examButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
