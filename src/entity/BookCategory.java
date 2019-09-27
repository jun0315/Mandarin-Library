package entity;

public class BookCategory {
    public BookCategory(String category, String floor) {
        this.category = category;
        this.floor = floor;
    }

    public BookCategory(){}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    private String category;
    private String floor;
}
