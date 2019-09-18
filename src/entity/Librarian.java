package entity;

public class Librarian {
    private String name;
    private String phone;

    public Librarian(){
        this.name = "null";
        this.phone = "null";
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
