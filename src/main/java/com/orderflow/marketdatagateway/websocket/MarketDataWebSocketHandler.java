package com.orderflow.marketdatagateway.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class MarketDataWebSocketHandler implements WebSocketHandler {

    private final Random random = new Random();

    private final String[] symbols = {
            "AAPL",
            "TSLA",
            "MSFT",
            "GOOGL"
    };

    @Override
    public Mono<Void> handle(WebSocketSession session) {

        Flux<String> marketData = Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> {

                    String symbol = symbols[random.nextInt(symbols.length)];
                    double price = 190 + random.nextDouble() * 20;

                    return String.format(
                            "{\"symbol\":\"%s\",\"price\":%.2f,\"timestamp\":\"%s\"}",
                            symbol,
                            price,
                            LocalDateTime.now()
                    );
                });

        return session.send(
                marketData.map(session::textMessage)
        );
    }
}