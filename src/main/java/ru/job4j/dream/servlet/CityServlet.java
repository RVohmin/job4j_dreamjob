package ru.job4j.dream.servlet;

import com.google.gson.Gson;
import ru.job4j.dream.model.City;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * ru.job4j.dream.servlet
 *
 * @author romanvohmin
 * @since 08.08.2020
 */
public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("in CityServlet");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        List<City> cities = new ArrayList<>(PsqlStore.instOf().findAllCity());
//        cities.forEach(x -> System.out.println(x.getCity()));
        String gson = new Gson().toJson(cities);
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.println(gson);
        printWriter.flush();
    }
}
