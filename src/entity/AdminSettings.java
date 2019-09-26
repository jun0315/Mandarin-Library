package entity;

public class AdminSettings {

    private String bookFineValue;
    private String bookReturnPeriod;
    private String readerSecurityDeposit;

    public AdminSettings() {
        this.bookFineValue = "null";
        this.bookReturnPeriod = "null";
        this.readerSecurityDeposit = "null";
    }

    public String getBookFineValue() {
        return bookFineValue;
    }

    public void setBookFineValue(String bookFineValue) {
        this.bookFineValue = bookFineValue;
    }

    public String getBookReturnPeriod() {
        return bookReturnPeriod;
    }

    public void setBookReturnPeriod(String bookReturnPeriod) {
        this.bookReturnPeriod = bookReturnPeriod;
    }

    public String getReaderSecurityDeposit() {
        return readerSecurityDeposit;
    }

    public void setReaderSecurityDeposit(String readerSecurityDeposit) {
        this.readerSecurityDeposit = readerSecurityDeposit;
    }
}
