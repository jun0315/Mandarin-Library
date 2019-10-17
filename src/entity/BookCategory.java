package entity;

public class BookCategory {
    public BookCategory(String category, int floor, String shelf) {
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    private String category;
    private int floor;
    private String shelf;
}
