package dev.lee.servlets;

import dev.lee.models.*;
import dev.lee.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

public class ReimbursementServlet extends HttpServlet {
    ReimbursementService rs = new ReimbursementService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("reimbursement.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        if (session == null) {
            PrintWriter out = response.getWriter();
            out.write("<h3> You need to access this page using the welcome page.</h3>");
            out.write("<a href='welcome_page.html'>Click Here</a>");
        }else {
            //collecting values that will be passed in from reimbursement form
            String username = request.getParameter("username");
            double amount = Double.parseDouble(request.getParameter("amount"));
            String description = request.getParameter("description");
            String type = request.getParameter("RType");
            String grade = request.getParameter("GType");
            Date date = new Date(session.getCreationTime());
            String message = request.getParameter("message");
            //create user object
            User u = (User) session.getAttribute("logged_user");
            Reimbursement r = new Reimbursement();
            r.setAuthor(u);
            r.setDescription(description);
            r.setStatus(Status.PENDING);
            r.setAmount(amount);
            r.setGrade(GType.valueOf(grade));
            r.setType(RType.valueOf(type));
            r.setDate(date);
            r.setMessage(message);
            response.sendRedirect("employee_menu.html");

            rs.createReimbursement(r);

            //System.out.println(u.getUsername()); have it as a check when testing login
            // System.out.println(u.getPassword());
            //Main menu to submit new reimbursement, check status etc
        }
    }
}
