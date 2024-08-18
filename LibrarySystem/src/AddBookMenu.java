import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddBookMenu extends JFrame implements ActionListener {
    private Connection connection;
    private DatabaseFunctions dbf;
    private JPanel mainPanel;
    private Font secondFont;
    private Font mainFont;
    private JLabel mainTItle;
    private JTextField title;
    private JTextField author;
    private JTextField date;
    private JTextField genre;
    private JTextField purchasePrice;
    private JTextField rentalPrice;
    private JLabel titleText;
    private JLabel authorText;
    private JLabel dateText;
    private JLabel genreText;
    private JLabel purchasePriceText;
    private JLabel rentalPriceText;
    private JButton addButton;
    public AddBookMenu(Connection connection, DatabaseFunctions dbf){
        this.connection = connection;
        this.dbf = dbf;
        mainFont = new Font("DialogInput", Font.BOLD, 30);
        secondFont = new Font("DialogInput", Font.BOLD, 15);

        mainTItle = new JLabel("Add new book");
        mainTItle.setBounds(300, 0, 300, 50);
        mainTItle.setFont(mainFont);

        titleText = new JLabel("Title");
        titleText.setBounds(385, 50, 100, 50);
        titleText.setFont(secondFont);
        titleText.setForeground(Color.white);

        authorText = new JLabel("Author");
        authorText.setBounds(380, 125, 100, 50);
        authorText.setFont(secondFont);
        authorText.setForeground(Color.white);

        dateText = new JLabel("Date");
        dateText.setBounds(385, 200, 100, 50);
        dateText.setFont(secondFont);
        dateText.setForeground(Color.white);

        genreText = new JLabel("Genre");
        genreText.setBounds(385, 275, 100, 50);
        genreText.setFont(secondFont);
        genreText.setForeground(Color.white);

        purchasePriceText = new JLabel("Purchase price");
        purchasePriceText.setBounds(345, 350, 200, 50);
        purchasePriceText.setFont(secondFont);
        purchasePriceText.setForeground(Color.white);

        rentalPriceText = new JLabel("Rent price");
        rentalPriceText.setBounds(360, 425, 100, 50);
        rentalPriceText.setFont(secondFont);
        rentalPriceText.setForeground(Color.white);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);

        title = new JTextField();
        title.setBounds(305, 100, 200, 30);
        title.setFont(secondFont);
        title.setBackground(Color.black);
        title.setForeground(Color.white);

        author = new JTextField();
        author.setBounds(305, 175, 200, 30);
        author.setFont(secondFont);
        author.setBackground(Color.black);
        author.setForeground(Color.white);

        date = new JTextField();
        date.setBounds(305, 250, 200, 30);
        date.setFont(secondFont);
        date.setBackground(Color.black);
        date.setForeground(Color.white);

        genre = new JTextField();
        genre.setBounds(305, 325, 200, 30);
        genre.setFont(secondFont);
        genre.setBackground(Color.black);
        genre.setForeground(Color.white);

        purchasePrice = new JTextField();
        purchasePrice.setBounds(305, 400, 200, 30);
        purchasePrice.setFont(secondFont);
        purchasePrice.setBackground(Color.black);
        purchasePrice.setForeground(Color.white);

        rentalPrice = new JTextField();
        rentalPrice.setBounds(305, 475, 200, 30);
        rentalPrice.setFont(secondFont);
        rentalPrice.setBackground(Color.black);
        rentalPrice.setForeground(Color.white);

        addButton = new JButton("Add");
        addButton.setBounds(330, 530, 150, 30);
        addButton.setBackground(Color.black);
        addButton.setFont(secondFont);
        addButton.addActionListener(this);

        mainPanel.setLayout(null);
        mainPanel.add(mainTItle);
        mainPanel.add(titleText);
        mainPanel.add(authorText);
        mainPanel.add(dateText);
        mainPanel.add(genreText);
        mainPanel.add(purchasePriceText);
        mainPanel.add(rentalPrice);
        mainPanel.add(addButton);

        mainPanel.add(title);
        mainPanel.add(author);
        mainPanel.add(date);
        mainPanel.add(genre);
        mainPanel.add(purchasePrice);
        mainPanel.add(rentalPriceText);

        setTitle("Add book menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 650);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        add(mainPanel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String newTitle = null;
            String newAuthor = null;
            String newDate = null;
            String newGenre = null;
            String newPurchasePrice = null;
            String newRentalPrice = null;
            if (e.getSource() == addButton){
                newTitle = title.getText();
                newAuthor = author.getText();
                newDate = date.getText();
                newGenre = genre.getText();
                newPurchasePrice = purchasePrice.getText();
                newRentalPrice = rentalPrice.getText();
            }
            Book newBook = new Book(newTitle, newAuthor, newDate, newGenre, Integer.parseInt(newPurchasePrice), Integer.parseInt(newRentalPrice));
            this.dbf.createBookRow(this.connection, newBook);
        } catch (Exception exception){
            System.out.println(exception);
        }
    }
}
