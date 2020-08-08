package ru.job4j.dream.servlet;


import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ru.job4j.dream.servlet
 *
 * @author romanvohmin
 * @since 07.08.2020
 */

public class GreetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
        resp.setHeader("Access-Control-Allow-Methods", "GET");
        resp.setHeader("Access-Control-Max-Age", "1728000");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String name = req.getParameter("name");
        JsonObject gson = new JsonObject();
        gson.addProperty("text", "Nice to meet you, " + name + "!");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.println(gson);
        writer.flush();
    }
}
