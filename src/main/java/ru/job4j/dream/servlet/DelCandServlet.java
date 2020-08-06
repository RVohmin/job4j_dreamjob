package ru.job4j.dream.servlet;

import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ru.job4j.dream.servlet
 *
 * @author romanvohmin
 * @since 06.08.2020
 */
public class DelCandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PsqlStore.instOf().deleteCandidate(req.getParameter("id"));
        req.setAttribute("candidates", PsqlStore.instOf().findAllCandidates());
        req.setAttribute("photos", PsqlStore.instOf().findAllPhoto());
        req.getRequestDispatcher("candidates.jsp").forward(req, resp);
    }
}
