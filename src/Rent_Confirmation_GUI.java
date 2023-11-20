import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rent_Confirmation_GUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JRadioButton a1MonthRadioButton;
    private JRadioButton a6MonthsRadioButton;
    private JRadioButton a1YearRadioButton;
    private JCheckBox amenitiesCheckBox;
    private JCheckBox wiFiCheckBox;
    private JRadioButton othersRadioButton;
    private JCheckBox cableCheckBox;
    private JCheckBox waterCheckBox;
    private JLabel homeLogo;

    public Rent_Confirmation_GUI() {
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

        homeLogo.setIcon(new ImageIcon(new ImageIcon("Images/home_logo.png").getImage().getScaledInstance(150, 70, Image.SCALE_SMOOTH)));

        buttonOK.setIcon(new ImageIcon(new ImageIcon("Images/button_red.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        buttonOK.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonOK.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonCancel.setIcon(new ImageIcon(new ImageIcon("Images/button_cancel.png").getImage().getScaledInstance(80, 23, Image.SCALE_SMOOTH)));
        buttonCancel.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    Image imageLogo = new ImageIcon("Images/logo.png").getImage();
    public static void main(String[] args) {
        Rent_Confirmation_GUI dialog = new Rent_Confirmation_GUI();
        dialog.pack();
        dialog.setBounds(300,100,330,490);
        dialog.setResizable(false);
        dialog.setTitle("SoulSpace | Dashboard.");
        dialog.setIconImage(dialog.imageLogo);

        dialog.setVisible(true);
        System.exit(0);
    }


}
