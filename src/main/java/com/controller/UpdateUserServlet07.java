package com.controller;

import com.util.DataSourceUtils07;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/update07")
public class UpdateUserServlet07 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("uid");
        String newName = req.getParameter("name");
        String sql = "update user set name=? where id=?";
        try(Connection conn = DataSourceUtils07.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, newName);
            st.setString(2, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath()+ "/index07");
    }
}
