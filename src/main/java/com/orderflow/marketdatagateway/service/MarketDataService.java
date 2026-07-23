package com.orderflow.marketdatagateway.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MarketDataService {

    public Mono<String> getMarketStatus() {
        return Mono.just("Market Data Gateway is Running");
    }
}