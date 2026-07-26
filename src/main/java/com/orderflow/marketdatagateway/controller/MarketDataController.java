package com.orderflow.marketdatagateway.controller;

import com.orderflow.marketdatagateway.model.MarketData;
import com.orderflow.marketdatagateway.service.MarketDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MarketDataController {

    private final MarketDataService marketDataService;

    public MarketDataController(MarketDataService marketDataService) {
        this.marketDataService = marketDataService;
    }

    @GetMapping("/")
    public Mono<MarketData> home() {
        return marketDataService.getMarketData();
    }
}