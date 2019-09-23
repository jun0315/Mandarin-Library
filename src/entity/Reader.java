package entity;

public class Reader {
    private String name;
    private String password;
    private String account;
    private String email;
    private int security_deposit;
    private String type = "Reader";

    public Reader(){
        this.name = "null";
        this.password = "null";
        this.account = "null";
        this.email = "null";
        this.security_deposit = 0;
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
