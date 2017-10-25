package com.bing.lan.fc.servlet;

import com.bing.lan.fc.dao.impl.HistoryDAOImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fc/history/list")
public class CalHistoryListServlet extends HttpServlet {

    private HistoryDAOImpl dao;

    //http://www.cnblogs.com/weixiaole/p/5196067.html

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new HistoryDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("CalHistoryListServlet.doGet: ");
        req.setAttribute("historys", dao.list());
        req.getRequestDispatcher("/WEB-INF/views/cal_history_list.jsp").forward(req, resp);
    }
}
