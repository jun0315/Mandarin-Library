package dao;

import entity.Book;
import entity.BookCategory;
import entity.Notice;
import utils.DBHelper;
import java.sql.Date;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeDao {
    //返回一个公告的列表，包含所有公告的信息
    public List<Notice> getNotice() {
        List<Notice> notices = new ArrayList<Notice>();
        String sql = "Select * from Notice";
        try {
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Notice notice = new Notice();
                String ID = resultSet.getString("notice_ID");
                String Topic = resultSet.getString("notice_topic");
                String Content = resultSet.getString("notice_content");
                Date Posttime = resultSet.getDate("notice_date");
                notice.setID(ID);
                notice.setTopic(Topic);
                notice.setContent(Content);
                notice.setPosttime(Posttime);

                notices.add(notice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notices;
    }

    //通过notice_ID返回notice实体
    public Notice info(String id) {
        Notice notice = new Notice();
        try {
            String sql = "Select * from notice where notice_ID= \'" + id + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            NoticeDao noticeDao = new NoticeDao();
            while (resultSet.next()) {
                Notice notices = new Notice();
                String ID = resultSet.getString("notice_ID");
                String Topic = resultSet.getString("notice_topic");
                String Content = resultSet.getString("notice_content");
                Date Posttime = resultSet.getDate("notice_date");
                notice.setID(ID);
                notice.setTopic(Topic);
                notice.setContent(Content);
                notice.setPosttime(Posttime);

                noticeDao.addNotice(notices.getID(), notices.getTopic(), notices.getContent());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notice;
    }

    //数据库中是否存在这个公告
    public boolean isExitInDB(String id) {
        boolean Exit = false;
        try {
            String sql = "Select * from notice where notice_ID= \'" + id + "\'";
            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String idINDB = resultSet.getString("id");
                if (idINDB.equals(id)) {
                    Exit = true;
                    break;
                }
            }
            DBHelper.closeConnection(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Exit;
    }

    //添加公告到数据库中
    public void addNotice(String id, String topic, String content) {
        try {
            String sql = "insert into notice values(?,?,?,?);";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, topic);
            ps.setString(3, content);
            ps.setDate(4, new Date(System.currentTimeMillis()));
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editNotice(String id, String topic, String content, String preid) {
        try {
            String sql = "update notice set notice_topic=?,motice_content=?,notice_id=?,notice_date=? where notice_id=?";
            Connection connection = DBHelper.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, topic);
            ps.setString(2, content);
            ps.setString(3, id);
            ps.setDate(4, new Date(System.currentTimeMillis()));
            ps.setString(5, preid);
            ps.executeUpdate();
            DBHelper.closeConnection(connection, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteNotice(String id) {

        String sql = "delete from notice where notice_id = \'" + id + "\'";

        try {

            Connection connection = DBHelper.getInstance().getConnection();
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }

}
