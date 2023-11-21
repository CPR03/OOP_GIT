import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Dashboard_GUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel profilePic;
    private JPanel p1;
    private JLabel homeLogo;
    private JLabel dashMan;
    private JButton btnrequest;
    private JPanel apartment_panel;
    private JScrollPane pane;
    private JLabel unit1;
    private JLabel unit2;
    private JLabel unit3;
    private JLabel unit4;
    private JLabel unit5;
    private JLabel unit6;
    private JLabel unit7;
    private JLabel unit8;
    private JLabel unit9;
    private JPanel scrollPanel;
    private JPanel test;
    private JPanel dashPanel;
    private JButton rentUnit1;
    private JButton rentUnit2;
    private JButton rentUnit3;
    private JButton rentUnit4;
    private JButton rentUnit5;
    private JButton rentUnit6;
    private JButton rentUnit7;
    private JButton rentUnit8;
    private JButton rentUnit9;


    public Dashboard_GUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        pane.getVerticalScrollBar().setUnitIncrement(16); //set scroll speed

        /*for (int i = 1; i <= 12; i++) {

            JLabel label = new JLabel("House" + i, SwingConstants.CENTER);


            label.setIcon(new ImageIcon(new ImageIcon("Images/sample.png").getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH)));
            label.setIcon(new ImageIcon(new ImageIcon("Images/logo.png").getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH)));

            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);

            apartment_panel.add(label);

        }*/

        unit1.setIcon(new ImageIcon(new ImageIcon("Images/sample.png").getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH)));
        unit2.setIcon(new ImageIcon(new ImageIcon("Images/logo.png").getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH)));
        unit3.setIcon(new ImageIcon(new ImageIcon("Images/logo_2.png").getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH)));
        unit4.setIcon(new ImageIcon(new ImageIcon("Images/sample.png").getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH)));
        unit5.setIcon(new ImageIcon(new ImageIcon("Images/logo.png").getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH)));
        unit6.setIcon(new ImageIcon(new ImageIcon("Images/logo_2.png").getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH)));
        unit7.setIcon(new ImageIcon(new ImageIcon("Images/sample.png").getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH)));
        unit8.setIcon(new ImageIcon(new ImageIcon("Images/logo.png").getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH)));
        unit9.setIcon(new ImageIcon(new ImageIcon("Images/logo_2.png").getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH)));


        btnrequest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRequest();
            }
        });


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

        profilePic.setIcon(new ImageIcon(new ImageIcon("Images/profile.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        homeLogo.setIcon(new ImageIcon(new ImageIcon("Images/home_logo.png").getImage().getScaledInstance(150, 70, Image.SCALE_SMOOTH)));
        dashMan.setIcon(new ImageIcon(new ImageIcon("Images/dash_board_man.png").getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH)));


        rentUnit1.setIcon(new ImageIcon(new ImageIcon("Images/button_red.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        rentUnit1.setHorizontalTextPosition(SwingConstants.CENTER);

        rentUnit2.setIcon(new ImageIcon(new ImageIcon("Images/button_red.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        rentUnit2.setHorizontalTextPosition(SwingConstants.CENTER);

        rentUnit3.setIcon(new ImageIcon(new ImageIcon("Images/button_red.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        rentUnit3.setHorizontalTextPosition(SwingConstants.CENTER);

        rentUnit4.setIcon(new ImageIcon(new ImageIcon("Images/button_red.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        rentUnit4.setHorizontalTextPosition(SwingConstants.CENTER);

        rentUnit5.setIcon(new ImageIcon(new ImageIcon("Images/button_red.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        rentUnit5.setHorizontalTextPosition(SwingConstants.CENTER);

        rentUnit6.setIcon(new ImageIcon(new ImageIcon("Images/button_red.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        rentUnit6.setHorizontalTextPosition(SwingConstants.CENTER);

        rentUnit7.setIcon(new ImageIcon(new ImageIcon("Images/button_red.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        rentUnit7.setHorizontalTextPosition(SwingConstants.CENTER);

        rentUnit8.setIcon(new ImageIcon(new ImageIcon("Images/button_red.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        rentUnit8.setHorizontalTextPosition(SwingConstants.CENTER);

        rentUnit9.setIcon(new ImageIcon(new ImageIcon("Images/button_red.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        rentUnit9.setHorizontalTextPosition(SwingConstants.CENTER);

        btnrequest.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rentUnit1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rentUnit2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rentUnit3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rentUnit4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rentUnit5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rentUnit6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rentUnit7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rentUnit8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rentUnit9.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }
    // Method to create an image icon
    protected static ImageIcon createImageIcon(String path) {
        URL imgUrl = Dashboard_GUI.class.getResource(path);
        if (imgUrl != null) {
            return new ImageIcon(imgUrl);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    private void onRequest(){
        Request_Maintenance_GUI req = new Request_Maintenance_GUI();
        req.pack();
        req.setBounds(600,200,600,350);
        req.setTitle("SoulSpace | Request Maintenance");

        req.setVisible(true);

    }

    private void onOK() {
        pane.setVisible(false);
        test.setVisible(true);
    }

    private void onCancel() {
        dispose();
        LogIn_GUI.LogIn_GUI(); //Go back to login if user exit
    }
    Image imageLogo = new ImageIcon("Images/logo.png").getImage();

    public static void main(String[] args) {
        Dashboard_GUI.Dashboard_GUI();
    }

    static void Dashboard_GUI() {

        Dashboard_GUI dialog = new Dashboard_GUI();
        dialog.pack();
        dialog.setBounds(300, 100, 1300, 950);
        dialog.setResizable(false);
        dialog.setTitle("SoulSpace | Dashboard.");
        dialog.setIconImage(dialog.imageLogo);

        dialog.setVisible(true);
    }


}
