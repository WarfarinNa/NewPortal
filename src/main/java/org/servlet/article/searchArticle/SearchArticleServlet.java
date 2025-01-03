package org.servlet.article.searchArticle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.entity.Article;
import org.service.ArticleService;
import org.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/search-NowArticle")
public class SearchArticleServlet extends HttpServlet {
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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String articleTitle = req.getParameter("ArticleTitle");
        HttpSession session = req.getSession();
        if (articleTitle == null || articleTitle.trim().isEmpty()) {
            session.setAttribute("searchErrorMessage","不能输入空");
            resp.sendRedirect("show-AllArticle");
        }else{
            List<Article> articles = articleService.findArticlesByTitle(articleTitle);
            session.setAttribute("SearchArticleResult",articles);
            resp.sendRedirect("search-ArticleResult");
        }
    }
}