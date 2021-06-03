package com.test.test2;

import com.test.dao.CategoryDAO;
import com.test.entities.Categroy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "home-sv", value = "/home-sv")
public class HelloServlet extends HttpServlet {

    CategoryDAO categoryDAO ;
    public void init() {
        categoryDAO = new CategoryDAO();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");
            // if the command is missing, then default to listing students
            if (theCommand == null) {
                theCommand = "LIST";
            }
            // route to the appropriate method
            switch (theCommand) {
                case "LIST":
                    list(request, response);
                    break;
                case "ADD":
                    add(request, response);
                    break;
                case "LOAD":
                    load(request, response);
                    break;
                case "UPDATE":
                    update(request, response);
                    break;
                case "DELETE":
                    delete(request, response);
                    break;
                default:
                    list(request, response);
            }

        } catch (Exception exc) {
            throw new ServletException(exc);
        }


    }
    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // read student id from form data
        Categroy categroy = new Categroy( Integer.parseInt(request.getParameter("id")),null);


        // delete student from database
        categoryDAO.delete(categroy);

        // send them back to "list students" page
        list(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read student info from form data
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");


        // create a new student object
        Categroy c = new Categroy(id, name);

        // perform update on database
        categoryDAO.update(c);

        // send them back to the "list students" page
        list(request, response);

    }

    private void load(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read student id from form data
        int id = Integer.parseInt(request.getParameter("id"));

        // get student from database (db util)
        Categroy theStudent = categoryDAO.getAll().stream().filter(x-> id ==x.getId()).findAny().orElse(null);

        // place student in the request attribute
        request.setAttribute("cate", theStudent);

        // send to jsp page: update-student-form.jsp

                request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read student info from form data
        String name = request.getParameter("name");


        // create a new student object
        Categroy categroy = new Categroy(0,name);


        // add the student to the database
        categoryDAO.insert(categroy);

        // send back to main page (the student list)
        list(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // get students from db util
        ArrayList<Categroy> list = categoryDAO.getAll();
        request.setAttribute("list", list);

        // send to JSP page (view)
        request.getRequestDispatcher("home1s.jsp").forward(request, response);
    }


    public void destroy() {
    }
}