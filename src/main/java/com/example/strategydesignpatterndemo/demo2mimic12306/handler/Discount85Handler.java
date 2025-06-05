/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.strategydesignpatterndemo.demo2mimic12306.handler;


import com.example.strategydesignpatterndemo.demo2mimic12306.dto.req.Discount85req;
import com.example.strategydesignpatterndemo.demo2mimic12306.dto.req.DiscountReq;
import com.example.strategydesignpatterndemo.demo2mimic12306.dto.resp.Discount85resp;
import com.example.strategydesignpatterndemo.demo2mimic12306.dto.resp.DiscountResp;
import com.example.strategydesignpatterndemo.demo2mimic12306.handler.base.AbstractDiscountHandler;
import com.example.strategydesignpatterndemo.demo2mimic12306.strategy.AbstractExecuteStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public final class Discount85Handler extends AbstractDiscountHandler implements AbstractExecuteStrategy<DiscountReq, DiscountResp> {

    @Override
    public String mark() {
        return "85";
    }

    @Override
    public DiscountResp discount(DiscountReq req) {
        DiscountResp resp=new DiscountResp();
        resp.setPrice(req.getPrice()*0.85);
        return resp;
    }
    @Override
    public DiscountResp executeResp(DiscountReq req) {
        log.info("85折优惠");
        DiscountResp resp=discount(req);
        return resp;
    }


}
