# 🛒 E-Commerce Shopping Website

A monolithic full-stack web application developed using **Spring Boot** and **JSP**, focusing on backend architecture, robust database integration, and dynamic content rendering. This platform simulates a basic online shopping experience and supports essential e-commerce operations.

## 📌 Features

- User registration and login
- Product listing and details view
- Add to cart and cart management
- Order placement and confirmation
- Admin panel for product and order management
- Secure password storage and session management
- Backend validations and exception handling

## 💻 Technologies Used

### Backend
- **Java 17**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Hibernate**
- **MySQL** 

### Frontend
- **JSP / JSTL**
- **HTML / CSS**


### Tools & Others
- **Maven**
- **Git & GitHub**
- **Postman** (for API testing)
- ** Eclipse**

## 🛍️ Use Case

This application is designed to support small businesses and individual sellers in managing their online storefront. It enables users to browse and purchase products with ease, while offering administrators tools to manage inventory, track orders, and maintain user accounts — all in a streamlined and centralized system.


## 🏗️ Architecture

This application follows a **monolithic architecture** with layered design:

- **Controller Layer** – handles HTTP requests
- **Service Layer** – contains business logic
- **Repository Layer** – communicates with the database using JPA
- **Entity Layer** – represents the data model

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven
- MySQL

### Setup Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/jagadeeshbarla/E-commerce.git
   cd E-commerce
2. **Configure MySQL Database**
Update application.properties with your MySQL credentials.

3. **Build and Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
4. **Access the App**

User Portal: http://localhost:8080
Admin Portal: http://localhost:8080/admin


     
📃 License
This project is for educational purposes and is open-source under the MIT License.

