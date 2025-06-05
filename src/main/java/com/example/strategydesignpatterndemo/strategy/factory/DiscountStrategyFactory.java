package com.example.strategydesignpatterndemo.strategy.factory;


import com.example.strategydesignpatterndemo.strategy.DiscountStrategy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DiscountStrategyFactory implements InitializingBean {
    @Autowired
    private ApplicationContext applicationContext;

    private final Map<String, DiscountStrategy> discountStrategies = new HashMap<>();

    public DiscountStrategy chooseStrategy(String mark){
        return discountStrategies.get(mark);
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String,DiscountStrategy> discountStrategyMap= applicationContext.getBeansOfType(DiscountStrategy.class);
        discountStrategyMap.forEach((k,v)->{
            discountStrategies.put(v.mark(),v);
        });
    }
}
