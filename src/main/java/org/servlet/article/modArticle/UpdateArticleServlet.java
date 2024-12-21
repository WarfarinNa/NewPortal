package org.servlet.article.modArticle;

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
import org.util.TimeUtil;

import java.io.IOException;
import java.util.List;

@WebServlet("/Update-article")
public class UpdateArticleServlet extends HttpServlet {
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
        User userinfo = (User) session.getAttribute("UserInfo");

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String formattedDateTime = TimeUtil.getCurrentDateTimeFormatted("yyyy-MM-dd HH:mm:ss");

        Article article = (Article) session.getAttribute("WaitUpdateArticle");

        articleService.UpdateArticleByArticleId(title,content,formattedDateTime,article.ArticleId);
        resp.sendRedirect("showUpload-article");
    }
}
