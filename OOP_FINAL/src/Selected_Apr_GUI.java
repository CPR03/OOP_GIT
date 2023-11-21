import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Selected_Apr_GUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel panel;
    private JTextArea details;
    private JButton poster;
    private JTabbedPane tabbedPane1;
    private JButton poster2;
    private JButton poster3;
    private JButton poster4;
    private JButton poster5;
    private JButton button1;


    public Selected_Apr_GUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        poster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onDetails();
            }
        });
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        poster.setIcon(new ImageIcon(new ImageIcon("Images/Apartments/Apartments_1.png").getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH)));
        poster.setHorizontalTextPosition(SwingConstants.CENTER);

        details.setText("""
                \s
                House name: Hakim's Crib\s
                Address:  123 Downtown QC\s
                Distance: Tatlo'y Dos\s
                Description: A room with tv, sofa, and picture frames\s
                \s""");


        buttonOK.setIcon(new ImageIcon(new ImageIcon("Images/button_red.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        buttonOK.setHorizontalTextPosition(SwingConstants.CENTER);

        buttonCancel.setIcon(new ImageIcon(new ImageIcon("Images/button_cancel.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        buttonCancel.setHorizontalTextPosition(SwingConstants.CENTER);

    }

    private void onDetails() {

        details.setText("""
                \s
                Owner: Master Hakim
                Contact: 093019120
           
                """);
    }
    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Selected_Apr_GUI dialog = new Selected_Apr_GUI();
        dialog.pack();
        dialog.setTitle("SoulSpace | Hakim's Crib");
        dialog.setVisible(true);
        dialog.setResizable(false);
        System.exit(0);
    }
}
