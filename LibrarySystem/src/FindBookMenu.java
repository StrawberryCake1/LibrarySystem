import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class FindBookMenu extends JFrame implements ActionListener {
    private Font mainFont;
    private Font secondFont;
    private JPanel mainPanel;
    private JLabel mainTitle;
    private JLabel id;
    private JTextField idField;
    private JButton findeBtn;
    private DatabaseFunctions dbf;
    private Connection connection;
    private JOptionPane optionPane;
    private int massageX;
    private int massageY;
    private int massageWidth;
    private int massageHeight;
    private JLabel[] massageArray = new JLabel[8];
    private JLabel massage;
    private JLabel massageTwo;
    private JLabel massageThree;
    private JLabel massageFour;
    private JLabel massageFive;
    private JLabel massageSix;
    private JLabel massageSeven;
    private JLabel massageEight;
    public FindBookMenu(Connection newConnection, DatabaseFunctions newDbf){
        mainFont = new Font("DialogInput", Font.BOLD, 30);
        secondFont = new Font("DialogInput", Font.BOLD, 10);
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);

        mainTitle = new JLabel("Find book");
        mainTitle.setBounds(305, 0, 200, 50);
        mainTitle.setFont(mainFont);
        mainTitle.setForeground(Color.WHITE);
        id = new JLabel("Finding book id");
        id.setBounds(355, 100, 100, 50);
        id.setFont(secondFont);
        id.setForeground(Color.white);


        JLabel massage = new JLabel("");
        JLabel massageTwo = new JLabel("");
        JLabel massageThree = new JLabel("");
        JLabel massageFour = new JLabel("");
        JLabel massageFive = new JLabel("");
        JLabel massageSix = new JLabel("");
        JLabel massageSeven = new JLabel("");
        JLabel massageEight = new JLabel("");
        massageArray[0] = massage;
        massageArray[1] = massageTwo;
        massageArray[2] = massageThree;
        massageArray[3] = massageFour;
        massageArray[4] = massageFive;
        massageArray[5] = massageSix;
        massageArray[6] = massageSeven;
        massageArray[7] = massageEight;

        massageX = 310;
        massageY = 210;
        massageWidth = 400;
        massageHeight = 20;

        idField = new JTextField();
        idField.setBounds(305, 180, 200, 30);
        idField.setFont(secondFont);
        idField.setBackground(Color.black);
        idField.setForeground(Color.white);

        findeBtn = new JButton("delete book");
        findeBtn.setBounds(330, 370, 150, 30);
        findeBtn.setBackground(Color.black);
        findeBtn.setFont(secondFont);
        findeBtn.addActionListener(this);

        optionPane = new JOptionPane("SS");

        mainPanel.setLayout(null);
        mainPanel.add(idField);
        mainPanel.add(mainTitle);
        mainPanel.add(findeBtn);
        mainPanel.add(id);
        mainPanel.add(massage);
        mainPanel.add(massageTwo);
        mainPanel.add(massageThree);
        mainPanel.add(massageFour);
        mainPanel.add(massageFive);
        mainPanel.add(massageSix);
        mainPanel.add(massageSeven);
        mainPanel.add(massageEight);
        setTitle("Find book");
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
        if (e.getSource() == findeBtn){
            if (this.dbf.searchBookById(this.connection, idField.getText()) == null){
                massageArray[0].setText("No data found !");
                massageArray[0].setBounds(massageX, massageY, massageWidth, massageHeight);
                massageArray[0].setFont(secondFont);
                massageArray[0].setForeground(Color.white);
                for (int i=1;i<massageArray.length;i++){
                    massageArray[i].setText("");
                }
            } else {
                String[] bookInfo = this.dbf.searchBookById(this.connection, idField.getText());
                for (int i=0;i<massageArray.length;i++){
                    int space = i * 20;
                    massageArray[i].setText(bookInfo[i]);
                    massageArray[i].setBounds(massageX, (space + massageY), massageWidth, massageHeight);
                    massageArray[i].setFont(secondFont);
                    massageArray[i].setForeground(Color.white);
                }
            }
        }
    }
}
