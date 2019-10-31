package utils;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FindReaderPassword {

    private static HttpServletRequest request;

    public static void findPassword(String mailAddress, String account, HttpServletRequest request) {
        FindReaderPassword.request = request;
        String mailContent;
        String findPwdUrl = urlCrypt(mailAddress, account);

        mailContent = "Test Find Password Url ";
        mailContent += findPwdUrl;

        MailSender mailSender = new MailSender(mailAddress);
        mailSender.setMailContent("Find your password", mailContent);
        try {
            mailSender.sendEmail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void AlertReturnBook(String mailAddress,HttpServletRequest request) {
        FindReaderPassword.request = request;
        String mailContent;

        mailContent = "Your book is about to expire, please return it in time";

        MailSender mailSender = new MailSender(mailAddress);
        mailSender.setMailContent("Timely return of books", mailContent);
        try {
            mailSender.sendEmail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String urlCrypt(String mailAddress, String account) {
        String UserName = account;
        String result;
        String todayDate;

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        todayDate = simpleDateFormat.format(date);

        String rootPath = "http://localhost:8080" + request.getContextPath();

        result = rootPath + "/findPassword.jsp?account=";
        result += UserName;
        result += "&verify=";
        result += md5((mailAddress + todayDate));

        return result;
    }


    public static String md5(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }
        StringBuilder hexString = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] hash = md.digest();
            for (byte b : hash) {
                if ((0xff & b) < 0x10) {
                    hexString.append("0").append(Integer.toHexString((0xFF & b)));
                } else {
                    hexString.append(Integer.toHexString(0xFF & b));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }

}
