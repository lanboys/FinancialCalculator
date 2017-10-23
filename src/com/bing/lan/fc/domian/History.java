package com.bing.lan.fc.domian;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class History {

    private Long id;
    private String user_id;
    private String platform_id;
    private String desc;
    private BigDecimal invest_amount;
    private BigDecimal discount_amount;
    private Double annualized_return;
    private Long invest_time;
    private Double increase_rates;
    private Long increase_time;
    private Long payment_time;
    private BigDecimal invest_income;
    private BigDecimal increase_income;
    private BigDecimal actual_invest_amount;
    private BigDecimal actual_invest_income;
    private Double actual_annualized_return;
}
