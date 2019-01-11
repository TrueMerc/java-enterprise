package ru.ryabtsev.enterprise.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Main page servlet class.
 */
@WebServlet(urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    private static final String PAGE_HEADER = "Main page";

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>" + PAGE_HEADER + "</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>" + PAGE_HEADER + "</h1>");
//        out.println("</body>");
//        out.println("</html>");
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet response encoding: " + resp.getCharacterEncoding());
        final PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + PAGE_HEADER + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + PAGE_HEADER + "</h1>");
        out.println("</body>");
        out.println("</html>");
        System.out.println("Servlet response encoding: " + resp.getCharacterEncoding());
    }
}
