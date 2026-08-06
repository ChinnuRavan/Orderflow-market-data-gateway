package com.orderflow.marketdatagateway.service;

import com.orderflow.marketdatagateway.exception.MarketDataNotFoundException;
import com.orderflow.marketdatagateway.model.MarketData;
import com.orderflow.marketdatagateway.model.Order;
import com.orderflow.marketdatagateway.model.OrderBook;
import com.orderflow.marketdatagateway.model.Trade;
import com.orderflow.marketdatagateway.model.Level2OrderBook;
import com.orderflow.marketdatagateway.model.PriceLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class MarketDataService {

    private static final Logger logger =
            LoggerFactory.getLogger(MarketDataService.class);

    private final List<Order> orders = new ArrayList<>();

    // GET MARKET DATA
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

        return Mono.just(new MarketData(symbol, price));
    }

    // STREAM MARKET DATA
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

    // STREAM TRADES
    public Flux<Trade> streamTrades(String symbol) {

        Random random = new Random();

        return Flux.interval(Duration.ofSeconds(1))
                .map(tick -> new Trade(
                        symbol.toUpperCase(),
                        Math.round((190 + random.nextDouble() * 20) * 100.0) / 100.0,
                        random.nextInt(500) + 1
                ));
    }

    // ORDER BOOK
    public Mono<OrderBook> getOrderBook(String symbol) {

        symbol = symbol.toUpperCase();

        OrderBook orderBook = new OrderBook(
                symbol,
                198.20,
                198.30
        );

        return Mono.just(orderBook);
    }

    // RECENT TRADES
    public Flux<Trade> getTrades(String symbol) {

        symbol = symbol.toUpperCase();

        return Flux.just(
                new Trade(symbol, 198.25, 100),
                new Trade(symbol, 198.40, 50),
                new Trade(symbol, 198.10, 75)
        );
    }

    // BUY ORDER
    public Mono<Order> placeBuyOrder(String symbol, int quantity) {

        Order order = new Order(
                UUID.randomUUID().toString(),
                symbol.toUpperCase(),
                "BUY",
                quantity,
                200.00,
                "PLACED"
        );

        orders.add(order);

        logger.info("Buy order placed: {}", order.getOrderId());

        return Mono.just(order);
    }

    // SELL ORDER
    public Mono<Order> placeSellOrder(String symbol, int quantity) {

        Order order = new Order(
                UUID.randomUUID().toString(),
                symbol.toUpperCase(),
                "SELL",
                quantity,
                200.00,
                "PLACED"
        );

        orders.add(order);

        logger.info("Sell order placed: {}", order.getOrderId());

        return Mono.just(order);
    }

    // GET ALL ORDERS
    public Flux<Order> getAllOrders() {
        return Flux.fromIterable(orders);
    }

    // GET ORDER BY ID
    public Mono<Order> getOrderById(String orderId) {

        return Flux.fromIterable(orders)
                .filter(order -> order.getOrderId().equals(orderId))
                .next();
    }
    public Mono<Level2OrderBook> getLevel2OrderBook(String symbol) {

    symbol = symbol.toUpperCase();

    List<PriceLevel> bids = new ArrayList<>();
    bids.add(new PriceLevel(198.20, 500));
    bids.add(new PriceLevel(198.10, 300));
    bids.add(new PriceLevel(198.00, 200));

    List<PriceLevel> asks = new ArrayList<>();
    asks.add(new PriceLevel(198.30, 450));
    asks.add(new PriceLevel(198.40, 250));
    asks.add(new PriceLevel(198.50, 150));

    Level2OrderBook orderBook =
            new Level2OrderBook(symbol, bids, asks);

    return Mono.just(orderBook);
}
    public Flux<Level2OrderBook> streamLevel2OrderBook(String symbol) {

    Random random = new Random();

    return Flux.interval(Duration.ofMillis(100))
            .map(tick -> {

                List<PriceLevel> bids = new ArrayList<>();
                bids.add(new PriceLevel(198.20 + random.nextDouble(), 500));
                bids.add(new PriceLevel(198.10 + random.nextDouble(), 300));
                bids.add(new PriceLevel(198.00 + random.nextDouble(), 200));

                List<PriceLevel> asks = new ArrayList<>();
                asks.add(new PriceLevel(198.30 + random.nextDouble(), 450));
                asks.add(new PriceLevel(198.40 + random.nextDouble(), 250));
                asks.add(new PriceLevel(198.50 + random.nextDouble(), 150));

                return new Level2OrderBook(
                        symbol.toUpperCase(),
                        bids,
                        asks
                );
            });
}
}