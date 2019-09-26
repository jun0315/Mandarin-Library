package entity;

public class Book {
    private int BookNumber;
    private String Name;
    private String Press;
    private String Price;
    private String Author;
    private String Category;
    private int Amount;
    private String Floor;
    private String Shelf;
    private String AreaCode;
    private String Description;

    public Book() {
        this.BookNumber =0 ;
        this.Name = "null";
        this.Press = "null";
        this.Price = "null";
        this.Author = "null";
        this.Category = "null";
        this.Amount = 0;
        this.Floor = "null";
        this.Shelf = "null";
        this.AreaCode="null";
        this.Description="null";
    }


    public int getBookNumber() {
        return BookNumber;
    }

    public void setBookNumber(int bookNumber) {
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

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
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

    public String getFloor() {
        return Floor;
    }

    public void setFloor(String floor) {
        Floor = floor;
    }

    public String getShelf() {
        return Shelf;
    }

    public void setShelf(String shelf) {
        Shelf = shelf;
    }

    public String getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(String areaCode) {
        AreaCode = areaCode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
