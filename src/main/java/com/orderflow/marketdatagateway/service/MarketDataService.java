package com.orderflow.marketdatagateway.service;

import com.orderflow.marketdatagateway.exception.MarketDataNotFoundException;
import com.orderflow.marketdatagateway.model.MarketData;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MarketDataService {

    public Mono<MarketData> getMarketData(String symbol) {

        if (symbol.equalsIgnoreCase("INVALID")) {
            throw new MarketDataNotFoundException(symbol);
        }

        MarketData data = new MarketData(symbol.toUpperCase(), 198.25);
        return Mono.just(data);
    }
}