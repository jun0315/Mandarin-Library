package servlet;

import dao.ReaderDao;
import entity.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ReaderAccountSettingServlet")
public class ReaderAccountSettingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从数据库获取原reader信息
        HttpSession session = request.getSession();
        String preAccount = (String) session.getAttribute("account");
        ReaderDao readerDao = ReaderDao.getInstance();
        Reader reader = readerDao.info(preAccount);
        String account = reader.getAccount();
        String password = reader.getPassword();
        String name = reader.getName();
        String email = reader.getEmail();
        int deposit = reader.getDeposit();
        //获取reader输入的修改内容
        String newItemValue = request.getParameter("newItemValue");
        String item = request.getParameter("item");
        //更新数据库和session中的reader信息
        switch (item) {
            case "account":
                readerDao.editReader(newItemValue, password, name, email, deposit, preAccount);
                session.setAttribute("account", newItemValue);
                break;
            case "password":
                readerDao.editReader(account, newItemValue, name, email, deposit, preAccount);
                session.setAttribute("password", newItemValue);
                break;
            case "name":
                readerDao.editReader(account, password, newItemValue, email, deposit, preAccount);
                session.setAttribute("name", newItemValue);
                break;
            case "email":
                readerDao.editReader(account, password, name, newItemValue, deposit, preAccount);
                session.setAttribute("email", newItemValue);
                break;
        }
        response.sendRedirect("reader_account_setting.jsp?info=reset_success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
