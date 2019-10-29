package entity;

import java.sql.Date;

public class Reader {
    private String name;
    private String password;
    private String account;
    private String email;
    private int security_deposit;
    private String type = "Reader";
    private Date register_time;
    private int borrowing_count;

    public Reader(String account, String password, String name, String email, int deposit) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.security_deposit = deposit;
        this.register_time = new Date(System.currentTimeMillis());
        this.borrowing_count = 0;
    }

    public Reader(String account, String password, String name, String email, int deposit, Date register_time) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.security_deposit = deposit;
        this.register_time = register_time;
        this.borrowing_count = 0;
    }

    public Reader() {
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

    public int getDeposit() {
        return security_deposit;
    }

    public void setDeposit(int deposit) {
        this.security_deposit = deposit;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }

    public String getType() {
        return type;
    }

    public int getBorrowing_count() {
        return borrowing_count;
    }

    public void setBorrowing_count(int borrowing_count) {
        this.borrowing_count = borrowing_count;
    }
}
