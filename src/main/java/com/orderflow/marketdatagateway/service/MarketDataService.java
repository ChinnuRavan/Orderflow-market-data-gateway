package com.orderflow.marketdatagateway.service;

import com.orderflow.marketdatagateway.exception.MarketDataNotFoundException;
import com.orderflow.marketdatagateway.model.MarketData;
import com.orderflow.marketdatagateway.model.OrderBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;

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


    public Flux<MarketData> streamMarketData(String symbol) {

        Random random = new Random();

        return Flux.interval(Duration.ofSeconds(1))
                .map(tick -> {

                    double price = 190 + random.nextDouble() * 20;

                    return new MarketData(
                            symbol.toUpperCase(),
                            Math.round(price * 100.0) / 100.0
                    );
                });
    }


    public Mono<OrderBook> getOrderBook(String symbol) {

        symbol = symbol.toUpperCase();

        double bidPrice = 198.20;
        double askPrice = 198.30;

        OrderBook orderBook =
                new OrderBook(symbol, bidPrice, askPrice);

        return Mono.just(orderBook);
    }
}