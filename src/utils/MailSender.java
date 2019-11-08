package utils;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailSender {
    public MailSender(String to) {
        this.to = to;
    }

    // 收件人电子邮箱
    String to;

    // 发件人电子邮箱
    private String from = "zuyuan_nwpu@163.com";
    private final String SMTPSERVER = "smtp.163.com";
    private final String SMTPPORT = "25";
    private final String ACCOUT = "zuyuan_nwpu@163.com";
    private String PWD = "x12q34j56";

    //email content setting
    private String title;
    private String text;

    public void sendEmail() throws Exception {
        // 指定发送邮件的主机为 localhost

        if (title == null || text == null) {
            System.err.println("Mail don't have content, sent failed");
            return;
        }
        // 创建邮件配置
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", SMTPSERVER); // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.port", SMTPPORT);
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
//        props.setProperty("mail.smtp.ssl.enable", "true");// 开启ssl


        // 根据邮件配置创建会话，注意session别导错包
        Session session = Session.getDefaultInstance(props);
        // 开启debug模式，可以看到更多详细的输入日志
        session.setDebug(false);
        //创建邮件
        MimeMessage message = createEmail(session);
        //获取传输通道
        Transport transport = session.getTransport();
        transport.connect(SMTPSERVER, ACCOUT, PWD);
        //连接，并发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();

    }


    private MimeMessage createEmail(Session session) throws Exception {
        // 根据会话创建邮件
        MimeMessage msg = new MimeMessage(session);
        // address邮件地址, personal邮件昵称, charset编码方式
        InternetAddress fromAddress = new InternetAddress(from,
                "Mandarin Library", "utf-8");
        // 设置发送邮件方
        msg.setFrom(fromAddress);
        InternetAddress receiveAddress = new InternetAddress(
                to, "user", "utf-8");
        // 设置邮件接收方
        msg.setRecipient(MimeMessage.RecipientType.TO, receiveAddress);
        // 设置邮件标题
        msg.setSubject(title, "utf-8");
        msg.setText(text);
        // 设置显示的发件时间
        msg.setSentDate(new Date());
        // 保存设置
        msg.saveChanges();
        return msg;
    }

    public void setMailContent(String title, String text) {
        this.title = title;
        this.text = text;
    }

}