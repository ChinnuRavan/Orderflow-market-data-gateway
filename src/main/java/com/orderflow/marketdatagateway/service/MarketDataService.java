package com.orderflow.marketdatagateway.service;

import com.orderflow.marketdatagateway.exception.MarketDataNotFoundException;
import com.orderflow.marketdatagateway.model.MarketData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MarketDataService {

    private static final Logger logger =
            LoggerFactory.getLogger(MarketDataService.class);

    public Mono<MarketData> getMarketData(String symbol) {

        logger.info("Fetching market data for symbol: {}", symbol);

        if (symbol.equalsIgnoreCase("INVALID")) {
            logger.error("Market data not found for symbol: {}", symbol);
            throw new MarketDataNotFoundException(symbol);
        }

        symbol = symbol.toUpperCase();

        double price;

        switch (symbol) {
            case "AAPL":
                price = 198.25;
                break;

            case "TSLA":
                price = 315.80;
                break;

            case "MSFT":
                price = 512.40;
                break;

            case "GOOGL":
                price = 186.15;
                break;

            default:
                price = 100.00;
        }

        MarketData data = new MarketData(symbol, price);

        return Mono.just(data);
    }
}