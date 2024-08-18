import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Options extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private Font mainFont;
    private Font secondFont;
    private JButton addBookBtn;
    private JButton deleteBookBtn;
    private JButton findBookBtn;
    private JButton sellBookBtn;
    private JButton rentBookBtn;
    private JButton logOutBtn;
    private JButton adminMod;
    private JLabel mainTitle;
    private JLabel userTitle;
    private Connection connection;
    private DatabaseFunctions dbf;
    public Options(Connection newConnection, DatabaseFunctions newDbf){
        this.connection = newConnection;
        this.dbf = newDbf;
        //main font
        mainFont = new Font("DialogInput", Font.BOLD, 30);
        //Second font
        secondFont = new Font("DialogInput", Font.BOLD, 15);
        //Title
        mainTitle = new JLabel("Employee menu");
        mainTitle.setBounds(290, 10, 300, 80);
        mainTitle.setFont(mainFont);
        mainTitle.setForeground(Color.gray);
        //User title
        userTitle = new JLabel("User: ");
        userTitle.setBounds(20, 500, 300, 80);
        userTitle.setFont(secondFont);
        userTitle.setForeground(Color.gray);
        //main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        //add btn
        addBookBtn = new JButton("Add book");
        addBookBtn.setBounds(150, 110, 170, 60);
        addBookBtn.setBackground(Color.black);
        addBookBtn.setFont(secondFont);
        addBookBtn.setForeground(Color.white);
        addBookBtn.addActionListener(this);
        //admin btn
        deleteBookBtn = new JButton("delete book");
        deleteBookBtn.setBounds(150, 230, 170, 60);
        deleteBookBtn.setBackground(Color.black);
        deleteBookBtn.setFont(secondFont);
        deleteBookBtn.setForeground(Color.white);
        deleteBookBtn.addActionListener(this);
        //find btn
        findBookBtn = new JButton("find book");
        findBookBtn.setBounds(150, 350, 170, 60);
        findBookBtn.setBackground(Color.black);
        findBookBtn.setFont(secondFont);
        findBookBtn.setForeground(Color.white);
        findBookBtn.addActionListener(this);
        //sell btn
        sellBookBtn = new JButton("sell book");
        sellBookBtn.setBounds(480, 110, 170, 60);
        sellBookBtn.setBackground(Color.black);
        sellBookBtn.setFont(secondFont);
        sellBookBtn.setForeground(Color.white);
        sellBookBtn.addActionListener(this);
        //rent btn
        rentBookBtn = new JButton("rent book");
        rentBookBtn.setBounds(480, 230, 170, 60);
        rentBookBtn.setBackground(Color.black);
        rentBookBtn.setFont(secondFont);
        rentBookBtn.setForeground(Color.white);
        sellBookBtn.addActionListener(this);
        //logut btn
        logOutBtn = new JButton("logout");
        logOutBtn.setBounds(480, 350, 170, 60);
        logOutBtn.setBackground(Color.black);
        logOutBtn.setFont(secondFont);
        logOutBtn.setForeground(Color.white);
        logOutBtn.addActionListener(this);
        //admin btn
        adminMod = new JButton("admin mod");
        adminMod.setBounds(320, 470, 170, 60);
        adminMod.setBackground(Color.black);
        adminMod.setFont(secondFont);
        adminMod.setForeground(Color.white);
        adminMod.addActionListener(this);

        //add
        mainPanel.add(mainTitle);
        mainPanel.add(addBookBtn);
        mainPanel.add(deleteBookBtn);
        mainPanel.add(findBookBtn);
        mainPanel.add(sellBookBtn);
        mainPanel.add(rentBookBtn);
        mainPanel.add(logOutBtn);
        mainPanel.add(adminMod);
        mainPanel.add(userTitle);
        mainPanel.setLayout(null);
        //frame
        setTitle("LD options");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBookBtn){
            AddBookMenu addBookMenu = new AddBookMenu(this.connection, this.dbf);
        } else if (e.getSource() == deleteBookBtn){
            DeleteBookMenu deleteBookMenu = new DeleteBookMenu(this.connection, this.dbf);
        } else if (e.getSource() == findBookBtn){
            FindBookMenu findBookMenu = new FindBookMenu(this.connection, this.dbf);
        } else if (e.getSource() == sellBookBtn){
            SellBookMenu sellBookMenu = new SellBookMenu(this.connection , this.dbf);
        }
    }
}
