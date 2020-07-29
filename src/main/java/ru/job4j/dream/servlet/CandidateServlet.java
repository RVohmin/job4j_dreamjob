package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.Store;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ru.job4j.dream.servlet
 *
 * @author romanvohmin
 * @since 29.07.2020
 */
public class CandidateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        Store.instOf().save(new Post(0, req.getParameter("name")));
        resp.sendRedirect(req.getContextPath() + "/posts.jsp");
    }
}
