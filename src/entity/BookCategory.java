package entity;

public class BookCategory {
    public BookCategory(String category, String floor) {
        this.category = category;
    }

    public BookCategory() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String category;
}
