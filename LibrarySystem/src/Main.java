import java.sql.Connection;

public class Main {
    public static void main(String [] args) {

        //var log = new Login();
        //Login login = new Login();
        DatabaseFunctions dbFunc = new DatabaseFunctions();
        Connection connection = dbFunc.createConnectionToDatabse("LibraryDatabase", "postgres", "admpassw97411!");
        //AddBookMenu addBookMenu = new AddBookMenu(connection, dbFunc);
        //var emp = new DeleteBookMenu(connection, dbFunc);
        Options options = new Options(connection, dbFunc);
        //FindBookMenu findBookMenu = new FindBookMenu(connection, dbFunc);
        //Book newBook = new Book("Harry Potter 2", "Rowling", "2001", "Fantasy", 12, 2);
        //dbFunc.createBookRow(connection, newBook);
    }
}