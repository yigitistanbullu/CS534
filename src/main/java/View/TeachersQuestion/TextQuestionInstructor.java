package View.TeachersQuestion;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Dec 15 20:21:28 EET 2021
 */



/**
 * @author Zeliha Aydın
 */
public class TextQuestionInstructor extends JPanel {
    public TextQuestionInstructor() {
        initComponents();
    }

    private void initComponents() {
        setVisible(true);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        questionText = new JTextField();
        questionLabel = new JLabel();
        submitButton = new JButton();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- questionText ----
        questionText.setBackground(Color.white);

        //---- questionLabel ----
        questionLabel.setText("Enter question here");

        //---- submitButton ----
        submitButton.setText("Submit");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(questionLabel)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(questionText, GroupLayout.PREFERRED_SIZE, 595, GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitButton)))
                    .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(questionLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(questionText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                    .addComponent(submitButton)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
    private JTextField questionText;
    private JLabel questionLabel;
    private JButton submitButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
