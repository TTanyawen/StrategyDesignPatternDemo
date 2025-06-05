package com.example.strategydesignpatterndemo.strategy;

public interface DiscountStrategy {
    Double discount(Double price);
    String mark();
}
