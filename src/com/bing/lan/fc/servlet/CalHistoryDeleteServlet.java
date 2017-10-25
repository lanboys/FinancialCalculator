package com.bing.lan.fc.servlet;

import com.bing.lan.fc.dao.impl.HistoryDAOImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fc/history/delete")
public class CalHistoryDeleteServlet extends HttpServlet {

    private HistoryDAOImpl dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new HistoryDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("CalHistoryDeleteServlet.doGet: ");
        String id = req.getParameter("id");
        dao.delete(Long.valueOf(id));
        //req.getRequestDispatcher("/fc/history/list").forward(req, resp);
        resp.sendRedirect("/fc/history/list");
    }
}
