import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: LoginServlet
 * @Description:登录Servlet
 * @Author: Ma Yuanyuan
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码及响应编码,响应数据类型
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        //解析请求数据,通过键获取值
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //进行用户名，密码的校验
        PrintWriter pw = resp.getWriter();
        if("asd".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password)){
            //pw.print("<p>登陆成功</p>");
            //默认创建一个session对象
            HttpSession session = req.getSession();
            session.setAttribute("user" ,"username = " + username);
            //重定向
           resp.sendRedirect(req.getContextPath()+ "/main.html");
           //resp.sendRedirect("https://www.baidu.com");
        }else{
       //     pw.print("<p>用户名或密码输入错误，登陆失败</p>");
            //转发
            req.getRequestDispatcher("/index.html").forward(req,resp);
        }
        pw.flush();
    }
}
