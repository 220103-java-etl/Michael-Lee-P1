package dev.lee.servlets;

import dev.lee.models.Role;
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
        String pass = request.getParameter("pass");
            //create user object
           User u = us.login(username, pass);
           if (u != null ){
               //create session
            HttpSession session = request.getSession();

           //System.out.println(u);
            //System.out.println(u.getUsername()); have it as a check when testing login
            // System.out.println(u.getPassword());
            session.setAttribute("logged_user", u);
            if (u.getRole().equals(Role.FINANCE_MANAGER)){
                response.sendRedirect("manager_menu.html");
            }else{ response.sendRedirect("employee_menu.html");}
            //Main menu to submit new reimbursement, check status etc
        } else {
            response.sendRedirect("login_error.html");
        }
    }
}
