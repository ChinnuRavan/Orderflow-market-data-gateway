
# 📈 OrderFlow Market Data Gateway

A reactive Market Data Gateway built using **Spring Boot WebFlux** as part of the **OrderFlow Internship Project**. This application exposes REST APIs to provide market data in a reactive and non-blocking manner.

---

## 🚀 Features

- Reactive REST API using Spring WebFlux
- Layered Architecture (Controller & Service)
- Non-blocking programming with Reactor (`Mono`)
- Maven-based project
- Easy to extend for real-time market data integration

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot 4
- Spring WebFlux
- Maven
- Reactor (Mono)
- Git & GitHub

---

## 📂 Project Structure

```
market-data-gateway
│── src
│   ├── main
│   │   ├── java
│   │   │   └── com.orderflow.marketdatagateway
│   │   │       ├── controller
│   │   │       │    └── MarketDataController.java
│   │   │       ├── service
│   │   │       │    └── MarketDataService.java
│   │   │       └── MarketDataGatewayApplication.java
│   │   └── resources
│   │        └── application.properties
│   └── test
└── pom.xml
```

---

## ▶️ Getting Started

### Clone the Repository

```bash
git clone https://github.com/ChinnuRavan/Orderflow-market-data-gateway.git
```

### Navigate to the Project

```bash
cd Orderflow-market-data-gateway
```

### Run the Application

```bash
mvn spring-boot:run
```

The application starts on:

```
http://localhost:8080
```

---

## 🌐 API Endpoint

### Home Endpoint

**GET**

```
http://localhost:8080/
```

### Response

```
Market Data Gateway is Running
```

---

## 📌 Current Implementation

- Spring Boot WebFlux Project Setup
- REST Controller
- Service Layer
- Reactive Programming using `Mono`
- Git Version Control
- GitHub Integration

---

## 🔮 Future Enhancements

- Add MarketData Model
- Return JSON Response
- Integrate External Market Data API
- Exception Handling
- Logging
- Validation
- Unit Testing
- Docker Support

---

## 👩‍💻 Author

**Bezawada Naga Rajasri**

- GitHub: https://github.com/ChinnuRavan
- LinkedIn: https://www.linkedin.com/in/bezawada-naga-rajasri-4b303b416/

---

## ⭐ Support

If you like this project, consider giving it a ⭐ on GitHub.
