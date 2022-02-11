package dev.lee.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.lee.models.*;
import dev.lee.services.ReimbursementService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ReimbursementServlet extends HttpServlet {
    ReimbursementService rs = new ReimbursementService();
    ObjectMapper om = new ObjectMapper();
/*
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StringBuilder uriString = new StringBuilder(request.getRequestURI());
        System.out.println("Request URI: " + uriString); // at this point the uri is -> /LibraryServlet/books

        uriString.replace(0, request.getContextPath().length() + 1, "");
        System.out.println("Without Context Path: " + uriString); // now we have -> books

        // Check to see if there is any more details after books - if there is we want to save that information. Create a variable to hold it and set it to 0 for later.
        int bookId = 0;

        if (uriString.indexOf("/") != -1) {
            bookId = Integer.parseInt(uriString.replace(0, uriString.indexOf("/") + 1, "" ).toString()); // if we had a request that was books/1, we want to access that 1. This line of code would save that Integer value into our bookId.
        }

        String path = uriString.toString();
        System.out.println("Path post check for slashes: " + path); // our path is now still 'books'

        if (bookId == 0) {

            switch (request.getMethod()) {

                case "GET": {
                    // we want to get all of the books from the server
                    response.setStatus(200);
                    response.getWriter().write(om.writeValueAsString(bookService.getAllBooks()));
                    break;
                }

                case "POST": {
                    // we would want to read the request body and create a new book resource
                    Book b = om.readValue(request.getReader(), Book.class);
                    // then we would call our services/repos to add this book to the database
                    b = bookService.addBook(b); // taking this opprtunity to set the id (which our DB will automatically create)
                    //response.setStatus(201);
                    response.getWriter().write(om.writeValueAsString(b));
                    break;
                }

            }
        } else {
            Book b = null;
            switch (request.getMethod()) {
                case "GET": {
                    System.out.println("bookId: " + bookId);
                    b = bookService.getBookById(bookId);
                    if (b != null) {
                        response.getWriter().write(om.writeValueAsString(b));
                    } else {
                        response.sendError(404, "Book not found.");
                    }
                    break;
                }

                case "PUT": {
                    b = om.readValue(request.getReader(), Book.class);
                    System.out.println(b);
                    bookService.updateBook(b);
                    break;
                }

                case "DELETE": {
                    b = om.readValue(request.getReader(), Book.class);
                    bookService.deleteBook(b.getId());
                    break;
                }

                default:
                    response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                    break;

            }
        }

    }
*/

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Reimbursement r = om.readValue(request.getReader(), Reimbursement.class);
        response.getWriter().write(om.writeValueAsString(ReimbursementService.process(r,r.getStatus(),r.getResolverId())));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

            List<Reimbursement> reimbursementList = ReimbursementService.getAll();
            System.out.println(reimbursementList);
            response.getWriter().write(om.writeValueAsString(reimbursementList));
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
            Date date = Date.valueOf(request.getParameter("date"));
            String type = request.getParameter("RType");
            String grade = request.getParameter("GType");
            String message = request.getParameter("message");
            //create user object
            User u = (User) session.getAttribute("logged_user");
            Reimbursement r = new Reimbursement();
            r.setAuthorId(u.getId());
            r.setDescription(description);
            r.setStatus(Status.PENDING);
            r.setAmount(amount);
            r.setGrade(GType.valueOf(grade));
            r.setType(RType.valueOf(type));
            r.setDate(date);
            r.setMessage(message);
            rs.createReimbursement(r);

            response.sendRedirect("employee_menu.html");



            //System.out.println(u.getUsername()); have it as a check when testing login
            // System.out.println(u.getPassword());
            //Main menu to submit new reimbursement, check status etc
        }
    }
}
