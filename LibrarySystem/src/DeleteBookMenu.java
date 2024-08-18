import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class DeleteBookMenu extends JFrame implements ActionListener {
    private Font mainFont;
    private Font secondFont;
    private JPanel mainPanel;
    private JLabel mainTitle;
    private JLabel id;
    private JTextField idField;
    private JButton deleteBtn;
    private DatabaseFunctions dbf;
    private Connection connection;
    private JOptionPane optionPane;
    private JLabel massage;
    public DeleteBookMenu(Connection newConnection, DatabaseFunctions newDbf){
        mainFont = new Font("DialogInput", Font.BOLD, 30);
        secondFont = new Font("DialogInput", Font.BOLD, 10);
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);

        mainTitle = new JLabel("Delete book");
        mainTitle.setBounds(305, 0, 200, 50);
        mainTitle.setFont(mainFont);
        mainTitle.setForeground(Color.WHITE);
        id = new JLabel("Deleting book id");
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

        deleteBtn = new JButton("delete book");
        deleteBtn.setBounds(330, 320, 150, 30);
        deleteBtn.setBackground(Color.black);
        deleteBtn.setFont(secondFont);
        deleteBtn.addActionListener(this);

        optionPane = new JOptionPane("SS");

        mainPanel.setLayout(null);
        mainPanel.add(idField);
        mainPanel.add(mainTitle);
        mainPanel.add(deleteBtn);
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
        if (e.getSource() == deleteBtn){
            String id = idField.getText();
            if (this.dbf.isIdValid(this.connection, "books", Integer.parseInt(id))){
                this.dbf.deleteRowById(this.connection, "books", Integer.parseInt(id));
                String massageText = "Book: " + id + " was deleted succesfully !";
                massage.setText("Massage/" + massageText + "/");
            } else {
                String massageText = "Book: " + id + " is not in database !";
                massage.setText("Massage/" + massageText + "/");
            }
        }
    }
}
