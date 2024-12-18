package org.servlet.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.entity.User;
import org.service.LoginService;
import org.thymeleaf.context.Context;
import org.util.ThymeleafUtil;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    LoginService service;

    @Override
    public void init() throws ServletException {
        super.init();
        this.service = new LoginService(); // 初始化 LoginService
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Context context = new Context();
        ThymeleafUtil.process("login.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User userinfo = new User();
        userinfo.setUserName(username);
        userinfo.setPassWord(password);

        HttpSession session = req.getSession();

        if(service.auth(username,password,session)){
            resp.sendRedirect("index");
        }else{
            resp.sendRedirect("login");
        }

    }
}
