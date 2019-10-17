package entity;

public class Detail {
    private String BookNumber;
    private String Copyid;
    private int State;
    public Detail(){
        this.BookNumber="NULL";
        this.Copyid= "null";
        this.State = 0;
    }

    public String getBookNumber() {
        return BookNumber;
    }

    public void setBookNumber(String bookNumber) {
        BookNumber = bookNumber;
    }

    public String getCopyid() {
        return Copyid;
    }

    public void setCopyid(String copyid) {
        Copyid = copyid;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }
}
