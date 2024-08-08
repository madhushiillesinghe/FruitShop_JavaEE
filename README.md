# Fruit Shop POS System

## Introduction

The Fruit Shop POS (Point of Sale) System is a comprehensive solution designed to streamline the operations of a fruit shop. This project leverages the power of modern web technologies to provide a user-friendly interface, robust backend support, and efficient data management.

### Technologies Used

- **Backend:** Java EE
- **Frontend:** HTML, CSS, JavaScript
- **Database:** MySQL
- **Communication:** AJAX

### Project Overview

This POS system enables efficient management of sales, inventory, and customer transactions in a fruit shop setting. The frontend, built with HTML, CSS, and JavaScript, offers an intuitive and responsive user interface. The backend, powered by Java EE, ensures reliable data processing and business logic execution. MySQL is utilized as the database to store and manage the system's data, ensuring data integrity and consistency. AJAX is employed to facilitate seamless asynchronous communication between the frontend and backend, allowing for real-time updates without the need to reload the page.

### Features

- **Sales Management:** Process transactions quickly and accurately.
- **Inventory Tracking:** Monitor stock levels and manage product information.
- **Customer Management:** Maintain customer records and purchase history.
- **Database Integration:** Use MySQL for efficient and reliable data storage and retrieval.
- **Real-Time Updates:** Utilize AJAX for efficient, real-time data communication.

This project demonstrates a cohesive integration of frontend and backend technologies, along with robust database management, to create a functional and efficient POS system tailored for a fruit shop.

## API Documentation

You can find the detailed API documentation [API Documentation](https://documenter.getpostman.com/view/35385949/2sA3s1oBiM).

## API Endpoints

Here is a brief description of the available API endpoints:

### 1. item

- **GET /item**
  - Description: Fetches a list of all items or Get an existing item by code.
  - Parameters: None
  - Response: A JSON array of items object or objects.

- **POST /item**
  - Description: Adds a new item.
  - Parameters: A JSON object containing the item details.
  - Response: The added item object.

- **PUT /item/{id}**
  - Description: Updates an existing item by ID.
  - Parameters: A JSON object containing the updated item details.
  - Response: The updated item object.

- **DELETE /item/{id}**
  - Description: Deletes a item by ID.
  - Parameters: None
  - Response: A success message.

### 2. Orders

- **GET /orders**
  - Description: Fetches a list of all orders.
  - Parameters: None
  - Response: A JSON array of order objects.

- **POST /orders**
  - Description: Creates a new order.
  - Parameters: A JSON object containing the order details.
  - Response: The created order object.

- **GET /orders/{id}**
  - Description: Fetches details of a specific order by ID.
  - Parameters: None
  - Response: The order object.


### 3. Customers

- **GET /customer**
  - Description: Fetches a list of all customers or .
  - Parameters: None
  - Response: A JSON array of customer objects.

- **POST /customer**
  - Description: Adds a new customer.
  - Parameters: A JSON object containing the customer details.
  - Response: The added customer object.

- **GET /customer/{id}**
  - Description: Fetches details of a specific customer by ID.
  - Parameters: None
  - Response: The customer object.

- **PUT /customer/{id}**
  - Description: Updates an existing customer by ID.
  - Parameters: A JSON object containing the updated customer details.
  - Response: The updated customer object.

- **DELETE /customer/{id}**
  - Description: Deletes a customer by ID.
  - Parameters: None
  - Response: A success message.

## Setup and Installation

1. Clone the repository.
2. Navigate to the project directory.
3. Build the backend using Maven or your preferred build tool.
4. Deploy the backend on a Java EE server.
5. Open the `index.html` file in your browser to start the frontend.

## Project Repository

You can find the frontend development project on GitHub [Frontend POS System](https://github.com/madhushiillesinghe/IJSE-POS.git).


## License


This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.




