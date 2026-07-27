package com.orderflow.marketdatagateway.service;

import com.orderflow.marketdatagateway.exception.MarketDataNotFoundException;
import com.orderflow.marketdatagateway.model.MarketData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MarketDataService {

    private static final Logger logger = LoggerFactory.getLogger(MarketDataService.class);

    public Mono<MarketData> getMarketData(String symbol) {

        logger.info("Fetching market data for symbol: {}", symbol);

        if (symbol.equalsIgnoreCase("INVALID")) {
            logger.error("Market data not found for symbol: {}", symbol);
            throw new MarketDataNotFoundException(symbol);
        }

        MarketData data = new MarketData(symbol.toUpperCase(), 198.25);
        return Mono.just(data);
    }
}