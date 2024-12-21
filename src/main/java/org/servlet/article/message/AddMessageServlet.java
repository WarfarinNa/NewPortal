package org.servlet.article.message;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.entity.Article;
import org.entity.Message;
import org.entity.User;
import org.service.ArticleService;
import org.service.UserService;
import org.thymeleaf.context.Context;
import org.util.ThymeleafUtil;
import org.util.TimeUtil;

import java.io.IOException;
import java.util.List;

@WebServlet("/add-Message")
public class AddMessageServlet extends HttpServlet {
    ArticleService articleService;
    UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        this.articleService = new ArticleService(); // 初始化 LoginService
        this.userService = new UserService(); // 初始化 LoginService
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Article article = (Article) session.getAttribute("NowArticle");
        String content = req.getParameter("MessageContent");
        User userinfo = (User) session.getAttribute("UserInfo");
        String Time = TimeUtil.getCurrentDateTimeFormatted("yyyy-MM-dd HH:mm:ss");

        if (articleService.addMessageByUserId(content,userinfo.UserId,article.ArticleId,Time)) {
            resp.sendRedirect("get-NowArticle");
        }
    }
}