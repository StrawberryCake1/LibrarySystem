import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private Font mainFont;
    private Font secondFont;
    private JButton addBookBtn;
    private JButton deleteBookBtn;
    private JButton findBookBtn;
    private JButton sellBookBtn;
    private JButton rentBookBtn;
    private JButton logOutBtn;
    private JLabel mainTitle;
    private JLabel userTitle;
    public Admin(){
        mainFont = new Font("DialogInput", Font.BOLD, 30);
        //Second font
        secondFont = new Font("DialogInput", Font.BOLD, 15);
        //Title
        mainTitle = new JLabel("Admin menu");
        mainTitle.setBounds(310, 10, 300, 80);
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
        addBookBtn = new JButton("Create client");
        addBookBtn.setBounds(150, 110, 170, 60);
        addBookBtn.setBackground(Color.black);
        addBookBtn.setFont(secondFont);
        addBookBtn.setForeground(Color.white);
        //admin btn
        deleteBookBtn = new JButton("Edit client");
        deleteBookBtn.setBounds(150, 230, 170, 60);
        deleteBookBtn.setBackground(Color.black);
        deleteBookBtn.setFont(secondFont);
        deleteBookBtn.setForeground(Color.white);
        //find btn
        findBookBtn = new JButton("Delete client");
        findBookBtn.setBounds(150, 350, 170, 60);
        findBookBtn.setBackground(Color.black);
        findBookBtn.setFont(secondFont);
        findBookBtn.setForeground(Color.white);
        //sell btn
        sellBookBtn = new JButton("Create table");
        sellBookBtn.setBounds(480, 110, 170, 60);
        sellBookBtn.setBackground(Color.black);
        sellBookBtn.setFont(secondFont);
        sellBookBtn.setForeground(Color.white);
        //rent btn
        rentBookBtn = new JButton("Delete table");
        rentBookBtn.setBounds(480, 230, 170, 60);
        rentBookBtn.setBackground(Color.black);
        rentBookBtn.setFont(secondFont);
        rentBookBtn.setForeground(Color.white);
        //logut btn
        logOutBtn = new JButton("Log out");
        logOutBtn.setBounds(480, 350, 170, 60);
        logOutBtn.setBackground(Color.black);
        logOutBtn.setFont(secondFont);
        logOutBtn.setForeground(Color.white);
        //add
        mainPanel.add(mainTitle);
        mainPanel.add(addBookBtn);
        mainPanel.add(deleteBookBtn);
        mainPanel.add(findBookBtn);
        mainPanel.add(sellBookBtn);
        mainPanel.add(rentBookBtn);
        mainPanel.add(logOutBtn);
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

    }
}
