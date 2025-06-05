package com.example.strategydesignpatterndemo.demo2mimic12306.controller;

import com.example.strategydesignpatterndemo.demo2mimic12306.dto.req.Discount95req;
import com.example.strategydesignpatterndemo.demo2mimic12306.dto.req.DiscountReq;
import com.example.strategydesignpatterndemo.demo2mimic12306.dto.resp.Discount95resp;
import com.example.strategydesignpatterndemo.demo2mimic12306.dto.resp.DiscountResp;
import com.example.strategydesignpatterndemo.demo2mimic12306.strategy.AbstractStrategyChoose;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DiscountController {
    private final AbstractStrategyChoose abstractStrategyChoose;
    @RequestMapping("/discount")
    public String discount(Double price,String mark) {
        DiscountReq req=new DiscountReq();
        req.setPrice(price);
        DiscountResp resp=abstractStrategyChoose.chooseAndExecuteResp(mark, req);
        return resp.getPrice().toString();
    }
}
