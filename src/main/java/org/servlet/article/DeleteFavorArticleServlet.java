package org.servlet.article;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.entity.User;
import org.service.ArticleService;
import org.service.UserService;

import java.io.IOException;

@WebServlet("/delete-FavorArticle")
public class DeleteFavorArticleServlet extends HttpServlet {
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
        User user = (User) session.getAttribute("UserInfo");
        int ArticleId = Integer.parseInt(req.getParameter("ArticleId"));

        articleService.deleteFavorArticleByFavorId(ArticleId,user.UserId);

        resp.sendRedirect("update-userInfo");
    }
}