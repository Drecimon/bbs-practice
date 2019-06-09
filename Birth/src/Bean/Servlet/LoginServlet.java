package Bean.Servlet;

import Bean.DAO;
import Bean.DbUtil;
import Bean.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

/**
          * 接收前台传来的值 账号和密码
          */
        String userName = req.getParameter("userName");

        String password = req.getParameter("password");

        DbUtil db = new DbUtil();
        User user = new User(userName, password);
        DAO dao = new DAO();
        try {
//数据库链接
            Connection con = db.getCon();
            if (dao.login(con, user) != null) {
        resp.sendRedirect("text.jsp");
              //  PrintWriter out=resp.getWriter();
                //out.println("<html>");//输出的内容要放在body中
                //out.println("<body>");
                //out.println("要输入的内容.........");
                //out.println("</body>");
                //out.println("</html>");
            } else {
                resp.sendRedirect("register.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class Helloworld extends HttpServlet {

        public void service(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();

            out.println("<b>ÏìÓ¦ÏûÏ¢</b>");
        }
    }
}
