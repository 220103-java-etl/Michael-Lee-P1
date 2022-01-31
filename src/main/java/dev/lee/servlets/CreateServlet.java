package dev.lee.servlets;

import dev.lee.models.Role;
import dev.lee.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("create.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        if (session == null) {
            PrintWriter out = response.getWriter();
            out.write("<h3> You need to access this page using the welcome page.</h3>");
            out.write("<a href='welcome_page.html'>Click Here</a>");
        }else {
            //collecting values that will be passed in from login form
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String username = request.getParameter("username");
            String pass = request.getParameter("pass");
            String role = request.getParameter("role");
            String location = request.getParameter("location");

            //create user object
            User u = new User();
            u.setUsername(username);
            u.setPassword(pass);
            u.setLocation(location);
            u.setFirstName(firstName);
            u.setLastName(lastName);
            if (role.equals("Finance Manager")) {
                u.setRole(Role.FINANCE_MANAGER);
                session.setAttribute("logged_manager", u);
                response.sendRedirect("manager_menu.html");
            } else {
                u.setRole(Role.EMPLOYEE);
                session.setAttribute("logged_employee", u);
                response.sendRedirect("employee_menu.html");
            }

            //System.out.println(u.getUsername()); have it as a check when testing login
            // System.out.println(u.getPassword());
            //Main menu to submit new reimbursement, check status etc
        }
    }
}

