import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SignUp_GUI extends JDialog {
    public Image imageLogo;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtUserLog;
    private JPasswordField passfield;
    private JLabel logInPic;
    private JLabel labelLogo;
    private JButton btnLogIn;
    private JButton button1;


    public SignUp_GUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                onOK();

            }
        });

        btnLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                onBack();

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


    }

    private void onOK() {


        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apartment", "root", "root");
            Statement state = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet result = state.executeQuery("SELECT * FROM apartment.users");

            boolean usernameExists = false;

            while (result.next()) {

                String userNameFromDatabase = result.getString("userName").toLowerCase();

                if (userNameFromDatabase.equals(txtUserLog.getText().toLowerCase())) {
                    JOptionPane.showMessageDialog(null, "Username already exists");
                    usernameExists = true;
                    break;  // exit the loop as soon as a matching username is found
                }

            }

            if (!usernameExists) {

                setVisible(false);
                String usernameInput = txtUserLog.getText();
                String passText = new String(passfield.getPassword());

                // Inserting row to the last row of the table
                result.last();
                int id = result.getInt("user_id") + 1; //get current id and ADD 1
                result.moveToInsertRow();
                result.updateInt("user_id", id); //add the newly created ID
                result.updateString("userName", usernameInput.toLowerCase()); //add username
                result.updateString("userPassword", passText.toLowerCase()); //add password
                result.insertRow();
                result.beforeFirst();
                JOptionPane.showMessageDialog(null, "Account successfully created.");
                LogIn_GUI.LogIn_GUI(); // Go back to Login

            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }


    }


    //Go back to Login if back button is pressed
    private void onBack(){
        setVisible(false);

        LogIn_GUI.LogIn_GUI();
    }

    private void onCancel() {
        dispose();
    }

}
