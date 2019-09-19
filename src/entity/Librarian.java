package entity;

public class Librarian {
    private String name;
    private String phone;
    private String account;

    public Librarian() {
        this.name = "null";
        this.phone = "null";
        this.account = "null";
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
