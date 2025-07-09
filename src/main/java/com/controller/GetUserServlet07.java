package com.controller;

import com.entity.User;
import com.util.DataSourceUtils07;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet("/getuser07")
public class GetUserServlet07 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        String sql = "select * from user where id=?";
        try (Connection conn = DataSourceUtils07.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, req.getParameter("uid"));
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    user = new User();
                    user.setId(rs.getString("id"));
                    user.setName(rs.getString("name"));
                    user.setInsertTime(rs.getObject("insert_time", LocalDateTime.class));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/jsp/query07.jsp")
                .forward(req, resp);
    }
}
