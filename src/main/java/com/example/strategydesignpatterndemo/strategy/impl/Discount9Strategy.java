package com.example.strategydesignpatterndemo.strategy.impl;

import com.example.strategydesignpatterndemo.strategy.DiscountStrategy;
import org.springframework.stereotype.Component;

@Component
public class Discount9Strategy implements DiscountStrategy {

    @Override
    public Double discount(Double price) {
        return price*0.9;
    }

    @Override
    public String mark() {
        return "9";
    }
}
