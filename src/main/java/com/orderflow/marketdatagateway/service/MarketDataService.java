package com.orderflow.marketdatagateway.service;

import com.orderflow.marketdatagateway.model.MarketData;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MarketDataService {

    public Mono<MarketData> getMarketData() {
        MarketData data = new MarketData("AAPL", 198.25);
        return Mono.just(data);
    }
}