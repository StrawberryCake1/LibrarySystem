import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Login extends JFrame implements ActionListener {
    private JLabel login;
    private JTextField idText;
    private JLabel passwText;
    private JLabel id;
    private JPasswordField password;
    private JPanel mainPanel;
    private JButton loginButton;
    private Font mainFont;
    private Font secondFont;
    private Connection connection;
    private DatabaseFunctions dbf;
    public Login(Connection newConnection, DatabaseFunctions newDbf){
        //Frame
        //panel
        this.connection = newConnection;
        this.dbf = newDbf;
        mainFont = new Font("DialogInput", Font.BOLD, 30);
        secondFont = new Font("DialogInput", Font.BOLD, 10);
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        //login
        login = new JLabel("Login");
        login.setBounds(370, 0, 100, 50);
        login.setFont(mainFont);
        login.setForeground(Color.gray);
        //id label
        id = new JLabel("Your id");
        id.setBounds(385, 100, 100, 50);
        id.setFont(secondFont);
        id.setForeground(Color.white);
        //id text
        idText = new JTextField();
        idText.setBounds(310, 150, 200, 30);
        idText.setFont(secondFont);
        idText.setBackground(Color.black);
        //pssw txt
        passwText = new JLabel("Your password");
        passwText.setBounds(365, 200, 100, 50);
        passwText.setFont(secondFont);
        passwText.setForeground(Color.white);
        //psw label
        password = new JPasswordField();
        password.setBounds(310, 250, 200, 30);
        password.setFont(secondFont);
        password.setBackground(Color.black);
        //Log btn
        loginButton = new JButton("Login");
        loginButton.setBounds(335, 350, 150, 50);
        loginButton.setBackground(Color.black);
        loginButton.setFont(secondFont);
        //panel btn
        mainPanel.setLayout(null);
        mainPanel.add(login);
        mainPanel.add(idText);
        mainPanel.add(passwText);
        mainPanel.add(id);
        mainPanel.add(password);
        mainPanel.add(loginButton);
        setTitle("LD login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        add(mainPanel);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        System.out.println("Getting the font family names");

        // Array of all the fonts available in AWT
        String fonts[] = ge.getAvailableFontFamilyNames();

        // Getting the font family names
        for (String i : fonts) {
            System.out.println(i + " ");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton){

        }
    }
}
