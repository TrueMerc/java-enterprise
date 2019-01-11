package ru.ryabtsev.enterprise.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Error servlet class.
 */
@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

    private static final int HTTP_NOTFOUND_STATUS = 404;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ERROR SERVLET");
        resp.sendError(HTTP_NOTFOUND_STATUS);
    }
}