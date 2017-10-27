package com.bing.lan.fc.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorUtil {

    public static BigDecimal getInvestIncome(BigDecimal money,
            Long time, BigDecimal annualized_return) {

        //java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
        //http://blog.csdn.net/lopper/article/details/5314686

        if (money == null || annualized_return == null || time == null) {
            return new BigDecimal("0");
        }
        return money.multiply(new BigDecimal(time))
                .multiply(annualized_return)
                .divide(new BigDecimal(365), 2, RoundingMode.HALF_DOWN);
    }

    public static BigDecimal getActualAnnualizedReturn(BigDecimal actualMoney,
            Long actualTime, BigDecimal actualIncome) {

        if (actualMoney == null || actualIncome == null || actualTime == null) {
            return new BigDecimal("0");
        }

        return actualIncome.multiply(new BigDecimal(365))
                .divide(actualMoney, 4, RoundingMode.HALF_DOWN)
                .divide(new BigDecimal(actualTime), 4, RoundingMode.HALF_DOWN);
    }
}
