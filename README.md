# 📈 Reactive Market Data Gateway

A reactive stock market data service built using **Spring Boot WebFlux**. This project provides REST APIs for market data, order book, trade history, and real-time streaming using **Project Reactor (Mono & Flux)** and **Server-Sent Events (SSE)**.

---

## 🚀 Features

- Get market data for stock symbols
- Support for multiple stocks (AAPL, TSLA, MSFT, GOOGL)
- Reactive programming with Mono and Flux
- Live Market Data Streaming
- Order Book API
- Trade History API
- Live Trade Streaming
- Custom Exception Handling
- Logging using SLF4J

---

## 🛠 Technologies Used

- Java 21
- Spring Boot
- Spring WebFlux
- Project Reactor
- Maven
- Git & GitHub

---

## 📂 Project Structure

```
src
├── controller
│   └── MarketDataController.java
├── service
│   └── MarketDataService.java
├── model
│   ├── MarketData.java
│   ├── OrderBook.java
│   └── Trade.java
├── exception
│   └── MarketDataNotFoundException.java
└── MarketDataGatewayApplication.java
```

---

## 📡 API Endpoints

### Get Market Data

```
GET /market-data/{symbol}
```

Example:

```
GET /market-data/AAPL
```

---

### Get Order Book

```
GET /market-data/orderbook/{symbol}
```

---

### Get Trade History

```
GET /market-data/trades/{symbol}
```

---

### Live Market Data Stream (SSE)

```
GET /market-data/stream/{symbol}
```

---

### Live Trade Stream (SSE)

```
GET /market-data/trades/stream/{symbol}
```

---

## ▶️ Running the Project

Clone the repository:

```bash
git clone https://github.com/ChinnuRavan/Orderflow-market-data-gateway.git
```

Go to the project folder:

```bash
cd Orderflow-market-data-gateway
```

Compile the project:

```bash
mvn compile
```

Run the application:

```bash
mvn spring-boot:run
```

The application starts at:

```
http://localhost:8080
```

---

## 👩‍💻 Author

**Bezawada Naga Rajasri**

GitHub:
https://github.com/ChinnuRavan

---

## 📌 Project Status

✅ Week 1 Completed

✅ Week 2 Completed

🚧 Week 3 In Progress
