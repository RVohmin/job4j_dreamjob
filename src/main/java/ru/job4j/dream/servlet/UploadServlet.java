package ru.job4j.dream.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.dream.model.Photo;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ru.job4j.dream.servlet
 *
 * @author romanvohmin
 * @since 01.08.2020
 */
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UploadServlet, doGet");
        String redirect = "";
        if (req.getAttribute("photoId") == null) {
            List<String> images = new ArrayList<>();
            for (File name : new File("images").listFiles()) {
                images.add(name.getName());
            }
            req.setAttribute("images", images);
            redirect = "/upload.jsp";
        } else {
            redirect = "/candidate/edit.jsp";
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(redirect);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UploadServlet, doPost");
        req.setCharacterEncoding("UTF-8");
        Photo photo = null;
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> items = upload.parseRequest(req);
            File folder = new File("images");
            if (!folder.exists()) {
                folder.mkdir();
            }
            for (FileItem item : items) {
                System.out.println(item);
                photo = PsqlStore.instOf().save(new Photo(0, item.getName()));
                if (!item.isFormField()) {
                    File file = new File(folder + File.separator + item.getName());
                    try (FileOutputStream out = new FileOutputStream(file)) {
                        out.write(item.getInputStream().readAllBytes());
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        if (photo != null) {
            req.setAttribute("photoId", String.valueOf(photo.getId()));
        }
        doGet(req, resp);
    }
}