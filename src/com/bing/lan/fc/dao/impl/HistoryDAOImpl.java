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
        String sql = "INSERT INTO fc_history() VALUES ()";
        String sql1 = "INSERT INTO `jdbc`.`fc_history` (\n" +
                "\t`user_id`,\n" +
                "\t`platform_id`,\n" +
                "\t`desc`,\n" +
                "\t`invest_amount`,\n" +
                "\t`discount_amount`,\n" +
                "\t`annualized_return`,\n" +
                "\t`invest_time`,\n" +
                "\t`increase_rates`,\n" +
                "\t`increase_time`,\n" +
                "\t`payment_time`,\n" +
                "\t`invest_income`,\n" +
                "\t`increase_income`,\n" +
                "\t`actual_invest_amount`,\n" +
                "\t`actual_invest_income`,\n" +
                "\t`actual_annualized_return`\n" +
                ")\n" +
                "VALUES\n" +
                "\t(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); " +
                "\n";

        Object[] params = {
                obj.getUser_id(),
                obj.getPlatform_id(),
                obj.getDesc(),
                obj.getInvest_amount(),
                obj.getDiscount_amount(),
                obj.getAnnualized_return(),
                obj.getInvest_time(),
                obj.getIncrease_rates(),
                obj.getIncrease_time(),
                obj.getPayment_time(),
                obj.getInvest_income(),
                obj.getIncrease_income(),
                obj.getActual_invest_amount(),
                obj.getActual_invest_income(),
                obj.getActual_annualized_return()
        };
        JdbcTemplate.update(sql1, params);
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
        //String sql = "SELECT fc_history.*,fc_platform.platformName FROM fc_history LEFT JOIN fc_platform ON fc_history.platform_id = fc_platform.id";
        String sql = "SELECT\n" +
                "\tfc_history.*, fc_platform.platformName\n" +
                "FROM\n" +
                "\tfc_history\n" +
                "LEFT JOIN fc_platform ON fc_history.platform_id = fc_platform.id";
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

                //history.calculateInvestIncome();
            }

            return list;
        }
    }
}
