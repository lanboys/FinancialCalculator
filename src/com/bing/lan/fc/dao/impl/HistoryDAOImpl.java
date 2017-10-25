package com.bing.lan.fc.dao.impl;

import com.bing.lan.fc.dao.IHistoryDAO;
import com.bing.lan.fc.domian.History;
import com.bing.lan.fc.jdbc.IResultSetHandler;
import com.bing.lan.fc.jdbc.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryDAOImpl implements IHistoryDAO {

    @Override
    public void save(History obj) {

    }

    @Override
    public void update(History obj) {

    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM fc_history WHERE id = ?";
        JdbcTemplate.update(sql, id);
    }

    @Override
    public History get(Long id) {

        return null;
    }

    @Override
    public List<History> list() {
        String sql = "SELECT fc_history.*,fc_platform.platformName FROM fc_history LEFT JOIN fc_platform ON fc_history.platform_id = fc_platform.id";
        return JdbcTemplate.list(sql, new HistoryResultHandler());
    }

    class HistoryResultHandler implements IResultSetHandler<List<History>> {

        @Override
        public List<History> handleResultSet(ResultSet resultSet) throws SQLException {
            List<History> list = new ArrayList<>();
            while (resultSet.next()) {
                History history = new History();
                list.add(history);
                history.id = resultSet.getString("id");
                history.user_id = resultSet.getString("user_id");
                history.platform_id = resultSet.getString("platform_id");
                history.platformName = resultSet.getString("platformName");
                history.desc = resultSet.getString("desc");
                history.invest_amount = resultSet.getBigDecimal("invest_amount");
                history.discount_amount = resultSet.getBigDecimal("discount_amount");
                history.annualized_return = resultSet.getBigDecimal("annualized_return");
                history.invest_time = resultSet.getLong("invest_time");
                history.increase_rates = resultSet.getBigDecimal("increase_rates");
                history.increase_time = resultSet.getLong("increase_time");
                history.payment_time = resultSet.getLong("payment_time");
                history.invest_income = resultSet.getBigDecimal("invest_income");
                history.increase_income = resultSet.getBigDecimal("increase_income");
                history.actual_invest_amount = resultSet.getBigDecimal("actual_invest_amount");
                history.actual_annualized_return = resultSet.getBigDecimal("actual_annualized_return");
                history.actual_invest_income = resultSet.getBigDecimal("actual_invest_income");

                history.calculateInvestIncome();
            }

            return list;
        }
    }
}
