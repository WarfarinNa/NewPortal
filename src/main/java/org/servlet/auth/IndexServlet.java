package org.servlet.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.entity.User;
import org.thymeleaf.context.Context;
import org.util.ThymeleafUtil;

import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    //    BookService service;
    @Override
    public void init() throws ServletException {
//        service = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        ThymeleafUtil.process("index.html", context, resp.getWriter());
    }
}