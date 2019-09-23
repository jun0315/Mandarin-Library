package entity;

public class BookCategory {
    public BookCategory(String category, String location) {
        this.category = category;
        this.location = location;
    }

    public BookCategory(){}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String category;
    private String location;
}
