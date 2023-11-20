import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class LogIn_GUI extends JDialog {
    public Image imageLogo;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtUserLog;
    private JPasswordField txtpass;
    private JLabel logInPic;
    private JLabel labelLogo;
    private JButton btnSignUp;
    private JButton button1;


    public LogIn_GUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);




        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Image imageLogo = new ImageIcon("Images/logo.png").getImage();
                SignIn_GUI sign = new SignIn_GUI();
                sign.pack();
                sign.setTitle("SoulSpace | Sign up.");
                sign.setIconImage(sign.imageLogo);
                sign.setResizable(false);
                sign.setBounds(600,200,600,350);
                sign.setVisible(true);
                //not working
                LogIn_GUI log = new LogIn_GUI();
                log.setVisible(false);
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


        //Sign in Picture
        logInPic.setIcon(new ImageIcon(new ImageIcon("Images/sign_in.png").getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH)));
        labelLogo.setIcon(new ImageIcon(new ImageIcon("Images/logo.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));

        //Rounded Buttons
        buttonOK.setIcon(new ImageIcon(new ImageIcon("Images/button_red.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        buttonOK.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonOK.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonCancel.setIcon(new ImageIcon(new ImageIcon("Images/button_cancel.png").getImage().getScaledInstance(80, 23, Image.SCALE_SMOOTH)));
        buttonCancel.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnSignUp.setCursor(new Cursor(Cursor.HAND_CURSOR));


    }

    private void onOK() {



        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apartment", "root","root");
            Statement state = con.createStatement();
            ResultSet result = state.executeQuery("Select userName from apartment.users where userName = " + txtUserLog.getText());

            while (result.next()){
                if(result.equals("test")){
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"User not FOund","Error",JOptionPane.WARNING_MESSAGE);
                }
            }


        }
        catch(Exception exc){
            exc.printStackTrace();
        }


    }

    private void onCancel() {
        System.exit(0);
    }





}
