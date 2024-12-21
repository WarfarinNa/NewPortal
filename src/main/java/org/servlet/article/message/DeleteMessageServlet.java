package org.servlet.article.message;

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

@WebServlet("/delete-Message")
public class DeleteMessageServlet extends HttpServlet {
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
        int MessageId = Integer.parseInt(req.getParameter("MessageId"));

        int userid =articleService.getUserIdByMessageId(MessageId);
        if(user.UserId==userid){
            articleService.deleteMessageByMessageId(MessageId);
        }
        resp.sendRedirect("get-NowArticle");
    }
}
