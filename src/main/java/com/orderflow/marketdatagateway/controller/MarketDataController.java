package com.orderflow.marketdatagateway.controller;

import com.orderflow.marketdatagateway.model.MarketData;
import com.orderflow.marketdatagateway.service.MarketDataService;
import com.orderflow.marketdatagateway.model.OrderBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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

    @GetMapping("/orderbook/{symbol}")
public Mono<OrderBook> getOrderBook(@PathVariable String symbol) {
    return marketDataService.getOrderBook(symbol);
}

    @GetMapping(value = "/stream/{symbol}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MarketData> streamMarketData(@PathVariable String symbol) {
        return marketDataService.streamMarketData(symbol);
    }
}