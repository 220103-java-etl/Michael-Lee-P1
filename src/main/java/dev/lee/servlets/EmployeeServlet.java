package dev.lee.servlets;

import dev.lee.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();
        if (session == null) {
            out.write("<h3> Please login or create and account</h3>");
            out.write("<a href='login.html'>Click Here</a>");
        } else {
            User u = (User) session.getAttribute("user");
            out.write("<h1>Hello " + u.getFirstName() + ", what would you like to do?");


            String fName = request.getParameter("fName");
            String city = request.getParameter("fName");
            String email = request.getParameter("fName");
            String contact = request.getParameter("fName");
        }
    }
}
