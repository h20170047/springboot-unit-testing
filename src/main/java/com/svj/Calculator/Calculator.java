package com.svj.Calculator;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Calculator {

    public int add(int num1, int num2) {
        return num1+num2;
    }

    public String calcAnnuity(String R, int t, String r, int n) {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        try {
            BigDecimal a = new BigDecimal(percentInstance.parse(r).toString()).divide(new BigDecimal(n));
            BigDecimal b= BigDecimal.ONE.add(a);
            BigDecimal c= b.pow(n*t);
            BigDecimal d= c.subtract(BigDecimal.ONE);
            BigDecimal e= d.divide(a);
            BigDecimal f= e.multiply(new BigDecimal(R));
            NumberFormat formatter= NumberFormat.getCurrencyInstance(Locale.US);
            return formatter.format(f);
        } catch (ParseException e) {
            System.out.println("Error while parsing percentage!");
        }
        return "";
    }
}
