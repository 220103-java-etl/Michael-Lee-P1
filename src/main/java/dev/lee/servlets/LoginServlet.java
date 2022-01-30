package dev.lee.servlets;

import dev.lee.models.User;
import dev.lee.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserService us = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        //collecting values that will be passed in from login form
        String username = request.getParameter("username");
        String pass = request.getParameter("password");

        if (us.login(username, pass)) {
            //create session
            HttpSession session = request.getSession();
            //create user object
            User u = new User();
            u.setUsername(username);
            u.setPassword(pass);
            //System.out.println(u.getUsername()); have it as a check when testing login
            // System.out.println(u.getPassword());
            session.setAttribute("logged_user", u);
            response.sendRedirect("menu.html"); //Main menu to submit new reimbursement, check status etc
        } else {
            response.sendRedirect("login_error.html");
        }
    }
}
