package entity;

public class BookDetail {
    private String CopyID;
    private int Floor;
    private String Shelf;
    private String AreaCode;
    private String Path;

    public BookDetail(){
        this.CopyID=null;
        this.Floor=0;
        this.Shelf=null;
        this.AreaCode=null;
        this.Path=null;
    }


    public String getCopyID() {
        return CopyID;
    }

    public void setCopyID(String copyID) {
        CopyID = copyID;
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

    public String getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(String areaCode) {
        AreaCode = areaCode;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }
}
