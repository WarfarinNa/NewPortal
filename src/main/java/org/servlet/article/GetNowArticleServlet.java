package org.servlet.article;

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

import java.io.IOException;
import java.util.List;

@WebServlet("/get-NowArticle")
public class GetNowArticleServlet extends HttpServlet {
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
        int articleId = Integer.parseInt(req.getParameter("ArticleId"));
        User userinfo = (User) session.getAttribute("UserInfo");
        Article article = articleService.getNowArticle(articleId);
        List<Message> messages = articleService.getAllMessageByArticleId(articleId);

        Context context = new Context();
        context.setVariable("UserInfo",userinfo);
        context.setVariable("NowArticle",article);
        context.setVariable("MessageBoard",messages);

        ThymeleafUtil.process("NowArticle.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}