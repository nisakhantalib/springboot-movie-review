# Movie Review API

A Spring Boot application that manages movie details and user reviews. This project demonstrates the implementation of a RESTful API using Spring Boot with MongoDB as the database.

## Technologies Used
- Spring Boot 3.1.5
- MongoDB
- Lombok
- Maven
- Java 21

## Features
- Movie management (CRUD operations)
- Review system with references to movies
- RESTful API endpoints
- MongoDB document references implementation

## API Endpoints

### Movies
- GET `/api/v1/movies` - Get all movies
- GET `/api/v1/movies/{imdbId}` - Get a specific movie by IMDB ID

### Reviews
- POST `/api/v1/reviews` - Create a new review for a movie

## Setup and Installation
1. Clone the repository
2. Configure MongoDB connection in `application.properties`
3. Run the application using Maven: `mvn spring:boot run`

## Project Structure