package org.servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.entity.User;
import org.service.ArticleService;
import org.service.UserService;
import org.thymeleaf.context.Context;
import org.util.ThymeleafUtil;
import org.util.TimeUtil;

import java.io.IOException;

@WebServlet("/update-userInfo")
public class UpdateUserInfoServlet extends HttpServlet {
    ArticleService articleService;
    UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.articleService = new ArticleService(); // 初始化 LoginService
        this.userService = new UserService(); // 初始化 LoginService
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userinfo = (User) session.getAttribute("UserInfo");

        Context context = new Context();
        context.setVariable("UserInfo",userinfo);
        ThymeleafUtil.process("userInfo.html",context,resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String signature = req.getParameter("signature");

        User userinfo = (User) session.getAttribute("UserInfo");

        if (userService.upDateUserInfoByUserName(userinfo.UserName,password,sex,signature)) {
            resp.sendRedirect("update-userInfo");
        }
    }
}