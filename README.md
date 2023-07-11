# Watch Shop Application
This repository contains a comprehensive watch shop application built using Spring microservices architecture. The application consists of three projects: watchShopAPI, watchShopUI, and watchShopEurekaDiscoveryServer.

## Project Structure
1. watchShopAPI:
The watchShopAPI project serves as the backend API for the watch shop. It provides endpoints and services for managing various aspects of the watch shop, including watch models, manufacturers, pricing, and model reference numbers. The API is built using Spring Boot and follows RESTful principles for efficient communication with the frontend. The functionality of this API was tested via Postmand

2. watchShopUI:
The watchShopUI project is responsible for the frontend user interface of the watch shop. It utilises a web client for data validation and user interaction. The UI integrates with the watchShopAPI to retrieve watch data, display product information, and handle user actions such as adding, updating, and deleting watches from the database.

3. watchShopEurekaDiscoveryServer:
The watchShopEurekaDiscoveryServer project acts as the Eureka Discovery server, which facilitates service registration and discovery within the watch shop application. It provides a centralized registry where the watchShopAPI and watchShopUI can register themselves dynamically. This allows for seamless communication and load balancing between different components of the application.

## Getting Started
After cloning this repository, import each project as existing Maven projects and run all three as Spring Boot Apps in the following order: watchShopEurekaDiscoveryServer, watchShopAPI, watchShopUI. In your browser, type in localhost:8761 to see both applications registered on the Eureka Discovery Server. In a new tab, type in localhost:8087 to see the front-end functionality provided by the watchShopUI.
