package com.orderflow.marketdatagateway.service;

import com.orderflow.marketdatagateway.model.MarketData;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MarketDataService {

    public Mono<MarketData> getMarketData(String symbol) {

        double price;

        switch (symbol.toUpperCase()) {

            case "AAPL":
                price = 198.25;
                break;

            case "TSLA":
                price = 310.50;
                break;

            case "MSFT":
                price = 450.75;
                break;

            default:
                price = 100.00;
        }

        return Mono.just(new MarketData(symbol.toUpperCase(), price));
    }
}