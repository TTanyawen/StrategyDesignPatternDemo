package com.example.strategydesignpatterndemo.controller;

import com.example.strategydesignpatterndemo.strategy.DiscountStrategy;
import com.example.strategydesignpatterndemo.strategy.factory.DiscountStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/strategy")
public class StrategyTestController {

    @Autowired
    DiscountStrategyFactory discountStrategyFactory;
    @RequestMapping("/test")
    public String test(@RequestParam Double price) {
        DiscountStrategy strategy95  = discountStrategyFactory.chooseStrategy("95");
        return strategy95.discount(price).toString();
    }
}
