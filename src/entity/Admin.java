package entity;

public class Admin {

    private String name;
    private String password;
    private String phone;
    private String account;
    private String type = "Admin";

    public Admin() {
        this.name = "null";
        this.phone = "null";
        this.account = "null";
        this.password = "null";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getType() {
        return type;
    }
}
