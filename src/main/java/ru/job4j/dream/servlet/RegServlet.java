package ru.job4j.dream.servlet;

import ru.job4j.dream.model.User;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ru.job4j.dream.servlet
 *
 * @author romanvohmin
 * @since 05.08.2020
 */
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("doPost RegServlet: password - " + req.getParameter("password"));
        User user = new User(0,
                req.getParameter("login"),
                req.getParameter("email"),
                req.getParameter("password"));
        PsqlStore.instOf().save(user);
        HttpSession sc = req.getSession();
        sc.setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/index.do");
    }
}
