import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Wed Dec 15 20:28:19 EET 2021
 */



/**
 * @author Zeliha Aydın
 */
public class TrueFalseQuestion extends JPanel {
    public TrueFalseQuestion() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Zeliha Aydın
        questionText = new JTextField();
        questionLabel = new JLabel();
        submitButton = new JButton();
        trueCheck = new JCheckBox();
        falseCheck = new JCheckBox();

        //======== this ========
        setBackground(Color.white);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
        , 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
         getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- questionText ----
        questionText.setBackground(Color.white);

        //---- questionLabel ----
        questionLabel.setText("Enter question here");

        //---- submitButton ----
        submitButton.setText("Submit");
        submitButton.setBackground(Color.white);

        //---- trueCheck ----
        trueCheck.setText("True");
        trueCheck.setBackground(Color.white);

        //---- falseCheck ----
        falseCheck.setText("False");
        falseCheck.setBackground(Color.white);

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
                            .addComponent(submitButton))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(falseCheck, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addComponent(trueCheck, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(questionLabel)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(questionText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(trueCheck)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                            .addComponent(submitButton)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(falseCheck)
                            .addContainerGap(25, Short.MAX_VALUE))))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Zeliha Aydın
    private JTextField questionText;
    private JLabel questionLabel;
    private JButton submitButton;
    private JCheckBox trueCheck;
    private JCheckBox falseCheck;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
