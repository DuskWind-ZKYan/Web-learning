package com.controller;

import com.util.DatabaseUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/updateTeacher")
public class UpdateTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var tid = req.getParameter("tid");
        var teacher = DatabaseUtils.getTeacher(Integer.parseInt(tid));
        req.setAttribute("teacher", teacher);
        req.setAttribute("titles",DatabaseUtils.listTitles());
        req.setAttribute("courses", DatabaseUtils.listCourses());
        req.getRequestDispatcher("/WEB-INF/jsp/updateTeacher.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
