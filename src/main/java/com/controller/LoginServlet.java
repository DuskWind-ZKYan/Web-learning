package com.controller;

import com.entity.User;
import com.service.UserServiceElse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/filter/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var account = req.getParameter("account");
        var password = req.getParameter("password");
        User u = UserServiceElse.getUser(account,password);
        if (u != null) {
            req.getSession().setAttribute("user", u);
            resp.sendRedirect(req.getContextPath() + "/filter/welcome");
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/filter/login");
    }
}