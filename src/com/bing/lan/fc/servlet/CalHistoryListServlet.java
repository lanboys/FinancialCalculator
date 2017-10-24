package com.bing.lan.fc.servlet;

import com.bing.lan.fc.dao.impl.HistoryDAOImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/history/cal")
public class CalHistoryListServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

        //http://www.cnblogs.com/weixiaole/p/5196067.html
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("------------------");

        HistoryDAOImpl historyDAO = new HistoryDAOImpl();
        historyDAO.list();

    }
}
