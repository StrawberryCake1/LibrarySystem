import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class SellBookMenu extends JFrame implements ActionListener {
    private Font mainFont;
    private Font secondFont;
    private JPanel mainPanel;
    private JLabel mainTitle;
    private JLabel id;
    private JTextField idField;
    private JButton sellBtn;
    private DatabaseFunctions dbf;
    private Connection connection;
    private JOptionPane optionPane;
    private JLabel massage;
    public SellBookMenu(Connection newConnection, DatabaseFunctions newDbf){
        mainFont = new Font("DialogInput", Font.BOLD, 30);
        secondFont = new Font("DialogInput", Font.BOLD, 10);
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);

        mainTitle = new JLabel("Sell book");
        mainTitle.setBounds(305, 0, 200, 50);
        mainTitle.setFont(mainFont);
        mainTitle.setForeground(Color.WHITE);
        id = new JLabel("Selling book id");
        id.setBounds(355, 100, 100, 50);
        id.setFont(secondFont);
        id.setForeground(Color.white);

        massage = new JLabel("");
        massage.setBounds(330, 240, 400, 50);
        massage.setFont(secondFont);
        massage.setForeground(Color.white);


        idField = new JTextField();
        idField.setBounds(305, 180, 200, 30);
        idField.setFont(secondFont);
        idField.setBackground(Color.black);
        idField.setForeground(Color.white);

        sellBtn = new JButton("delete book");
        sellBtn.setBounds(330, 320, 150, 30);
        sellBtn.setBackground(Color.black);
        sellBtn.setFont(secondFont);
        sellBtn.addActionListener(this);

        optionPane = new JOptionPane("SS");

        mainPanel.setLayout(null);
        mainPanel.add(idField);
        mainPanel.add(mainTitle);
        mainPanel.add(sellBtn);
        mainPanel.add(id);
        mainPanel.add(massage);
        setTitle("Delete book");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        add(mainPanel);
        this.connection = newConnection;
        this.dbf = newDbf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sellBtn){
            if (this.dbf.isIdValid(this.connection,"books", Integer.parseInt(idField.getText()))){
                this.dbf.s
            } else {
                massage.setText("No data found !");
            }
        }
    }
}
