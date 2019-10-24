package entity;

public class Reader {
    private String name;
    private String password;
    private String account;
    private String email;
    private int security_deposit;
    private String type = "Reader";

    public Reader(String account, String password, String name, String email, int deposit){
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.security_deposit = deposit;
    }

    public Reader(){ }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeposit(){ return security_deposit;}

    public void setDeposit(int deposit){ this.security_deposit = deposit;}

    public String getType() {
        return type;
    }
}
