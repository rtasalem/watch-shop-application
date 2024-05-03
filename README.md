# Watch Shop Application
This repository contains a comprehensive watch shop application built using Spring microservices architecture. The application consists of three projects: watchShopAPI, watchShopUI, and watchShopEurekaDiscoveryServer.

## Background
This project was inspired by my time as a software developer trainee at FDM Group. For this project specifically I have applied my knowledge of Spring Boot and Microservices. 

## Libraries & Technologies
- **Eureka Server:** provides a centralised and dyncamic registry through which the watchShopAPI and watchShopUI are registered.
- **Spring Boot DevTools:** Makes the development process more efficient by automatically restarting the applications whenever code changes are made.
- **Spring Web:** Used to handle HTTP requests.
- **Spring Reactive Web:** An extension of the Spring Framework to allow for increased scalability and responsiveness when building web applications.
- **Spring Data JPA:** Helps to simplify interactions with relational databases and enables entities to be defined/modeled through Java classes (hence the VideoGame class in the model package).
- **H2 Database:** H2 (or Hibernate) is an in-memory database that makes it easier to map Java objects to tables.
- **Validation:** Used to implement data integrity. Validation sets standards for user inputs to ensure they meet specific criteria (e.g. in the VideoGame entity in the model package, some columns are marked with @NotBlank and @Size annotations to specificy that a column should not be left null and what minimun and maximum number of characters that a String should have).

## Learning Milestones
A feature of this project that was significant to my learning experience was the implementation of a Eureka Discovery Server. Originally developed by Netflix, Eureka was incorporated into this project for the purposes of service discovery and registration. This watch shop application was divided into smaller parts that each stand as independently deployable services. As communication is still required between these services, the Eureka Discovery Server acts as the centralised repository where microservices can register themselves when running. If any of the microservices fail or stop running, they are subsequently removed from the registry.

## Getting Started
After cloning this repository, import each project as existing Maven projects and run all three as Spring Boot Apps in the following order: watchShopEurekaDiscoveryServer, watchShopAPI, watchShopUI. In your browser, type in localhost:8761 to see both applications registered on the Eureka Discovery Server. In a new tab, type in localhost:8087 to see the front-end functionality provided by the watchShopUI.

### Project Structure
1. watchShopAPI:
The watchShopAPI project serves as the backend API for the watch shop. It provides endpoints and services for managing various aspects of the watch shop, including watch models, manufacturers, pricing, and model reference numbers. The API is built using Spring Boot and follows RESTful principles for efficient communication with the frontend. The functionality of this API was tested via Postmand

2. watchShopUI:
The watchShopUI project is responsible for the frontend user interface of the watch shop. It utilises a web client for data validation and user interaction. The UI integrates with the watchShopAPI to retrieve watch data, display product information, and handle user actions such as adding, updating, and deleting watches from the database.

3. watchShopEurekaDiscoveryServer:
The watchShopEurekaDiscoveryServer project acts as the Eureka Discovery server, which facilitates service registration and discovery within the watch shop application. It provides a centralised registry where the watchShopAPI and watchShopUI can register themselves dynamically. This allows for seamless communication and load balancing between different components of the application.

Testing that my commits are signed.