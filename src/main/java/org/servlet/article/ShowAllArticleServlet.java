package org.servlet.article;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.entity.Article;
import org.entity.User;
import org.service.ArticleService;
import org.service.UserService;
import org.thymeleaf.context.Context;
import org.util.ThymeleafUtil;

import java.io.IOException;
import java.util.List;

@WebServlet("/show-AllArticle")
public class ShowAllArticleServlet extends HttpServlet {
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
        List<Article> articles = articleService.getAllArticle();
        Context context = new Context();
        context.setVariable("UserInfo",userinfo);
        context.setVariable("AllArticle",articles);
        ThymeleafUtil.process("showArticle.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
