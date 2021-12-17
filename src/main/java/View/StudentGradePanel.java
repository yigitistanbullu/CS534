/*
 * Created by JFormDesigner on Fri Dec 17 09:49:33 EET 2021
 */

package View;

import Model.AuthorizationModel;
import Model.ExamModel;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Zeliha Aydın
 */
public class StudentGradePanel extends JPanel {

    int examId;

    public StudentGradePanel(int id) {
        this.examId = id;
        initComponents();
        setExamLabel(id);
    }

    public int getExamId() {
        return examId;
    }

    public void setExamGrade(int examGrade) {
        this.examId = examGrade;
    }
    public void setExamLabel(int examId){
        ExamModel examModel = new ExamModel();
        examLabel.setText(examModel.getExam(examId).getName());
        gradeLabel.setText(""+examModel.getExam(examId).getGrade());
    }

    private void initComponents() {
        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        panel3 = new JPanel();
        examLabel = new JLabel();
        gradeLabel = new JLabel();

        //======== panel3 ========
        {
            panel3.setBackground(Color.white);
            panel3.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
            .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing .border . TitledBorder. CENTER ,javax
            . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg", java .awt . Font. BOLD ,
            12 ) ,java . awt. Color .red ) ,panel3. getBorder () ) ); panel3. addPropertyChangeListener( new java. beans
            .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er" .equals ( e.
            getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //---- examLabel ----
            examLabel.setText("cs434 Midterm");
            examLabel.setForeground(new Color(177, 184, 202));
            examLabel.setFont(new Font("Roboto Light", Font.BOLD, 25));

            //---- gradeLabel ----
            gradeLabel.setText("93/100");

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(examLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                        .addComponent(gradeLabel)
                        .addGap(60, 60, 60))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(examLabel)
                            .addComponent(gradeLabel))
                        .addGap(25, 25, 25))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
    private JPanel panel3;
    private JLabel examLabel;
    private JLabel gradeLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
