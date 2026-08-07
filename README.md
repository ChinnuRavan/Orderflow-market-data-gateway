# 📈 Reactive Market Data Gateway

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.7-brightgreen)
![Spring WebFlux](https://img.shields.io/badge/Spring-WebFlux-blue)
![WebSocket](https://img.shields.io/badge/WebSocket-Enabled-success)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![GitHub](https://img.shields.io/badge/GitHub-Project-black)

A **Reactive Stock Market Data Gateway** built using **Spring Boot WebFlux**. This project simulates real-time stock market data through REST APIs, Server-Sent Events (SSE), and WebSocket streaming using **Project Reactor (Mono & Flux)**.

---

# 🚀 Features

- 📊 Get Market Data by Stock Symbol
- 📈 Simulated Real-Time Stock Prices
- ⚡ Reactive Programming with Mono & Flux
- 🌊 Live Market Data Streaming (SSE)
- 📖 Level 2 Order Book
- 💹 Trade History API
- 🔄 Live Trade Streaming
- 🌐 WebSocket Live Streaming
- ⚠ Global Exception Handling
- 📝 SLF4J Logging
- 🧩 Clean Layered Architecture

---

# 🛠 Technologies Used

- Java 21
- Spring Boot 4.0.7
- Spring WebFlux
- Project Reactor
- WebSocket
- Maven
- Git & GitHub
- IntelliJ IDEA / VS Code

---

# 📂 Project Structure

```text
market-data-gateway
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.orderflow.marketdatagateway
│   │   │       ├── controller
│   │   │       │     └── MarketDataController.java
│   │   │       │
│   │   │       ├── service
│   │   │       │     └── MarketDataService.java
│   │   │       │
│   │   │       ├── model
│   │   │       │     ├── MarketData.java
│   │   │       │     ├── Order.java
│   │   │       │     ├── PriceLevel.java
│   │   │       │     └── Level2OrderBook.java
│   │   │       │
│   │   │       ├── websocket
│   │   │       │     └── MarketDataWebSocketHandler.java
│   │   │       │
│   │   │       ├── config
│   │   │       │     └── WebSocketConfig.java
│   │   │       │
│   │   │       ├── exception
│   │   │       │     ├── GlobalExceptionHandler.java
│   │   │       │     └── MarketDataNotFoundException.java
│   │   │       │
│   │   │       └── MarketDataGatewayApplication.java
│   │   │
│   │   └── resources
│   │         └── application.properties
│   │
│   └── test
│
├── pom.xml
└── README.md
```
---

## 🏗️ Project Architecture

```
                Client
                   │
                   ▼
      Spring WebFlux Controller
                   │
                   ▼
        MarketDataService
                   │
        ┌──────────┴──────────┐
        ▼                     ▼
   REST APIs             WebSocket / SSE
        │                     │
        └──────────┬──────────┘
                   ▼
          Reactive Data Stream
```

This project uses a reactive architecture powered by Spring WebFlux and Project Reactor. REST endpoints return `Mono` and `Flux`, while WebSocket and SSE provide real-time streaming to connected clients.

---

---

# 📡 REST API Endpoints

## Get Market Data

```http
GET /market-data/{symbol}
```

Example

```http
GET /market-data/AAPL
```

Sample Response

```json
{
  "symbol": "AAPL",
  "price": 203.45
}
```

---

## Get Level 2 Order Book

```http
GET /market-data/orderbook/{symbol}
```

Sample Response

```json
{
  "symbol":"AAPL",
  "bids":[
    {"price":199.50,"volume":500},
    {"price":199.25,"volume":300}
  ],
  "asks":[
    {"price":200.10,"volume":400},
    {"price":200.30,"volume":200}
  ]
}
```

---

## Get Trade History

```http
GET /market-data/trades/{symbol}
```

---

## Live Market Data Stream (SSE)

```http
GET /market-data/stream/{symbol}
```

---

## Live Trade Stream (SSE)

```http
GET /market-data/trades/stream/{symbol}
```

---

# 🌐 WebSocket Endpoint

Connect using

```text
ws://localhost:8080/ws/market-data
```

Example Output

```json
{
  "symbol":"AAPL",
  "price":203.78,
  "timestamp":"2026-08-06T09:09:20"
}
```

```json
{
  "symbol":"MSFT",
  "price":206.23,
  "timestamp":"2026-08-06T09:09:21"
}
```

---

# ▶️ Running the Project

### Clone Repository

```bash
git clone https://github.com/ChinnuRavan/Orderflow-market-data-gateway.git
```

### Navigate to Project

```bash
cd Orderflow-market-data-gateway
```

### Compile

```bash
mvn clean compile
```

### Run

```bash
mvn spring-boot:run
```

Application runs at

```text
http://localhost:8080
```

---

# 🧪 Testing

### REST APIs

Use

- Postman

---

### WebSocket

Use

- Postman WebSocket
- Hoppscotch
- WebSocket King Client

Endpoint

```text
ws://localhost:8080/ws/market-data
```

---

# 📷 Screenshots

> Add your screenshots inside an `images` folder.

```
images/
├── application-running.png
├── rest-api.png
├── websocket-stream.png
├── orderbook-api.png
└── sse-stream.png
```

Example

```md
![Application](images/application-running.png)

![REST API](images/rest-api.png)

![WebSocket](images/websocket-stream.png)
```

---

# 📚 Learning Outcomes

- Spring Boot WebFlux
- Reactive Programming
- Mono & Flux
- REST APIs
- Server-Sent Events (SSE)
- WebSocket Communication
- Exception Handling
- SLF4J Logging
- Maven Build
- Git & GitHub

---

# 📌 Project Status

- ✅ Week 1 – REST APIs
- ✅ Week 2 – SSE & Order Book
- ✅ Week 3 – Exception Handling & Logging
- ✅ Week 4 – WebSocket Streaming
- 🚧 Week 5 – In Progress

---

# 👩‍💻 Author

**Bezawada Naga Rajasri**

GitHub:  
https://github.com/ChinnuRavan

---

# ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.