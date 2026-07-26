package com.orderflow.marketdatagateway.controller;

import com.orderflow.marketdatagateway.model.MarketData;
import com.orderflow.marketdatagateway.service.MarketDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/market-data")
public class MarketDataController {

    @Autowired
    private MarketDataService marketDataService;

    @GetMapping("/{symbol}")
    public Mono<MarketData> getMarketData(@PathVariable String symbol) {
        return marketDataService.getMarketData(symbol);
    }
}