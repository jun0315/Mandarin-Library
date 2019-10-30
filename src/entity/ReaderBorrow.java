package entity;

import java.sql.Date;

/**
 * @author 刘威
 * @version 1.0
 * 封装数据库实体reader_borrow
 **/

public class ReaderBorrow {

    private String copy_id;
    private String user_account;
    private Date borrow_time;
    private int isReturned;
    private double fine;
    private String book_name;

    public ReaderBorrow() {

    }

    public ReaderBorrow(String copy_id, String user_account, int isReturned) {
        this.copy_id = copy_id;
        this.user_account = user_account;
        this.isReturned = isReturned;
        //设置借阅时间为当前系统时间
        borrow_time = new Date(System.currentTimeMillis());
    }

    public ReaderBorrow(String copy_id, String user_account, Date borrow_time, int isReturned, String book_name) {
        this.copy_id = copy_id;
        this.user_account = user_account;
        this.borrow_time = borrow_time;
        this.isReturned = isReturned;
        //默认罚金为0
        this.fine = 0.0;
        this.book_name = book_name;
    }

    public ReaderBorrow(String copy_id, String user_account, Date borrow_time, int isReturned, double fine, String book_name) {
        this.copy_id = copy_id;
        this.user_account = user_account;
        this.borrow_time = borrow_time;
        this.isReturned = isReturned;
        this.fine = fine;
        this.book_name = book_name;
    }

    public String getCopy_id() {
        return copy_id;
    }

    public void setCopy_id(String copy_id) {
        this.copy_id = copy_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public Date getBorrow_time() {
        return borrow_time;
    }

    public void setBorrow_time(Date borrow_time) {
        this.borrow_time = borrow_time;
    }

    public int getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(int isReturned) {
        this.isReturned = isReturned;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
}
