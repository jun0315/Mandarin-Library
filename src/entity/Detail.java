package entity;

public class Detail {
    private String BookNumber;
    private String Copyid;
    private int State;
    //副本所從屬的書的大類
    private int Floor;
    private String Shelf;

    private String Name;

    public Detail() {
        this.BookNumber = "NULL";
        this.Copyid = "null";
        this.State = 0;
    }


    public String getCopyid() {
        return Copyid;
    }

    public void setCopyid(String copyid) {
        Copyid = copyid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public int getFloor() {
        return Floor;
    }

    public void setFloor(int floor) {
        Floor = floor;
    }

    public String getShelf() {
        return Shelf;
    }

    public void setShelf(String shelf) {
        Shelf = shelf;
    }

    public String getAreacode() {
        return Areacode;
    }

    public void setAreacode(String areacode) {
        Areacode = areacode;
    }

    private String Areacode;


    public String getBookNumber() {
        return BookNumber;
    }

    public void setBookNumber(String bookNumber) {
        BookNumber = bookNumber;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }
}
