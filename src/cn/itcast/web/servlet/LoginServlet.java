package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.由于获得的参数有中文需要设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取验证码,然后在参数
        String verifycode = request.getParameter("verifycode");
        //System.out.println("1111111111111");
        //2.1获取服务器验证码
        HttpSession session = request.getSession();
        String checkCode_session =(String) session.getAttribute ("checkCode_session");
        session.removeAttribute(checkCode_session);//确保验证码一次性
        //3.判断验证码是否正确
        //3.1验证码不正确
        if(!checkCode_session.equalsIgnoreCase(verifycode)){
            //设置显示不正确信息,跳转页面
            //System.out.println("111111111111111111");
            request.setAttribute("login_error","验证码不正确");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用UserService查询
        UserService userService = new UserServiceImpl();
        User login = userService.login(user);
        if (login != null){
            //查询到了,保存数据
            session.setAttribute("user",login);
            //跳转到list.jsp页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            //输出用户名或密码有误
            request.setAttribute("login_error","用户名或密码不正确");
            //由于request没有共享数据,所以使用重定向
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
