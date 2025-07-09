package com.controller;

import com.util.DatabaseUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ListTeachersServlet {
    @WebServlet("/listTeachers")
    public static class ListTeachersServlet1 extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            var teachers = DatabaseUtils.listTeachers();
            req.setAttribute("teachers", teachers);
            req.getRequestDispatcher("WEB-INF/jsp/listTeachers.jsp").forward(req,resp);
        }
    }
}
