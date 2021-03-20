package com.haoxuer.adminstore.web.controller;

import com.haoxuer.adminstore.member.data.apps.DApp;
import com.haoxuer.discover.trade.api.apis.BasicTradeAccountApi;
import com.haoxuer.discover.trade.api.apis.TradeAccountApi;
import com.haoxuer.discover.trade.api.domain.request.TradeRequest;
import com.haoxuer.discover.trade.data.entity.TradeAccount;
import com.haoxuer.discover.trade.data.enums.ChangeType;
import com.haoxuer.discover.web.controller.front.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;


@Controller
public class SiteController extends BaseController {

    @Autowired
    private TradeAccountApi accountApi;

    @Autowired
    private BasicTradeAccountApi tradeAccountApi;

    /**
     * 跳转登录页
     *
     * @return
     */
    @GetMapping(value = "/index")
    public String index() {
        return getView("login");
    }

    @ResponseBody
    @GetMapping(value = "/demo")
    public String demo() {
        TradeAccount system = tradeAccountApi.special("system");
        TradeAccount to = accountApi.initNormal();
        int num = 1 + new Random().nextInt(100);
        for (int i = 0; i < num; i++) {
            TradeRequest request = new TradeRequest();
            request.setFrom(system.getId());
            request.setTo(to.getId());
            request.setNote("测试" + new Date());
            request.setChangeType(ChangeType.from(1, "11"));
            String xx=""+(0.1+new Random().nextDouble()*100000);
            xx= xx.substring(0,xx.indexOf(".")+2);
            request.setAmount(new BigDecimal(xx));
            accountApi.trade(request);
        }


        return "ok";
    }
}
