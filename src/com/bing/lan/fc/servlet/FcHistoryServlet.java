package com.bing.lan.fc.servlet;

import com.bing.lan.fc.dao.impl.HistoryDAOImpl;
import com.bing.lan.fc.domian.History;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fc/history")
public class FcHistoryServlet extends HttpServlet {

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
        System.out.println("FcHistoryServlet.doGet: ");

        String command = req.getParameter("command");
        if ("list".equals(command)) {
            list(req, resp);
        } else if ("delete".equals(command)) {
            delete(req, resp);
        } else if ("update".equals(command)) {
            update(req, resp);
        } else if ("save".equals(command)) {
            save(req, resp);
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao.save(new History());
        resp.sendRedirect("/fc/history?command=list");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        dao.delete(Long.valueOf(id));
        //req.getRequestDispatcher("/fc/history/list").forward(req, resp);
        resp.sendRedirect("/fc/history?command=list");
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("historys", dao.list());
        req.getRequestDispatcher("/WEB-INF/views/cal_history_list.jsp").forward(req, resp);
    }
}
