package dev.lee.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
        String fName = request.getParameter("fName");
        String city = request.getParameter("fName");
        String email = request.getParameter("fName");
        String contact = request.getParameter("fName");
    }
}
