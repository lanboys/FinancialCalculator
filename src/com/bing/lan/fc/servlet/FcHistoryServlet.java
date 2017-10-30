package com.bing.lan.fc.servlet;

import com.bing.lan.fc.dao.IHistoryDAO;
import com.bing.lan.fc.dao.IPlatformDAO;
import com.bing.lan.fc.dao.impl.HistoryDAOImpl;
import com.bing.lan.fc.dao.impl.PlatformDAOImpl;
import com.bing.lan.fc.domian.History;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fc/history")
public class FcHistoryServlet extends HttpServlet {

    private IHistoryDAO mHistoryDAO;
    private IPlatformDAO mPlatformDAO;

    //http://www.cnblogs.com/weixiaole/p/5196067.html

    @Override
    public void init() throws ServletException {
        super.init();
        mHistoryDAO = new HistoryDAOImpl();
        mPlatformDAO = new PlatformDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("FcHistoryServlet.doGet: ");

        String cmd = req.getParameter("cmd");
        if ("list".equals(cmd)) {
            list(req, resp);
        } else if ("delete".equals(cmd)) {
            delete(req, resp);
        } else if ("update".equals(cmd)) {
            update(req, resp);
        } else if ("save".equals(cmd)) {
            save(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        System.out.println("FcHistoryServlet.doPost: ");
        doGet(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String platform_id = req.getParameter("platform_id ");
        String invest_amount = req.getParameter("invest_amount");
        String discount_amount = req.getParameter("discount_amount");
        String annualized_return = req.getParameter("annualized_return");
        String invest_time = req.getParameter("invest_time");

        String increase_rates = req.getParameter("increase_rates");
        String increase_time = req.getParameter("increase_time");
        String payment_time = req.getParameter("payment_time");

        String desc = req.getParameter("desc");
        //String increase_income = req.getParameter("increase_income");

        History history = new History();
        history.setPlatform_id(platform_id);
        history.setInvest_amount(new BigDecimal(invest_amount));
        history.setDiscount_amount(new BigDecimal(discount_amount));
        history.setAnnualized_return(new BigDecimal(annualized_return));
        history.setInvest_time(new Long(invest_time));
        history.setIncrease_rates(new BigDecimal(increase_rates));
        history.setIncrease_time(new Long(increase_time));
        history.setPayment_time(new Long(payment_time));
        history.setDesc(desc);
        //history.setIncrease_income(new BigDecimal(increase_income));

        history.calculateInvestIncome();

        mHistoryDAO.save(history);
        resp.sendRedirect("/fc/history?cmd=list");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        mHistoryDAO.delete(Long.valueOf(id));
        //req.getRequestDispatcher("/fc/history/list").forward(req, resp);
        resp.sendRedirect("/fc/history?cmd=list");
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("platforms", mPlatformDAO.list());
        req.setAttribute("histories", mHistoryDAO.list());
        req.getRequestDispatcher("/WEB-INF/views/fc_history_list.jsp").forward(req, resp);
    }
}
