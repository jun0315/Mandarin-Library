package entity;

import java.util.Date;

public class BookDelete {
    private String copy_id;
    private Date delete_time;
    private String staff_id;

    public BookDelete(){
        copy_id=null;
        delete_time=null;
        staff_id=null;

    }

    public String getCopy_id() {
        return copy_id;
    }

    public void setCopy_id(String copy_id) {
        this.copy_id = copy_id;
    }

    public Date getDelete_time() {
        return delete_time;
    }

    public void setDelete_time(Date delete_time) {
        this.delete_time = delete_time;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }
}
