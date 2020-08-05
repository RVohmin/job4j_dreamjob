package ru.job4j.dream.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ru.job4j.dream.servlet
 *
 * @author romanvohmin
 * @since 05.08.2020
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest sreq, ServletResponse sresp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sreq;
        HttpServletResponse resp = (HttpServletResponse) sresp;
        String uri = req.getRequestURI();
        System.out.println("AuthFilter uri: " + uri);
        if (uri.endsWith("auth.do") || uri.endsWith("reg.do")) {
            System.out.println("in filter");
            chain.doFilter(sreq, sresp);
            System.out.println("after chain");
            return;
        }
        if (req.getSession().getAttribute("user") == null) {
            System.out.println("Filter: user not registered");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        chain.doFilter(sreq, sresp);
    }

    @Override
    public void destroy() {
    }
}
