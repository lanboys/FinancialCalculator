package com.bing.lan.fc.domian;

import com.bing.lan.fc.util.CalculatorUtil;

import java.math.BigDecimal;

public class History {

    public String id;//
    public String user_id;//
    public String platform_id;//
    public String platformName;//平台
    public String desc;//备注

    public BigDecimal invest_amount = new BigDecimal("0");//投资金额
    public BigDecimal discount_amount = new BigDecimal("0");//优惠券

    public BigDecimal annualized_return = new BigDecimal("0");//年化收益率(x%)
    public Long invest_time;//计息时间

    public BigDecimal increase_rates = new BigDecimal("0");//加息率(x%)
    public Long increase_time;//加息天数

    public Long payment_time;//起息/到账总时间//

    public BigDecimal invest_income = new BigDecimal("0");//收益
    public BigDecimal increase_income = new BigDecimal("0");//加息收益

    public BigDecimal actual_invest_amount = new BigDecimal("0");//实际投资金额
    public BigDecimal actual_invest_income = new BigDecimal("0");//实际收益
    public BigDecimal actual_annualized_return = new BigDecimal("0");//实际年化收益率

    public void calculateInvestIncome() {
        try {
            invest_income = CalculatorUtil.getInvestIncome(invest_amount, invest_time, annualized_return);
            increase_income = CalculatorUtil.getInvestIncome(invest_amount, increase_time, increase_rates);

            actual_invest_amount = invest_amount.subtract(discount_amount);
            actual_invest_income = discount_amount.add(invest_income).add(increase_income);
            actual_annualized_return = CalculatorUtil.getActualAnnualizedReturn(actual_invest_amount,
                    invest_time + payment_time, actual_invest_income);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "History{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", platform_id='" + platform_id + '\'' +
                ", platformName='" + platformName + '\'' +
                ", desc='" + desc + '\'' +
                ", invest_amount=" + invest_amount +
                ", discount_amount=" + discount_amount +
                ", annualized_return=" + annualized_return +
                ", invest_time=" + invest_time +
                ", increase_rates=" + increase_rates +
                ", increase_time=" + increase_time +
                ", payment_time=" + payment_time +
                ", invest_income=" + invest_income +
                ", increase_income=" + increase_income +
                ", actual_invest_amount=" + actual_invest_amount +
                ", actual_invest_income=" + actual_invest_income +
                ", actual_annualized_return=" + actual_annualized_return +
                '}';
    }

    public BigDecimal getAnnualized_return() {
        return annualized_return;
    }

    public void setAnnualized_return(BigDecimal annualized_return) {
        this.annualized_return = annualized_return;
    }

    public BigDecimal getIncrease_rates() {
        return increase_rates;
    }

    public void setIncrease_rates(BigDecimal increase_rates) {
        this.increase_rates = increase_rates;
    }

    public BigDecimal getActual_annualized_return() {
        return actual_annualized_return;
    }

    public void setActual_annualized_return(BigDecimal actual_annualized_return) {
        this.actual_annualized_return = actual_annualized_return;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPlatform_id() {
        return platform_id;
    }

    public void setPlatform_id(String platform_id) {
        this.platform_id = platform_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getInvest_amount() {
        return invest_amount;
    }

    public void setInvest_amount(BigDecimal invest_amount) {
        this.invest_amount = invest_amount;
    }

    public BigDecimal getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(BigDecimal discount_amount) {
        this.discount_amount = discount_amount;
    }

    public Long getInvest_time() {
        return invest_time;
    }

    public void setInvest_time(Long invest_time) {
        this.invest_time = invest_time;
    }

    public Long getIncrease_time() {
        return increase_time;
    }

    public void setIncrease_time(Long increase_time) {
        this.increase_time = increase_time;
    }

    public Long getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(Long payment_time) {
        this.payment_time = payment_time;
    }

    public BigDecimal getInvest_income() {
        return invest_income;
    }

    public void setInvest_income(BigDecimal invest_income) {
        this.invest_income = invest_income;
    }

    public BigDecimal getIncrease_income() {
        return increase_income;
    }

    public void setIncrease_income(BigDecimal increase_income) {
        this.increase_income = increase_income;
    }

    public BigDecimal getActual_invest_amount() {
        return actual_invest_amount;
    }

    public void setActual_invest_amount(BigDecimal actual_invest_amount) {
        this.actual_invest_amount = actual_invest_amount;
    }

    public BigDecimal getActual_invest_income() {
        return actual_invest_income;
    }

    public void setActual_invest_income(BigDecimal actual_invest_income) {
        this.actual_invest_income = actual_invest_income;
    }
}
