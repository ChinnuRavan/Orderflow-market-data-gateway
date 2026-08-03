package com.orderflow.marketdatagateway.controller;

import com.orderflow.marketdatagateway.model.MarketData;
import com.orderflow.marketdatagateway.model.Order;
import com.orderflow.marketdatagateway.model.OrderBook;
import com.orderflow.marketdatagateway.model.Trade;
import com.orderflow.marketdatagateway.service.MarketDataService;
import com.orderflow.marketdatagateway.model.Level2OrderBook;
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

    @GetMapping("/trades/{symbol}")
    public Flux<Trade> getTrades(@PathVariable String symbol) {
        return marketDataService.getTrades(symbol);
    }

    @GetMapping(value = "/trades/stream/{symbol}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Trade> streamTrades(@PathVariable String symbol) {
        return marketDataService.streamTrades(symbol);
    }

    @GetMapping(value = "/stream/{symbol}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MarketData> streamMarketData(@PathVariable String symbol) {
        return marketDataService.streamMarketData(symbol);
    }

    @PostMapping("/buy/{symbol}/{quantity}")
    public Mono<Order> placeBuyOrder(
            @PathVariable String symbol,
            @PathVariable int quantity) {

        return marketDataService.placeBuyOrder(symbol, quantity);
    }

    @PostMapping("/sell/{symbol}/{quantity}")
    public Mono<Order> placeSellOrder(
            @PathVariable String symbol,
            @PathVariable int quantity) {

        return marketDataService.placeSellOrder(symbol, quantity);
    }

    @GetMapping("/orders")
    public Flux<Order> getAllOrders() {
        return marketDataService.getAllOrders();
    }

    @GetMapping("/orders/{orderId}")
    public Mono<Order> getOrderById(@PathVariable String orderId) {
        return marketDataService.getOrderById(orderId);
    }

    @GetMapping("/level2/{symbol}")
    public Mono<Level2OrderBook> getLevel2OrderBook(@PathVariable String symbol) {
        return marketDataService.getLevel2OrderBook(symbol);
    }

    @GetMapping(value = "/level2/stream/{symbol}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Level2OrderBook> streamLevel2OrderBook(@PathVariable String symbol) {
        return marketDataService.streamLevel2OrderBook(symbol);
    }
}