public class Book {
    private String title;
    private String author;
    private String date;
    private String genre;
    private int purchasePrice;
    private int rentalPrice;
    public Book(String newTitle, String newAuthor, String newDate, String newGenre, int newPurchasePrice, int newRentalPrice){
        title = newTitle;
        author = newAuthor;
        date = newDate;
        genre = newGenre;
        purchasePrice = newPurchasePrice;
        rentalPrice = newRentalPrice;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getGenre() {
        return genre;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }
}
