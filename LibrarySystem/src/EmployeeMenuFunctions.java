import java.sql.Connection;
import java.sql.DriverManager;

public class EmployeeMenuFunctions {
    private Connection connection;
    private DatabaseFunctions dbf;
    public EmployeeMenuFunctions(Connection connection, DatabaseFunctions dbf){
        this.connection = connection;
        this.dbf = dbf;
    }
    public Connection createConnectionToDatabse(String databaseName, String user, String pass) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + databaseName, user, pass);
            if (connection != null) {
                System.out.println("Connection established");
            } else {
                System.out.println("Connection failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
    public void addBookFunction(){
        AddBookMenu addBookMenu = new AddBookMenu(this.connection, this.dbf);
    }
    public void deleteBookFunction(){

    }
}
