package entity;

import java.sql.Date;

public class Notice {

    private String ID;
    private String topic;
    private String content;
    private Date posttime;

    public Notice() {
        this.ID = "null";
        this.topic = "null";
        this.content = "null";

    }

    public Notice(String ID, String topic, String content) {
        this.ID = ID;
        this.topic = topic;
        this.content = content;
        posttime = new Date(System.currentTimeMillis());
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }
}
