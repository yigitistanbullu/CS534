package View.StudentsQuestion;

import java.awt.event.*;
import Controller.ExamController.Exam;
import Model.AuthorizationModel;
import Model.ExamModel;
import Model.QuestionModel;
import View.StudentsHomePage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Dec 15 20:52:11 EET 2021
 */


public class QuestionsPage extends JFrame {

    public String userName;
    public int examId;

    public QuestionsPage(int examId, String name) {
        this.userName = name;
        System.out.println(name);
        this.examId=examId;
        initComponents();
        setExamName();
        setUserName();
        addQuestion(examId);
    }
    public void time(){
        new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
                time.setText("Time : " +sdf.format(new Date()));
            }
        }).start();
    }

    public String getUserName() {
        return userName;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamName(){
        ExamModel model = new ExamModel();
        Exam exam1 = model.getExam(getExamId());
        examNameLabel.setText(exam1.getName());
    }

    public void setUserName(){
        userNameLabel.setText(getUserName());
    }

    public void addQuestion(int examId ){
        QuestionModel questionModel = new QuestionModel();
        ArrayList<Integer> questionID = questionModel.getQuestionIds(examId);
        panel2.setLayout(new GridLayout(questionID.size(), 1));
        for(int i = 0; i< questionID.size();i++){
            if(questionModel.getQuestionType(questionID.get(i)).equals( "text")){
                TextQuestion question = new TextQuestion(questionID.get(i), examId);
                question.setNumber(String.valueOf(i+1));
                panel2.add(question);
            }
            else if(questionModel.getQuestionType(questionID.get(i)).equals("multiple_choice")) {
                MultipleQuestion question = new MultipleQuestion(questionID.get(i), examId);
                question.setNumber(String.valueOf(i+1));
                panel2.add(question);

            }
            else if(questionModel.getQuestionType(questionID.get(i)).equals("true_false")){
                TrueFalseQuestion question = new TrueFalseQuestion(questionID.get(i), examId);
                question.setNumber(String.valueOf(i+1));
                panel2.add(question);
            }
        }
    }


    private void submit(ActionEvent e) {
        AuthorizationModel model = new AuthorizationModel();
        String[] name = getUserName().split("\\s+");
        StudentsHomePage studentsHomePage = new StudentsHomePage(model.getUserId(name[0]),getUserName());
        studentsHomePage.setVisible(true);
        dispose();
    }


    private void initComponents() {
        setVisible(true);
        time();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - yasemin
        panel1 = new JPanel();
        userNameLabel = new JLabel();
        examNameLabel = new JLabel();
        questionScrollPane = new JScrollPane();
        panel2 = new JPanel();
        submitButton = new JButton();
        time = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
            .border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder
            .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.
            awt.Font.BOLD,12),java.awt.Color.red),panel1. getBorder()))
            ;panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException();}})
            ;

            //---- userNameLabel ----
            userNameLabel.setText("Zeliha Ayd\u0131n");
            userNameLabel.setForeground(Color.darkGray);
            userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            userNameLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 18));

            //---- examNameLabel ----
            examNameLabel.setText("CS434 Midterm 1");
            examNameLabel.setForeground(Color.darkGray);
            examNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            examNameLabel.setFont(new Font("Roboto Thin", Font.PLAIN, 18));
            examNameLabel.setHorizontalTextPosition(SwingConstants.RIGHT);

            //======== questionScrollPane ========
            {
                questionScrollPane.setBackground(Color.white);
                questionScrollPane.setForeground(Color.white);

                //======== panel2 ========
                {
                    panel2.setLayout(new GridLayout());
                }
                questionScrollPane.setViewportView(panel2);
            }

            //---- submitButton ----
            submitButton.setText("Submit");
            submitButton.setBackground(Color.white);
            submitButton.addActionListener(e -> submit(e));

            //---- time ----
            time.setText("23:45");
            time.setForeground(Color.darkGray);
            time.setHorizontalAlignment(SwingConstants.RIGHT);
            time.setFont(new Font("Roboto Thin", Font.PLAIN, 18));
            time.setHorizontalTextPosition(SwingConstants.RIGHT);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(userNameLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(examNameLabel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(time, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap(619, Short.MAX_VALUE)
                                .addComponent(submitButton))
                            .addComponent(questionScrollPane))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(userNameLabel)
                            .addComponent(examNameLabel)
                            .addComponent(time))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionScrollPane, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitButton)
                        .addContainerGap())
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
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - yasemin
    private JPanel panel1;
    private JLabel userNameLabel;
    private JLabel examNameLabel;
    private JScrollPane questionScrollPane;
    private JPanel panel2;
    private JButton submitButton;
    private JLabel time;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
