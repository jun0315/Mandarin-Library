package entity;

public class Book {
    private String BookNumber;
    private String Name;
    private String Press;
    private double Price;
    private String Author;
    private String Category;
    private int Amount;
    private String Description;

    public Book() {
        this.BookNumber ="null" ;
        this.Name = "null";
        this.Press = "null";
        this.Price = 0;
        this.Author = "null";
        this.Category = "null";
        this.Amount = 0;
        this.Description="null";
    }

    public String getBookNumber() {
        return BookNumber;
    }

    public void setBookNumber(String bookNumber) {
        BookNumber = bookNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPress() {
        return Press;
    }

    public void setPress(String press) {
        Press = press;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }



    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
