package View.ExamQuestions;

import java.awt.event.*;

import Controller.ExamController.Exam;
import Controller.ExamController.Examination;
import Model.AuthorizationModel;
import Model.ExamModel;
import Model.QuestionModel;
import View.StudentsHomePage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Dec 15 20:52:11 EET 2021
 */


public class QuestionsPage extends JFrame {

    public String userName;
    public int examId;
    public int userType;

    public QuestionsPage(int examId, String name, int userType) {
        this.userName = name;
        this.examId=examId;
        this.userType = userType;
        initComponents();
        setExamName();
        setUserName();
        addQuestion(examId);
        setIcon();
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
        Examination examination1 = model.getExam(getExamId());
        examNameLabel.setText(examination1.getName());
    }

    public int getUserType() {
        return userType;
    }

    public void setUserName(){
        userNameLabel.setText(getUserName());
    }

    public void addQuestion(int examId ){
        QuestionModel questionModel = new QuestionModel();
        ArrayList<Integer> questionID = questionModel.getQuestionIds(examId);
        AuthorizationModel model = new AuthorizationModel();
        String[] name = getUserName().split("\\s+");
        panel2.setLayout(new GridLayout(questionID.size(), 1));
        for(int i = 0; i< questionID.size();i++){
            if(questionModel.getQuestionType(questionID.get(i)).equals( "text")){
                TextQuestion question = new TextQuestion.Builder(questionID.get(i), examId, model.getUserId(name[0])).withQuestionNumber(String.valueOf(i+1)).withUserType(getUserType()).build();
                question.removeGrade();
                panel2.add(question);
            }
            else if(questionModel.getQuestionType(questionID.get(i)).equals("multiple_choice")) {
                MultipleQuestion question = new MultipleQuestion.Builder(questionID.get(i), examId, model.getUserId(name[0])).withQuestionNumber(String.valueOf(i+1)).withUserType(getUserType()).build();
                question.removeGradeForExamination();
                panel2.add(question);

            }
            else if(questionModel.getQuestionType(questionID.get(i)).equals("true_false")){
                TrueFalseQuestion question = new TrueFalseQuestion.Builder(questionID.get(i), examId, model.getUserId(name[0])).withQuestionNumber(String.valueOf(i+1)).withUserType(getUserType()).build();
                question.removeGrade();
                panel2.add(question);
            }
        }
    }

    public void setIcon(){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/main/java/View/Images/ou_logo_ing.png"));
            Image ozuLogo = img.getScaledInstance(ozuLogoLabel.getWidth(),ozuLogoLabel.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(ozuLogo);
            ozuLogoLabel.setIcon(imageIcon);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void submit(ActionEvent e) {
        AuthorizationModel model = new AuthorizationModel();
        String[] name = getUserName().split("\\s+");
        ExamModel examModel = new ExamModel();
        examModel.attendExam(model.getUserId(name[0]),getExamId());
        StudentsHomePage studentsHomePage = new StudentsHomePage(model.getUserId(name[0]),getUserName());
        studentsHomePage.setVisible(true);
        dispose();
    }

    private void initComponents() {
        setVisible(true);
        time();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yasemin Orhun
        panel1 = new JPanel();
        userNameLabel = new JLabel();
        examNameLabel = new JLabel();
        questionScrollPane = new JScrollPane();
        panel2 = new JPanel();
        submitButton = new JButton();
        time = new JLabel();
        ozuLogoLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
            . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing
            . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
            Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
            ) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
            public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName (
            ) )) throw new RuntimeException( ); }} );

            //---- userNameLabel ----
            userNameLabel.setText("Student Name");
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

            //---- ozuLogoLabel ----
            ozuLogoLabel.setText("text");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGap(0, 369, Short.MAX_VALUE)
                                .addComponent(ozuLogoLabel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                .addGap(290, 290, 290)
                                .addComponent(submitButton))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(userNameLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162)
                                .addComponent(examNameLabel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                                .addComponent(time, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(questionScrollPane, GroupLayout.PREFERRED_SIZE, 816, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 20, Short.MAX_VALUE)))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(examNameLabel)
                            .addComponent(time)
                            .addComponent(userNameLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionScrollPane, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(submitButton)
                            .addComponent(ozuLogoLabel, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addGap(9, 9, 9))
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
    // Generated using JFormDesigner Evaluation license - Yasemin Orhun
    private JPanel panel1;
    private JLabel userNameLabel;
    private JLabel examNameLabel;
    private JScrollPane questionScrollPane;
    private JPanel panel2;
    private JButton submitButton;
    private JLabel time;
    private JLabel ozuLogoLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
