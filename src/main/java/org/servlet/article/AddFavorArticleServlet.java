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
import org.util.TimeUtil;

import java.io.IOException;

@WebServlet("/add-FavorArticle")
public class AddFavorArticleServlet extends HttpServlet {
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
        HttpSession session = req.getSession();

        int articleId = Integer.parseInt(req.getParameter("ArticleId"));
        User userinfo = (User) session.getAttribute("UserInfo");
        String Time = TimeUtil.getCurrentDateTimeFormatted("yyyy-MM-dd HH:mm:ss");
        if (articleService.AddFavorArticle(articleId,userinfo.UserId,Time)) {
            resp.sendRedirect("get-NowArticle");
        }

    }
}