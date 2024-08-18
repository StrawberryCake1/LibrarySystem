import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.postgresql.PGProperty.PASSWORD;

public class DatabaseFunctions {
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

    public void createBookTable(Connection connection, String tableName) {
        Statement statement = null;
        try {
            String query = "CREATE TABLE " + tableName + "(id SERIAL, title varchar(200), author varchar(200), date varchar(200), genre varchar(200), purchase_price INTEGER, rental_price INTEGER, number_of_books INTEGER)";
            statement = connection.createStatement();
            statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void createAccountTable(Connection connection, String tableName) {
        Statement statement = null;
        try {
            String query = "CREATE TABLE " + tableName + "(id SERIAL, name varchar(200), surname varchar(200), date_of_birth varchar(200), birth_number varchar(200), password varchar(200))";
            statement = connection.createStatement();
            statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void updateData(Connection connection, String tableName, int id, String oldData, String newData, DataType dataType){
        Statement statement = null;
        String newDataType = "";
        if (tableName.equals("accounts")){
            switch (dataType) {
                case ID -> newDataType = "id";
                case NAME -> newDataType = "name";
                case SURNAME -> newDataType = "surname";
                case DATEOFBIRTH -> newDataType = "date_of_birth";
                case BIRTHUMBER -> newDataType = "birth_number";
                case PASSWORD -> newDataType = "password";

            }
        } else {
            switch (dataType) {
                case ID -> newDataType = "id";
                case TITLE -> newDataType = "title";
                case AUTHOR -> newDataType = "author";
                case GENRE -> newDataType = "genre";
                case DATE -> newDataType = "date";
                case PURCHASEPRICE -> newDataType = "purchase_price";
                case RENTALPRICE -> newDataType = "rental_price";
                case NUMBEROFBOOKS -> newDataType = "number_of_books";
            }
        }
        try {
            String query = "UPDATE " + tableName +
                    " SET " + newDataType + "='" + newData + "'" +
                    " WHERE " + newDataType + "='" + oldData + "' AND id=" + id;
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Error while updating data: " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                System.out.println("Error while closing statement: " + e.getMessage());
            }
        }
    }
    public void createBookRow(Connection connection, Book book){
        this.insertRow(connection, "books", book.getTitle(), book.getAuthor(), book.getDate(), book.getGenre(), book.getPurchasePrice(), book.getRentalPrice());
    }
    public int increaseNumberOfExistingBook(Connection connection, int bookId, int amount){
        Statement statement = null;
        ResultSet resultSet = null;
        String[] dataArray = null;
        try {
            String query = "UPDATE * FROM books WHERE id='" + bookId + "'";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int numberOfBooks = resultSet.getInt("number_of_books");
                return numberOfBooks;
            } else {
                System.out.println("No data found");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return -1;
    }
    public void insertBookRow(Connection connection, String tableName, String title, String author, String date, String genre, int purchasePrice, int rentalPrice){
        Statement statement = null;
        try {
            int numberOfBooks = 1;
            String query = String.format("insert into %s(title,author,date,genre,purchase_price,rental_price, number_of_books) values('%s','%s','%s','%s',%d,%d);", tableName, title, author, date, genre, purchasePrice, rentalPrice, numberOfBooks);
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void insertAccountRow(Connection connection, String tableName, String name, String surName, String dateOfBirth, String birthNumber, String password){
        Statement statement = null;
        try {
            String query = String.format("insert into %s(name,surname,date_of_birth,birth_number,password,rental_price, number_of_books) values('%s','%s','%s','%s');", tableName, name, surName, dateOfBirth, birthNumber, password);
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void insertRow(Connection connection, String tableName, String title, String author, String date, String genre, int purchasePrice, int rentalPrice) {
        Statement statement = null;
        try {
            int numberOfBooks = 1;
            String query = String.format("insert into %s(title,author,date,genre,purchase_price,rental_price, number_of_books) values('%s','%s','%s','%s',%d, %d, %d);", tableName, title, author, date, genre, purchasePrice, rentalPrice, numberOfBooks);
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public boolean isIdValid(Connection connection, String tableName, int id) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM " + tableName + " WHERE id ='" + id + "'";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                if (id == resultSet.getInt("id")) {
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return false;
    }
    public void deleteTable(Connection connection, String tableName){
        Statement statement = null;
        try {
            String query = String.format("DROP TABLE %s", tableName);
            statement = connection.createStatement();
            statement.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void deleteRowById(Connection connection, String tableName, int id) {
        Statement statement = null;
        ResultSet resultSet = null;
        String dataForDelete = "";
        try {
            String query = "DELETE FROM " + tableName + " WHERE " + " id " + " = " + id;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            int searched = resultSet.getInt("id");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public int getNumberOfBooksById(Connection connection, int id){
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM books WHERE id ='" + id + "'";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int numberOfBooks = resultSet.getInt("number_of_books");
                return numberOfBooks;
            } else {
                System.out.println("No data found");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return 0;
    }
    public String[] searchBookById(Connection connection, String searchedId) {
        Statement statement = null;
        ResultSet resultSet = null;
        String[] dataArray = null;
        try {
            String query = "SELECT * FROM books WHERE id='" + searchedId + "'";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String date = resultSet.getString("date");
                String genre = resultSet.getString("genre");
                int purchaseprice = resultSet.getInt("purchase_price");
                int rentalprice = resultSet.getInt("rental_price");
                int numberOfBooks = resultSet.getInt("number_of_books");
                /*
                System.out.println("id: " + id);
                System.out.println("title: " + title);
                System.out.println("author: " + author);
                System.out.println("date: " + date);
                System.out.println("genre: " + genre);
                System.out.println("purchase_price: " + purchaseprice);
                System.out.println("rental_price: " + rentalprice);
                 */
                dataArray = new String[8];
                dataArray[0] = "id: " + id;
                dataArray[1] = "title: " + title;
                dataArray[2] = "author: " + author;
                dataArray[3] = "date: " + date;
                dataArray[4] = "genre: " + genre;
                dataArray[5] = "purchase_price: " + purchaseprice;
                dataArray[6] = "rental_price: " + rentalprice;
                dataArray[7] = "number_of_books: " + numberOfBooks;
                return dataArray;
            } else {
                System.out.println("No data found");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return null;
    }
    public void editNumberOfBooks(Connection connection, int id, int amount){
        if (this.isIdValid(connection,"books", id)){
            int oldNumber = this.getNumberOfBooksById(connection, id);
            int newNumber = oldNumber + amount;
            this.updateData(connection,"books",id,oldNumber+"",newNumber+"",DataType.NUMBEROFBOOKS);
        }
    }
}
